package com.burger.requests;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class OrderRequest {

	@NotEmpty
	private List<IngredientRequest> ingredients;

	@NotBlank(message = "Invalid phone number")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNumber;

	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Price is required")
	private String price;
}
