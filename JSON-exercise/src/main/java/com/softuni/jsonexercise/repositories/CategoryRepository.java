package com.softuni.jsonexercise.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softuni.jsonexercise.domain.dtos.categories.CategoryProductsSummaryDto;
import com.softuni.jsonexercise.domain.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query(value="SELECT * FROM `product_shop`.categories ORDER BY RAND () LIMIT 1", nativeQuery = true)
	Optional<Category>getRandomEntity();
	
	@Query("SELECT new com.softuni.jsonexercise.domain.dtos.categories.CategoryProductsSummaryDto"
			+ "(c.name, count(p.id), avg(p.price), sum(p.price)) "
			+ "FROM Product p "
			+ "JOIN p.categories c "
			+ "GROUP BY c.id "
			+ "ORDER BY COUNT(p.id)")
	Optional<List<CategoryProductsSummaryDto>> getCategoriesSummary();
}
