package com.softuni.jsonexercise.services;

import static com.softuni.jsonexercise.constant.JsonFiles.*;
import static com.softuni.jsonexercise.constant.Utils.*;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.softuni.jsonexercise.domain.dtos.categories.wrappers.CategoriesImportWrapperDto;
import com.softuni.jsonexercise.domain.dtos.products.wrappers.ProductsImportWrapperDto;
import com.softuni.jsonexercise.domain.dtos.users.wrappers.UsersImportWrapperDto;
import com.softuni.jsonexercise.domain.entities.Category;
import com.softuni.jsonexercise.domain.entities.Product;
import com.softuni.jsonexercise.domain.entities.User;
import com.softuni.jsonexercise.repositories.CategoryRepository;
import com.softuni.jsonexercise.repositories.ProductRepository;
import com.softuni.jsonexercise.repositories.UserRepository;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

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
	public void seedUsers() throws IOException, JAXBException {
		if (this.userRepository.count() == 0) {
			final FileReader fileReader = new FileReader(USER_XML);

//			List<User> users = Arrays.stream(gson.fromJson(fileReader, UserImportDto[].class))
//					.map(userImportDto -> modelMapper.map(userImportDto, User.class)).collect(Collectors.toList());

			final JAXBContext context = JAXBContext.newInstance(UsersImportWrapperDto.class);
			final Unmarshaller unmarshaller = context.createUnmarshaller();

			final UsersImportWrapperDto usersDto = (UsersImportWrapperDto) unmarshaller.unmarshal(fileReader);

			final List<User> users = usersDto.getUsers().stream().map(userDto -> modelMapper.map(userDto, User.class))
					.toList();

			this.userRepository.saveAllAndFlush(users);

			fileReader.close();
		}

	}

	@Override
	public void seedCategories() throws IOException, JAXBException {
		if (this.categorieRepository.count() == 0) {
			FileReader reader = new FileReader(CATEGORY_XML);
//
//			List<Category> catrgories = Arrays.stream(gson.fromJson(reader, CategoryImportDto[].class))
//					.map(category -> modelMapper.map(category, Category.class)).collect(Collectors.toList());
//
			final JAXBContext context = JAXBContext.newInstance(CategoriesImportWrapperDto.class);
			final Unmarshaller unmarshaller = context.createUnmarshaller();

			CategoriesImportWrapperDto categoriesDto = (CategoriesImportWrapperDto) unmarshaller.unmarshal(reader);

			List<Category> categories = categoriesDto.getCategories().stream()
					.map(category -> modelMapper.map(category, Category.class)).toList();

			this.categorieRepository.saveAllAndFlush(categories);

			reader.close();
		}
	}

	@Override
	public void seedProducts() throws IOException, JAXBException {
		if (this.productRepository.count() == 0) {
			FileReader reader = new FileReader(PRODUCT_XML);
//
//			List<Product> products = Arrays.stream(gson.fromJson(reader, ProductImportDto[].class))
//					.map(product -> modelMapper.map(product, Product.class)).map(this::setRandomSeller)
//					.map(this::setRandomBuyer).map(this::setRandomCategory).collect(Collectors.toList());
			final JAXBContext context = JAXBContext.newInstance(ProductsImportWrapperDto.class);
			final Unmarshaller unmarshaller = context.createUnmarshaller();

			final ProductsImportWrapperDto dto = (ProductsImportWrapperDto) unmarshaller.unmarshal(reader);

			final List<Product> products=	dto.getProducts()
				.stream()
				.map(productDto -> modelMapper.map(productDto, Product.class))
				.map(this::setRandomSeller)
				.map(this::setRandomBuyer)
				.map(this::setRandomCategory)
				.toList();
			
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
