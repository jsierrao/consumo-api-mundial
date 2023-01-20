package com.consumo.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;



@Data
public class TeamResponse {
	
	private String status;
	
	@JsonProperty("data")
	private List<Team> teams;

}
