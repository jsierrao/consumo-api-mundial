package com.consumo.api.service;

import com.consumo.api.model.TeamResponse;

public interface TeamService {
	TeamResponse findAll(String token);
}
