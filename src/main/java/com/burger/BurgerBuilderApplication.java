package com.burger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.burger")
@EnableAutoConfiguration
public class BurgerBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerBuilderApplication.class, args);
	}

}
