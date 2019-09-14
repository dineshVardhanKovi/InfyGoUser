package com.dinesh.infyGo.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.infyGo.user.constants.InfyGoUserConstants;
import com.dinesh.infyGo.user.dto.UserDTO;
import com.dinesh.infyGo.user.response.UserDetailsResponse;
import com.dinesh.infyGo.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = InfyGoUserConstants.BASE_PATH + InfyGoUserConstants.USERS_BASE_PATH)
@Slf4j
public class InfyGoUserControler {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{userId}",produces = "application/json",method = RequestMethod.GET)
	public ResponseEntity<UserDetailsResponse> getUserDetails(@PathVariable("userId") String userId){
		ResponseEntity<UserDetailsResponse> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<UserDetailsResponse>(userService.getUserDetails(userId), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in InfyGoUserControler.getUserDetails()", e.getMessage());
			responseEntity = new ResponseEntity<UserDetailsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@RequestMapping( produces = "application/json" , method = RequestMethod.GET)
	public ResponseEntity<UserDetailsResponse> getUserDetails(){
		ResponseEntity<UserDetailsResponse> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<UserDetailsResponse>(userService.getAllUsers(),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in InfyGoUserControler.getUserDetails()", e.getMessage());
			responseEntity = new ResponseEntity<UserDetailsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@RequestMapping(consumes = "application/json" , produces = "application/json" , method = RequestMethod.POST)
	public ResponseEntity<UserDetailsResponse> addUser(@RequestBody List<UserDTO> userDTOs){
		ResponseEntity<UserDetailsResponse> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<UserDetailsResponse>(userService.addUser(userDTOs),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in InfyGoUserControler.addUser()", e.getMessage());
			responseEntity = new ResponseEntity<UserDetailsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@RequestMapping(consumes = "application/json" , produces = "application/json" , method = RequestMethod.PUT)
	public ResponseEntity<UserDetailsResponse> updateUserDetails(@RequestBody List<UserDTO> userDTOs){
		return addUser(userDTOs);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId){
		ResponseEntity<String> responseEntity = null;
		try {
			userService.deleteUser(userId);
			responseEntity = new ResponseEntity<String>("User deleted succesfully " ,HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in InfyGoUserControler.addUser()", e.getMessage());
			responseEntity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
