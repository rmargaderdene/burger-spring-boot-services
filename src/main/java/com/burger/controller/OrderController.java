package com.burger.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burger.domain.Order;
import com.burger.service.OrderService;
import com.burger.validation.MapValidationErrorService;

@RestController
@RequestMapping(path = "/api/orders", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@Autowired
	private OrderService orderService;

	@PostMapping("")
	public ResponseEntity<?> addOrder(@Valid @RequestBody Order order, BindingResult result, Principal principal)
			throws UserPrincipalNotFoundException {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null)
			return errorMap;

		Order newOrder = orderService.saveOrder(order, principal.getName());
		return new ResponseEntity<Order>(newOrder, HttpStatus.CREATED);
	}

	@GetMapping("")
	public Iterable<Order> getOrdersByUsername(Principal principal) {
		return orderService.findOrdersByUser(principal.getName());
	}
}
