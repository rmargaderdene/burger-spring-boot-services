package com.burger.security;

import org.springframework.beans.factory.annotation.Autowired;

import com.burger.utils.YAMLConfig;

public class SecurityConstants {

	@Autowired
	private YAMLConfig myConfig;

	public static final String SIGN_UP_URLS = "/api/users/**";
	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final long EXPIRATION_TIME = 300_000; // 30 seconds
}
