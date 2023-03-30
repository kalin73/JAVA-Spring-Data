package com.softuni.jsonexercise.services.product;

import static com.softuni.jsonexercise.constant.JsonFiles.PRODUCTS_WITHOUT_BUYERS_IN_RANGE_JSON;
import static com.softuni.jsonexercise.constant.JsonFiles.PRODUCTS_WITHOUT_BUYERS_IN_RANGE_XML;
import static com.softuni.jsonexercise.constant.Utils.modelMapper;
import static com.softuni.jsonexercise.constant.Utils.writeJsonIntoFile;
import static com.softuni.jsonexercise.constant.Utils.writeXmlIntoFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.softuni.jsonexercise.domain.dtos.products.ProductDto;
import com.softuni.jsonexercise.domain.dtos.products.ProductInRangeWithoutBuyerDto;
import com.softuni.jsonexercise.domain.dtos.products.wrappers.ProductsInRangeWithoutBuyerWrapperDto;
import com.softuni.jsonexercise.repositories.ProductRepository;

import jakarta.xml.bind.JAXBException;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	@Override
	public List<ProductInRangeWithoutBuyerDto> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low,
			BigDecimal high) throws IOException, JAXBException {
		List<ProductInRangeWithoutBuyerDto> products = this.productRepository
				.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(low, high).orElseThrow(NoSuchElementException::new)
				.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.map(ProductDto::toProductInRangeWithoutBuyerDto).collect(Collectors.toList());

		ProductsInRangeWithoutBuyerWrapperDto productsWrapper = new ProductsInRangeWithoutBuyerWrapperDto(products);

		writeJsonIntoFile(products, PRODUCTS_WITHOUT_BUYERS_IN_RANGE_JSON);

		writeXmlIntoFile(productsWrapper, PRODUCTS_WITHOUT_BUYERS_IN_RANGE_XML);

		return products;
	}

}
