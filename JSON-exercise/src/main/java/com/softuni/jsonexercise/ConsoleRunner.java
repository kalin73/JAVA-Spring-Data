package com.softuni.jsonexercise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.softuni.jsonexercise.services.SeedService;
import com.softuni.jsonexercise.services.category.CategoryService;
import com.softuni.jsonexercise.services.product.ProductService;
import com.softuni.jsonexercise.services.user.UserService;

@Component
public class ConsoleRunner implements CommandLineRunner {
	private final SeedService seedService;
	private final UserService userService;
	private final ProductService productService;
	private final CategoryService categoryService;

	public ConsoleRunner(SeedService seedService, ProductService productService, UserService userService,
			CategoryService categoryService) {
		this.seedService = seedService;
		this.productService = productService;
		this.userService = userService;
		this.categoryService = categoryService;
	}

	@Override
	public void run(String... args) throws Exception {
		// this.seedService.seedAll();
		// this.productService.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500),
		// BigDecimal.valueOf(1000));

		// this.userService.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName();

		// this.categoryService.getCategoriesSummary();

		 this.userService.usersAndProducts();

	}

}
