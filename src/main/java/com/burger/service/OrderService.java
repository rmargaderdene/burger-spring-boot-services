package com.burger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger.data.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
}