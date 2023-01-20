package com.consumo.api.model;

import lombok.Data;

@Data
public class RegisterUserRequest {
	
	private String name;
	private String email;
	private String password;
	private String passwordConfirm;

}
