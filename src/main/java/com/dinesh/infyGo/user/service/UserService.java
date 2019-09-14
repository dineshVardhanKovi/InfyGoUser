package com.dinesh.infyGo.user.service;

import java.util.List;

import com.dinesh.infyGo.user.dto.UserDTO;
import com.dinesh.infyGo.user.response.UserDetailsResponse;

public interface UserService {
	UserDetailsResponse getUserDetails(String userId);
	
	UserDetailsResponse getAllUsers();
	
	UserDetailsResponse addUser(List<UserDTO> userDTOs);
	
	void deleteUser(String userId);
}
