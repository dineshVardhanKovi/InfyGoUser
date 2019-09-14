package com.dinesh.infyGo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.infyGo.user.constants.InfyGoUserConstants;
import com.dinesh.infyGo.user.response.UserDetailsReponse;
import com.dinesh.infyGo.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = InfyGoUserConstants.USER_BASE_PATH)
@Slf4j
public class InfyGoUserControler {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{userId}",produces = "application/json",method = RequestMethod.GET)
	public ResponseEntity<UserDetailsReponse> getUserDetails(@PathVariable("userId") String userId){
		ResponseEntity<UserDetailsReponse> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<UserDetailsReponse>(userService.getUserDetails(userId), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in InfyGoUserControler.getUserDetails()", e.getMessage());
			responseEntity = new ResponseEntity<UserDetailsReponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
