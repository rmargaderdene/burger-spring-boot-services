package com.burger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger.data.IngredientRepository;
import com.burger.data.OrderRepository;
import com.burger.data.OrderedIngredientRepository;
import com.burger.data.UserRepository;
import com.burger.domain.Ingredient;
import com.burger.domain.Order;
import com.burger.domain.OrderedIngredient;
import com.burger.domain.User;
import com.burger.requests.IngredientRequest;
import com.burger.requests.OrderRequest;
import com.burger.responses.OrderSaveResponse;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private IngredientRepository ingredientRepository;

	@Autowired
	private OrderedIngredientRepository orderedIngredientRepository;

	@Autowired
	private UserRepository userRepository;

	public OrderSaveResponse saveOrder(OrderRequest orderRequest, String username) throws Exception {
		try {
			OrderSaveResponse saveResponse = null;
			User user = userRepository.findByUsername(username);
			Order order = new Order();
			order.setUser(user);
			order.setUsername(user.getUsername());
			order.setPhoneNumber(orderRequest.getPhoneNumber());
			order.setAddress(orderRequest.getAddress());
			order.setPrice(orderRequest.getPrice());
			order = orderRepository.save(order);

			if (order.getId() != null) {
				for (IngredientRequest ingReq : orderRequest.getIngredients()) {
					Ingredient ingredient = ingredientRepository.findByName(ingReq.getName());
					if (ingredient != null) {
						OrderedIngredient orderedIngredient = new OrderedIngredient();
						orderedIngredient.setNumber(ingReq.getNumber());
						orderedIngredient.setOrder(order);
						orderedIngredient.setIngredient(ingredient);
						orderedIngredientRepository.save(orderedIngredient);
					}
				}
				saveResponse = new OrderSaveResponse();
				saveResponse.setOrderId(order.getId());
				saveResponse.setUsername(order.getUsername());
				saveResponse.setPhoneNumber(order.getPhoneNumber());
				saveResponse.setAddress(order.getAddress());
				saveResponse.setPrice(order.getPrice());
			}
			return saveResponse;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public Iterable<Order> findOrdersByUser(String username) {
		return orderRepository.findByUsername(username);
	}
}