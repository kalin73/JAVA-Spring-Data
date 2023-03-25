package com.softuni.jsonexercise.domain.dtos.products;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class ProductImportDto {
	@Expose
	private String name;

	@Expose
	private BigDecimal price;

	public ProductImportDto(String name, BigDecimal price) {

		this.name = name;
		this.price = price;
	}

	public ProductImportDto() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
