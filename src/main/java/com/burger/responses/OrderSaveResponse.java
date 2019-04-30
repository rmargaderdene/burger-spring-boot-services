package com.burger.responses;

import lombok.Data;

@Data
public class OrderSaveResponse {
	private Long orderId;
	private String username;
	private String phoneNumber;
	private String address;
	private String price;

	public OrderSaveResponse() {
	}
}
