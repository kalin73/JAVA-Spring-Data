package com.softuni.jsonexercise.domain.dtos.products;

import java.util.List;

import com.google.gson.annotations.Expose;

public class ProductsSoldWithCountDto {
	@Expose
	private Integer count;

	@Expose
	private List<ProductBasicInfoDto> products;

	public ProductsSoldWithCountDto() {
		super();
	}

	public ProductsSoldWithCountDto(List<ProductBasicInfoDto> products) {
		super();
		this.products = products;
		this.count = products.size();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<ProductBasicInfoDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBasicInfoDto> products) {
		this.products = products;
	}

}
