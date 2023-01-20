package com.consumo.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginResponse {

	
	private String status;
	
	@JsonProperty("data")
	private RegisterDataUser registerDataUser;
}
