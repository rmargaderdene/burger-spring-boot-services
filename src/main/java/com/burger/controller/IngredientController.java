package com.burger.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burger.service.IngredientService;

@RestController
@RequestMapping(path = "/api/public/ingredients", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;

	@GetMapping("/prices")
	public Map<String, Double> getIngPrices(Principal principal) {
		return ingredientService.fetchInitPrices();
	}

	@GetMapping("/numbers")
	public Map<String, Integer> getInitialNumbers(Principal principal) {
		return ingredientService.fetchInitNumbers();
	}
}
