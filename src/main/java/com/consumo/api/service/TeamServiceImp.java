package com.consumo.api.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consumo.api.model.TeamResponse;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class TeamServiceImp extends AbstractClient implements TeamService{

	protected TeamServiceImp(RestTemplate restTemplate) {
		super(restTemplate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TeamResponse findAll(String token) {
		String url = baseUrl + "/team";
		HttpEntity<Void>RequestEntity = new HttpEntity<>(this.buildAuthToken(token));
		ResponseEntity<TeamResponse>response = restTemplate.exchange(url, HttpMethod.GET, RequestEntity, TeamResponse.class);
		if(response.getStatusCode().is2xxSuccessful()) {
			log.info("{}",response.getBody());
			return response.getBody();
		}
	  log.error("{}",response.getStatusCode());
	  throw new RuntimeException("error");
	
	}
    
}
