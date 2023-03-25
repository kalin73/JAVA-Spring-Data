package com.softuni.jsonexercise.domain.dtos.products;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class ProductInRangeWithoutBuyerDto {
	@Expose
	private String name;
	
	@Expose
	private BigDecimal price;
	
	@Expose
	private String seller;

	public ProductInRangeWithoutBuyerDto() {
		
	}

	public ProductInRangeWithoutBuyerDto(String name, BigDecimal price, String seller) {
		super();
		this.name = name;
		this.price = price;
		this.seller = seller;
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	
}
