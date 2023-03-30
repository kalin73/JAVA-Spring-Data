package com.softuni.jsonexercise.constant;

import java.io.File;
import java.nio.file.Path;

public enum JsonFiles {
	;
	public static final File USER_JSON = Path.of("src", "main", "resources", "dbContent", "JSONs", "users.json")
			.toFile();

	public static final File PRODUCT_JSON = Path.of("src", "main", "resources", "dbContent", "JSONs", "products.json")
			.toFile();

	public static final File CATEGORY_JSON = Path
			.of("src", "main", "resources", "dbContent", "JSONs", "categories.json").toFile();

	public static final File USER_XML = Path.of("src", "main", "resources", "dbContent", "XMLs", "users.xml").toFile();

	public static final File PRODUCT_XML = Path.of("src", "main", "resources", "dbContent", "XMLs", "products.xml")
			.toFile();

	public static final File CATEGORY_XML = Path.of("src", "main", "resources", "dbContent", "XMLs", "categories.xml")
			.toFile();

	public static final File PRODUCTS_WITHOUT_BUYERS_IN_RANGE_JSON = Path
			.of("src", "main", "resources", "outputs", "JSONs", "products-in-range.json").toFile();

	public static final File USERS_WITH_SOLD_PRODUCTS_JSON = Path
			.of("src", "main", "resources", "outputs", "JSONs", "users-sold-products.json").toFile();

	public static final File CATEGORIES_BY_PRODUCTS_JSON = Path
			.of("src", "main", "resources", "outputs", "JSONs", "categories-by-products.json").toFile();

	public static final File USERS_AND_PRODUCTS_JSON = Path
			.of("src", "main", "resources", "outputs", "JSONs", "users-and-products.json").toFile();
	
	
	public static final File PRODUCTS_WITHOUT_BUYERS_IN_RANGE_XML = Path
			.of("src", "main", "resources", "outputs", "XMLs", "products-in-range.xml").toFile();

	public static final File USERS_WITH_SOLD_PRODUCTS_XML  = Path
			.of("src", "main", "resources", "outputs", "XMLs", "users-sold-products.xml").toFile();

	public static final File CATEGORIES_BY_PRODUCTS_XML  = Path
			.of("src", "main", "resources", "outputs", "XMLs", "categories-by-products.xml").toFile();

	public static final File USERS_AND_PRODUCTS_XML  = Path
			.of("src", "main", "resources", "outputs", "XMLs", "users-and-products.xml").toFile();
	
}
