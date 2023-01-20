package com.consumo.api.userServiceImpl;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.AbstractClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consumo.api.context.AppConfig;
import com.consumo.api.model.LoginRequest;
import com.consumo.api.model.LoginResponse;
import com.consumo.api.model.RegisterUserRequest;
import com.consumo.api.model.RegisteredUserResponse;
import com.consumo.api.service.AbstractClient;
import com.consumo.api.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImpl extends AbstractClient  implements UserService {
	
	protected UserServiceImpl(RestTemplate restTemplate) {
		super(restTemplate);
		
	}


	
	

	@Override
	public RegisteredUserResponse create(RegisterUserRequest user) {
		String uri = baseUrl + "/user";
		
			ResponseEntity<RegisteredUserResponse>res = restTemplate.postForEntity(uri,user, RegisteredUserResponse.class);
			if(res.getStatusCode().is2xxSuccessful()) {
				log.info("Succesfully user creation: {}",res.getBody());
				return res.getBody();
			}
		log.error("error in user creation{}",res.getStatusCode());
		throw new RuntimeException("Error");
		
	}

	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		String url = baseUrl + "/user/login";
		ResponseEntity<LoginResponse>response = restTemplate.postForEntity(url, loginRequest, LoginResponse.class);
		if(response.getStatusCode().is2xxSuccessful()) {
			log.info("{}",response.getBody());
			return response.getBody();
		}
		
		log.error("{}",response.getStatusCode());
		throw new RuntimeException("error");
	}


	


	



}
