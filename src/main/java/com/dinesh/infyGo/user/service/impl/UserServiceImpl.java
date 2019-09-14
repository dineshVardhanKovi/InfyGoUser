package com.dinesh.infyGo.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.infyGo.user.dto.UserDTO;
import com.dinesh.infyGo.user.entity.User;
import com.dinesh.infyGo.user.repository.UserRepository;
import com.dinesh.infyGo.user.response.UserDetailsResponse;
import com.dinesh.infyGo.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DozerBeanMapper beanMapper;
	UserDetailsResponse userDetailsReponse = new UserDetailsResponse();

	@Override
	public UserDetailsResponse getUserDetails(String userId) {
		try {
			Optional<User> user = userRepository.findById(userId);
			if(user.isPresent()) {
				UserDTO userDTO = beanMapper.map(user.get(), UserDTO.class);
				List<UserDTO> users = new ArrayList<>();
				users.add(userDTO);
				userDetailsReponse.setUsers(users);
			}
		} catch (Exception e) {
			log.error("Error occured in UserServiceImpl.getUserDetails() : " + e.getMessage());
			throw e;
		}
		return userDetailsReponse;
	}

	@Override
	public UserDetailsResponse getAllUsers() {
		try {
			List<User> users = userRepository.findAll();
			List<UserDTO> userDTOs = new ArrayList<>();
			users.forEach(user -> {
				userDTOs.add(beanMapper.map(user, UserDTO.class));	
			});
			userDetailsReponse.setUsers(userDTOs);
		} catch (Exception e) {
			log.error("Error occured in UserServiceImpl.getAllUsers() : " + e.getMessage());
			throw e;
		}
		return userDetailsReponse;
	}

	@Override
	public UserDetailsResponse addUser(List<UserDTO> userDTOs) {
		try {	
			List<User> users = new ArrayList<>();
			userDTOs.forEach(userDTO -> {
				users.add(beanMapper.map(userDTO, User.class));	
			});		
			userRepository.saveAll(users);
			userDetailsReponse.setUsers(userDTOs);
		} catch (Exception e) {
			log.error("Error occured in UserServiceImpl.addUser() : " + e.getMessage());
			throw e;
		}
		return userDetailsReponse;
	}

	@Override
	public void deleteUser(String userId) {
		try {
			userRepository.deleteById(userId);
		} catch (Exception e) {
			log.error("Error occured in UserServiceImpl.deleteUser() : " + e.getMessage());
			throw e;
		}
	}

}
