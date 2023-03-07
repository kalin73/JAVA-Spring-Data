package com.example.demo.services.category;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entities.Category;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void seedCategories(List<Category> categories) {
		this.categoryRepository.saveAll(categories);

	}

	@Override
	public boolean isDataSeeded() {
		return this.categoryRepository.count() > 0;
	}

	@Override
	public Set<Category> getRandomCategories() {
		long count = this.categoryRepository.count();
		if (count != 0) {
			long randomAuthorId = new Random().nextLong(1, count);
			return Set.of(this.categoryRepository.findById(randomAuthorId).orElseThrow(NoSuchElementException::new));
		}
		throw new RuntimeException();
	}

}
