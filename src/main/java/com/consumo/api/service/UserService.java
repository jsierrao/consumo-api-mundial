package com.consumo.api.service;

import com.consumo.api.model.LoginRequest;
import com.consumo.api.model.LoginResponse;
import com.consumo.api.model.RegisterUserRequest;
import com.consumo.api.model.RegisteredUserResponse;

public interface UserService {

	RegisteredUserResponse create(RegisterUserRequest user);
	
	
	LoginResponse login(LoginRequest loginRequest);
	
	
	
}
