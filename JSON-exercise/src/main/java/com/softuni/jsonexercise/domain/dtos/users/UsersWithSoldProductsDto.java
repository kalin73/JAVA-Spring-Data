package com.softuni.jsonexercise.domain.dtos.users;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.softuni.jsonexercise.domain.dtos.products.ProductSoldDto;

public class UsersWithSoldProductsDto {
	@Expose
	private String firstName;

	@Expose
	private String lastName;

	@Expose
	private List<ProductSoldDto> sellingProducts;

	public UsersWithSoldProductsDto() {

	}

	public UsersWithSoldProductsDto(String firstName, String lastName, List<ProductSoldDto> sellingProducts) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sellingProducts = sellingProducts;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<ProductSoldDto> getSellingProductsProducts() {
		return sellingProducts;
	}

	public void setSellingProductsProducts(List<ProductSoldDto> sellingProducts) {
		this.sellingProducts = sellingProducts;
	}

}
