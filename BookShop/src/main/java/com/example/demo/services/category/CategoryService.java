package com.example.demo.services.category;

import java.util.List;
import java.util.Set;

import com.example.demo.domain.entities.Category;

public interface CategoryService {
	void seedCategories(List<Category> categories);

	boolean isDataSeeded();

	Set<Category> getRandomCategories();
}
