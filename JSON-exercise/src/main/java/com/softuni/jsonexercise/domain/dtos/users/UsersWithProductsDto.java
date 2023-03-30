package com.softuni.jsonexercise.domain.dtos.users;

import com.softuni.jsonexercise.domain.dtos.products.ProductsSoldWithCountDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithProductsDto {

	@XmlAttribute(name = "first-name")
	private String firstName;

	@XmlAttribute(name = "last-name")
	private String lastName;

	@XmlAttribute
	private Integer age;

	@XmlElement(name = "sold-products")
	private ProductsSoldWithCountDto products;

	public UsersWithProductsDto(String firstName, String lastName, Integer age, ProductsSoldWithCountDto products) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.products = products;
	}

	public UsersWithProductsDto() {

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public ProductsSoldWithCountDto getProducts() {
		return products;
	}

	public void setProducts(ProductsSoldWithCountDto products) {
		this.products = products;
	}

}
