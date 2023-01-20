package com.consumo.api.userServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.consumo.api.model.LoginRequest;
import com.consumo.api.model.LoginResponse;
import com.consumo.api.model.RegisterUserRequest;
import com.consumo.api.model.RegisteredUserResponse;
import com.consumo.api.model.TeamResponse;
import com.consumo.api.service.TeamService;
import com.consumo.api.service.UserService;
import com.consumo.api.service.UserServiceFeign;


@Service
@Primary
public class UserFeignImp implements  UserService, TeamService{
	
	@Autowired
	private UserServiceFeign service;

	@Override
	public RegisteredUserResponse create(RegisterUserRequest user) {
		// TODO Auto-generated method stub
		return service.registro(user);
	}

	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		return service.login(loginRequest);
	}

	@Override
	public TeamResponse findAll(String token) {
		// TODO Auto-generated method stub
		return service.findAll("Bearer "+token);
	}
	
	

	
}
