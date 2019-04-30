package com.burger.responses;

import lombok.Data;

@Data
public class JWTLoginSuccessResponse {
	private boolean success;
	private String token;
	private Integer expirationTime;

	public JWTLoginSuccessResponse(boolean success, String token, Integer expirationTime) {
		this.success = success;
		this.token = token;
		this.expirationTime = expirationTime;
	}
}
