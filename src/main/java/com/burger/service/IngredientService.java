package com.burger.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger.data.IngredientRepository;
import com.burger.domain.Ingredient;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;

	public Map<String, Double> fetchInitPrices() {
		HashMap<String, Double> ingPrices = new HashMap<String, Double>();
		ingredientRepository.findAll().forEach(ing -> {
			ingPrices.put(ing.getName(), ing.getPrice());
		});

		return ingPrices;
	}

	public Map<String, Integer> fetchInitNumbers() {
		HashMap<String, Integer> ingInitNumbers = new HashMap<String, Integer>();
		ingredientRepository.findAll().forEach(ing -> {
			ingInitNumbers.put(ing.getName(), (int) ing.getInitNumber());
		});

		return ingInitNumbers;
	}

	public Ingredient getIngredientByName(String name) {
		return ingredientRepository.findByName(name);
	}
}