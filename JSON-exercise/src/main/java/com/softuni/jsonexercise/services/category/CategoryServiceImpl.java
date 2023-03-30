package com.softuni.jsonexercise.services.category;

import static com.softuni.jsonexercise.constant.JsonFiles.*;
import static com.softuni.jsonexercise.constant.Utils.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.softuni.jsonexercise.domain.dtos.categories.CategoryProductsSummaryDto;
import com.softuni.jsonexercise.domain.dtos.categories.wrappers.CategoriesProductSummaryWrapperDto;
import com.softuni.jsonexercise.repositories.CategoryRepository;

import jakarta.xml.bind.JAXBException;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryProductsSummaryDto> getCategoriesSummary() throws IOException, JAXBException {
		final List<CategoryProductsSummaryDto> summary = this.categoryRepository.getCategoriesSummary()
				.orElseThrow(NoSuchElementException::new);

		final CategoriesProductSummaryWrapperDto categories = new CategoriesProductSummaryWrapperDto(summary);
		
		writeXmlIntoFile(categories, CATEGORIES_BY_PRODUCTS_XML);

		writeJsonIntoFile(summary, CATEGORIES_BY_PRODUCTS_JSON);

		return summary;
	}

}
