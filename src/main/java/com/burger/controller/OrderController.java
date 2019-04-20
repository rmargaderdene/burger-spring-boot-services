package com.burger.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {

//	@PostMapping(consumes = "application/json")
//	public Order postOrder(@RequestBody Order order) {
//		return order
//	}
}
