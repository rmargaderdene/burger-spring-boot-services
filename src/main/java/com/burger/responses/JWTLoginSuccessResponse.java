package com.burger.responses;

import java.util.Date;

import lombok.Data;

@Data
public class JWTLoginSuccessResponse {
	private boolean success;
	private String token;
	private Date expirationTime;

	public JWTLoginSuccessResponse(boolean success, String token, Date expirationTime) {
		this.success = success;
		this.token = token;
		this.expirationTime = expirationTime;
	}
}
