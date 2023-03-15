package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Ingredient;

public interface IngredientService {
	List<Ingredient> selectByName(String name);

	List<Ingredient> selectByNames(List<String> names);

	void deleteByName(String name);

	void updatePrice();
}
