package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Services.IngredientService;

@Component
public class ConsoleRunner implements CommandLineRunner {

	private final IngredientService ingredientService;

	public ConsoleRunner(IngredientService ingredientService) {

		this.ingredientService = ingredientService;
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		this.ingredientService.updatePrice();
		sc.close();
	}

}
