package com.consumo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consumo.api.model.LoginRequest;
import com.consumo.api.model.LoginResponse;
import com.consumo.api.model.RegisterUserRequest;
import com.consumo.api.model.RegisteredUserResponse;
import com.consumo.api.model.TeamResponse;
import com.consumo.api.service.TeamService;
import com.consumo.api.service.UserService;

@RestController
public class UserController {

	
	private final UserService userService;
	private final TeamService service;

	public UserController(UserService userService,TeamService service) {
		super();
		this.userService = userService;
		this.service=service;
	}
	
	
	
	
	
	
	
	@PostMapping("/users")
	public RegisteredUserResponse registro(@RequestBody RegisterUserRequest registerUserRequest) {
		return this.userService.create(registerUserRequest);
	}
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		return this.userService.login(loginRequest);
	}
	
	@GetMapping("/teams")
	public TeamResponse findAll(@RequestHeader(name="x-token",required=true)String token) {
		return this.service.findAll(token);
	}
	
	
	
	
	
	
	
	
	
	
}
