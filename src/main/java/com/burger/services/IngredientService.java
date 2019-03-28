package com.burger.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger.repositories.IngredientRepository;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;

	public Map<String, Integer> findAll() {
		HashMap<String, Integer> ingPrices = new HashMap<String, Integer>();
		ingredientRepository.findAll().forEach(ing -> {
			ingPrices.put(ing.getName(), (int) ing.getPrice());
		});

		return ingPrices;
	}
}