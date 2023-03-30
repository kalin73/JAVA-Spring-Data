package com.softuni.jsonexercise.services;

import java.io.IOException;

import jakarta.xml.bind.JAXBException;

public interface SeedService {
	void seedUsers() throws IOException, JAXBException;

	void seedCategories() throws IOException, JAXBException;

	void seedProducts() throws IOException, JAXBException;

	default void seedAll() throws IOException, JAXBException {
		seedUsers();
		seedCategories();
		seedProducts();
	}
}
