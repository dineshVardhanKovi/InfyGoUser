package com.dinesh.infyGo.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_details")
@Data
public class User {
	
	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNo;
}
