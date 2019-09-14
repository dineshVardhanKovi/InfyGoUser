package com.dinesh.infyGo.service.impl;

import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.infyGo.user.dto.UserDTO;
import com.dinesh.infyGo.user.entity.User;
import com.dinesh.infyGo.user.repository.UserRepository;
import com.dinesh.infyGo.user.response.UserDetailsReponse;
import com.dinesh.infyGo.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DozerBeanMapper beanMapper;
	
	@Override
	public UserDetailsReponse getUserDetails(String userId) {
		UserDetailsReponse userDetailsReponse = new UserDetailsReponse();
		UserDTO userDTO = null;
		try {
			Optional<User> user = userRepository.findById(userId);
			if(user.isPresent()) {
				userDTO = beanMapper.map(user.get(), UserDTO.class);
				userDetailsReponse.setUserDTO(userDTO);
			}
		} catch (Exception e) {
			log.error("Error occured in UserServiceImpl.getUserDetails() : " + e.getMessage());
			throw e;
		}
		return userDetailsReponse;
	}

}
