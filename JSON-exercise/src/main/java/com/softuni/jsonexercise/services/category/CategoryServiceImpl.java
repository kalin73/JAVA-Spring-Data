package com.softuni.jsonexercise.services.category;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.softuni.jsonexercise.constant.Utils.*;
import static com.softuni.jsonexercise.constant.JsonFiles.*;

import org.springframework.stereotype.Service;

import com.softuni.jsonexercise.domain.dtos.categories.CategoryProductsSummaryDto;
import com.softuni.jsonexercise.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryProductsSummaryDto> getCategoriesSummary() throws IOException {
		final List<CategoryProductsSummaryDto> summary = this.categoryRepository.getCategoriesSummary()
				.orElseThrow(NoSuchElementException::new);

		writeJsonIntoFile(summary, CATEGORIES_BY_PRODUCTS);

		return summary;
	}

}
