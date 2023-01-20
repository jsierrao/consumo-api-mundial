package com.consumo.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Team {
	
	private String id;
	private String i_id;
	private String flag;
	@JsonProperty("iso2")
	private String country;
	
	@JsonProperty("name_en")
	private String name;
	
	@JsonProperty("fifa_code")
	private String fifaCode;
	
	@JsonProperty("groups")
	private String group;
	

}
