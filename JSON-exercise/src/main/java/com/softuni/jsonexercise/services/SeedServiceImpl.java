package com.softuni.jsonexercise.services;

import static com.softuni.jsonexercise.constant.JsonFiles.*;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import static com.softuni.jsonexercise.constant.Utils.*;

import com.softuni.jsonexercise.domain.dtos.categories.CategoryImportDto;
import com.softuni.jsonexercise.domain.dtos.products.ProductImportDto;
import com.softuni.jsonexercise.domain.dtos.users.UserImportDto;
import com.softuni.jsonexercise.domain.entities.Category;
import com.softuni.jsonexercise.domain.entities.Product;
import com.softuni.jsonexercise.domain.entities.User;
import com.softuni.jsonexercise.repositories.CategoryRepository;
import com.softuni.jsonexercise.repositories.ProductRepository;
import com.softuni.jsonexercise.repositories.UserRepository;

@Service
public class SeedServiceImpl implements SeedService {
	private final UserRepository userRepository;
	private final CategoryRepository categorieRepository;
	private final ProductRepository productRepository;

	public SeedServiceImpl(UserRepository userRepository, CategoryRepository categorieRepository,
			ProductRepository productRepository) {
		this.userRepository = userRepository;
		this.categorieRepository = categorieRepository;
		this.productRepository = productRepository;
	}

	@Override
	public void seedUsers() throws IOException {
		if (this.userRepository.count() == 0) {
			final FileReader fileReader = new FileReader(USER_JSON);

			List<User> users = Arrays.stream(gson.fromJson(fileReader, UserImportDto[].class))
					.map(userImportDto -> modelMapper.map(userImportDto, User.class)).collect(Collectors.toList());

			this.userRepository.saveAllAndFlush(users);

			fileReader.close();
		}

	}

	@Override
	public void seedCategories() throws IOException {
		if (this.categorieRepository.count() == 0) {
			FileReader reader = new FileReader(CATEGORY_JSON);

			List<Category> products = Arrays.stream(gson.fromJson(reader, CategoryImportDto[].class))
					.map(category -> modelMapper.map(category, Category.class)).collect(Collectors.toList());

			this.categorieRepository.saveAllAndFlush(products);

			reader.close();
		}
	}

	@Override
	public void seedProducts() throws IOException {
		if (this.productRepository.count() == 0) {
			FileReader reader = new FileReader(PRODUCT_JSON);

			List<Product> products = Arrays.stream(gson.fromJson(reader, ProductImportDto[].class))
					.map(product -> modelMapper.map(product, Product.class)).map(this::setRandomSeller)
					.map(this::setRandomBuyer).map(this::setRandomCategory).collect(Collectors.toList());

			this.productRepository.saveAllAndFlush(products);

			reader.close();
		}

	}

	private Product setRandomBuyer(Product product) {
		if (BigDecimal.valueOf(700).compareTo(product.getPrice()) < 0) {
			User buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

			while (buyer.equals(product.getSeller())) {
				buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
			}
			product.setBuyer(buyer);

		}

		return product;
	}

	private Product setRandomSeller(Product product) {
		final User seller = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
		product.setSeller(seller);

		return product;
	}

	private Product setRandomCategory(Product product) {
		final Random random = new Random();

		final int numberOfCategories = random.nextInt((int) this.categorieRepository.count());

		Set<Category> categories = new HashSet<>();

		IntStream.rangeClosed(0, numberOfCategories).forEach(number -> {
			Category category = this.categorieRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
			categories.add(category);
		});

		product.setCategories(categories);

		return product;
	}
}
