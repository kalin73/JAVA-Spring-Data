package com.softuni.jsonexercise.domain.dtos.products;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.softuni.jsonexercise.domain.dtos.categories.CategoryDto;
import com.softuni.jsonexercise.domain.dtos.users.UserDto;

public class ProductDto {
	@Expose
	private String name;

	@Expose
	private BigDecimal price;

	@Expose
	private UserDto buyer;

	@Expose
	private UserDto seller;

	@Expose
	private Set<CategoryDto> categories;

	public ProductDto() {
		this.categories = new HashSet<>();
	}

	public ProductDto(String name, BigDecimal price, UserDto buyer, UserDto seller) {
		this();
		this.name = name;
		this.price = price;
		this.buyer = buyer;
		this.seller = seller;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() < 3) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public UserDto getBuyer() {
		return buyer;
	}

	public void setBuyer(UserDto buyer) {
		this.buyer = buyer;
	}

	public UserDto getSeller() {
		return seller;
	}

	public void setSeller(UserDto seller) {
		this.seller = seller;
	}

	public Set<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryDto> categories) {
		this.categories = categories;
	}

	public ProductInRangeWithoutBuyerDto toProductInRangeWithoutBuyerDto() {
		return new ProductInRangeWithoutBuyerDto(name, price, seller.getFullName());
	}

}
