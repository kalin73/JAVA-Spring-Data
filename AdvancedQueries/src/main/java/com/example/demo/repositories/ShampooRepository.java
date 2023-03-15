package com.example.demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Shampoo;
import com.example.demo.entities.Size;

public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
	@Query("SELECT s from Shampoo AS s" + " JOIN s.ingredients AS i" + " WHERE i.name IN :ingredients")
	List<Shampoo> findByIngredients(List<String> ingredients);

	List<Shampoo> findBySizeOrLabelId(Size size, long labelId);

	List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

	long countByPriceLessThan(BigDecimal price);

//	@Query("SELECT s FROM Shampoo AS s WHERE s.ingredients.size < :count")
//	List<Shampoo> findByIngredientCountLessThan(int count);

}
