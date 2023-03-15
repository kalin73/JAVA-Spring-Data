package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	List<Ingredient> findByNameStartsWith(String name);

	List<Ingredient> findByNameInOrderByPrice(List<String> names);

	void deleteByName(String name);

	@Query("UPDATE Ingredient AS i SET i.price = i.price * 1.10")
	@Modifying
	void updateAllPrice();

}
