package com.softuni.jsonexercise.constant;

import java.io.File;
import java.nio.file.Path;

public enum JsonFiles {
	;
	public static final File USER_JSON = Path.of("src", "main", "resources", "dbContent", "users.json").toFile();
	
	public static final File PRODUCT_JSON = Path.of("src", "main", "resources", "dbContent", "products.json").toFile();
	
	public static final File CATEGORY_JSON = Path.of("src", "main", "resources", "dbContent", "categories.json").toFile();

	public static final File PRODUCTS_WUTHOUT_BUYERS_IN_RANGE = Path.of("src", "main", "resources", "outputs", "products-in-range.json").toFile();
	
	public static final File USERS_WITH_SOLD_PRODUCTS = Path.of("src", "main", "resources", "outputs", "users-sold-products.json").toFile();
	
	public static final File CATEGORIES_BY_PRODUCTS = Path.of("src", "main", "resources", "outputs", "categories-by-products.json").toFile();
	
	public static final File USERS_AND_PRODUCTS = Path.of("src", "main", "resources", "outputs", "users-and-products.json").toFile();	
}
