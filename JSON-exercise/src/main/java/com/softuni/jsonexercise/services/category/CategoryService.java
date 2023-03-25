package com.softuni.jsonexercise.services.category;

import java.io.IOException;
import java.util.List;

import com.softuni.jsonexercise.domain.dtos.categories.CategoryProductsSummaryDto;

public interface CategoryService {
	List<CategoryProductsSummaryDto> getCategoriesSummary() throws IOException;
}
