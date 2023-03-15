package com.example.demo.Services;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.entities.Shampoo;

public interface ShampooService {
	List<Shampoo> findByIngredient(List<String> ingrediants);

	List<Shampoo> findBySizeOrLabelId(String size, long labelId);

	List<Shampoo> findWithPriceGreaterThan(BigDecimal price);

	long countWithPriceLowerThan(String price);

//	List<Shampoo> findWithIngredientCountLessThan(int count);
}
