package com.softuni.jsonexercise.domain.dtos.users;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.annotations.Expose;
import com.softuni.jsonexercise.domain.dtos.products.ProductBasicInfoDto;
import com.softuni.jsonexercise.domain.dtos.products.ProductDto;
import com.softuni.jsonexercise.domain.dtos.products.ProductsSoldWithCountDto;

public class UserDto {
	@Expose
	private String firstName;

	@Expose
	private String lastName;

	@Expose
	private int age;

	@Expose
	private Set<ProductDto> sellingProducts;

	@Expose
	private Set<ProductDto> bughtProducts;

	@Expose
	private Set<UserDto> friends;

	public UserDto() {
		this.sellingProducts = new HashSet<>();
		this.bughtProducts = new HashSet<>();
		this.friends = new HashSet<>();
	}

	public UserDto(String firstName, String lastName, int age) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<ProductDto> getSellingProducts() {
		return sellingProducts;
	}

	public void setSellingProducts(Set<ProductDto> sellingProducts) {
		this.sellingProducts = sellingProducts;
	}

	public Set<ProductDto> getBughtProducts() {
		return bughtProducts;
	}

	public void setBughtProducts(Set<ProductDto> bughtProducts) {
		this.bughtProducts = bughtProducts;
	}

	public Set<UserDto> getFriends() {
		return friends;
	}

	public void setFriends(Set<UserDto> friends) {
		this.friends = friends;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}


	public UsersWithProductsDto toUsersWithProductsDto() {
		return new UsersWithProductsDto(firstName, lastName, age, toProductsSoldWithCountDto());
	}

	public ProductsSoldWithCountDto toProductsSoldWithCountDto() {
		return new ProductsSoldWithCountDto(sellingProducts.stream().map(this::toProductBasicInfo).collect(Collectors.toList()));
	}

	public ProductBasicInfoDto toProductBasicInfo(ProductDto product) {
		return new ProductBasicInfoDto(product.getName(), product.getPrice());
	}
}
