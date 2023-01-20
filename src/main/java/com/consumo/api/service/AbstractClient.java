package com.consumo.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient {
	
	
	@Value(value = "${worldcup-base-url}")
	protected String baseUrl;
	
	protected final RestTemplate restTemplate;
	
	protected AbstractClient(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	protected HttpHeaders buildAuthToken(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(token);
		return headers;
		
	}
	
	

}
