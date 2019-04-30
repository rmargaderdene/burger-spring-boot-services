package com.burger.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class IngredientRequest {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Number is required")
	private Integer number;
}
