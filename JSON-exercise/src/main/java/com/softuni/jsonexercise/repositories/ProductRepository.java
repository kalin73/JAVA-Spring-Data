package com.softuni.jsonexercise.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softuni.jsonexercise.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<List<Product>> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high);
}
