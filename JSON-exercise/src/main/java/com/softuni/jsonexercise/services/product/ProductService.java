package com.softuni.jsonexercise.services.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.softuni.jsonexercise.domain.dtos.products.ProductInRangeWithoutBuyerDto;

public interface ProductService {
	List<ProductInRangeWithoutBuyerDto> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low,
			BigDecimal high) throws IOException;
}
