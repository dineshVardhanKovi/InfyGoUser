package com.dinesh.infyGo.user.response;

import java.util.List;

import com.dinesh.infyGo.user.dto.UserDTO;

import lombok.Data;

@Data
public class UserDetailsResponse {
	private List<UserDTO> users;
}
