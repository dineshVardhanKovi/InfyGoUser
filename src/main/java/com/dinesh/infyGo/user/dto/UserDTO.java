package com.dinesh.infyGo.user.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDTO {
	
	@NotNull(message = "userId cannot be null")
	private String userId;

	@NotNull(message = "password cannot be null")
	private String password;

	private String name;

	private String city;

	private String email;

	@Size(min = 10, max = 10,message = "phoneNo should be 10 digits")
	private String phoneNo;
	
}
