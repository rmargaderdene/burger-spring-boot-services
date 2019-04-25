package com.burger.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Data
public class YAMLConfig {
	private String userApiUrl;
	private String publicApiUrl;
	private String jwtSecretKey;
	private String tokePrefix;
	private String headerString;
	private String expirationTime;
}
