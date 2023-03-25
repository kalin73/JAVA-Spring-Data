package com.softuni.jsonexercise.services.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import static com.softuni.jsonexercise.constant.Utils.*;

import static com.softuni.jsonexercise.constant.JsonFiles.*;
import com.softuni.jsonexercise.domain.dtos.products.ProductDto;
import com.softuni.jsonexercise.domain.dtos.products.ProductInRangeWithoutBuyerDto;
import com.softuni.jsonexercise.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	@Override
	public List<ProductInRangeWithoutBuyerDto> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low,
			BigDecimal high) throws IOException {
		List<ProductInRangeWithoutBuyerDto> products = this.productRepository
				.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(low, high).orElseThrow(NoSuchElementException::new)
				.stream()
				.map(product -> modelMapper.map(product, ProductDto.class))
				.map(ProductDto::toProductInRangeWithoutBuyerDto)
				.collect(Collectors.toList());

		writeJsonIntoFile(products, PRODUCTS_WUTHOUT_BUYERS_IN_RANGE);

		return products;
	}

}
