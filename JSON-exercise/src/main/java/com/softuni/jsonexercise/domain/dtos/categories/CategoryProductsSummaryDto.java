package com.softuni.jsonexercise.domain.dtos.categories;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class CategoryProductsSummaryDto {
	@Expose
	private String name;

	@Expose
	private Long productsCount;

	@Expose
	private Double avgPrice;

	@Expose
	private BigDecimal totalRevenue;

	public CategoryProductsSummaryDto() {

	}

	public CategoryProductsSummaryDto(String name, Long productsCount, Double avgPrice, BigDecimal totalRevenue) {
		this.name = name;
		this.productsCount = productsCount;
		this.avgPrice = avgPrice;
		this.totalRevenue = totalRevenue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProductsCount() {
		return productsCount;
	}

	public void setProductsCount(Long productsCount) {
		this.productsCount = productsCount;
	}

	public Double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

}
