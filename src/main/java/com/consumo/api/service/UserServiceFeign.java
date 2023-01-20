package com.consumo.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


import com.consumo.api.model.LoginRequest;
import com.consumo.api.model.LoginResponse;
import com.consumo.api.model.RegisterUserRequest;
import com.consumo.api.model.RegisteredUserResponse;
import com.consumo.api.model.TeamResponse;

import feign.Headers;

@FeignClient(name ="x",url="http://api.cup2022.ir/api/v1")
public interface UserServiceFeign {
	
	String AUTH_TOKEN = "Authorization";
	
	@PostMapping("/user")
	public RegisteredUserResponse registro(@RequestBody RegisterUserRequest registerUserRequest);
	
	@PostMapping("user/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest);
	
	@GetMapping("/team")
	@Headers(value = { "Content-Type: application/json" })
	public TeamResponse findAll(@RequestHeader(AUTH_TOKEN)String  Bearertoken);
	
	

}
