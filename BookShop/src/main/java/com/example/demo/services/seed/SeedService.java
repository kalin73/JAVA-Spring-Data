package com.example.demo.services.seed;

import java.io.IOException;

public interface SeedService {
	void seedAuthors() throws IOException;

	void seedCategories() throws IOException;

	void seedBooks() throws IOException;

	default void seedAllData() throws IOException {
		seedAuthors();
		seedCategories();
		seedBooks();
	}
}
