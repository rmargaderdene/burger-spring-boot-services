package com.burger.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger.data.OrderRepository;
import com.burger.data.UserRepository;
import com.burger.domain.Order;
import com.burger.domain.User;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	public Order saveOrder(Order order, String username) throws UserPrincipalNotFoundException {
		try {
			User user = userRepository.findByUsername(username);
			order.setUsername(user.getUsername());
			return orderRepository.save(order);
		} catch (Exception ex) {
			throw new UserPrincipalNotFoundException(username + "not found exception.");
		}
	}

	public Iterable<Order> findOrdersByUser(String username) {
		return orderRepository.findByUsername(username);
	}
}