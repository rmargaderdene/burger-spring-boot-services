package com.burger.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burger.services.IngredientService;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IngredientController {
	@Autowired
	private IngredientService ingredientService;

	@GetMapping("/prices")
	public Map<String, Integer> getAllIngredients() {
		return ingredientService.findAll();
	}
}
