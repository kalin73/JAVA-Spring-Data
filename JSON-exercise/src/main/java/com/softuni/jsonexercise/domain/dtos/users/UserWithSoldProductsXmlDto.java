package com.softuni.jsonexercise.domain.dtos.users;

import com.softuni.jsonexercise.domain.dtos.products.wrappers.ProductSoldWrapperDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductsXmlDto {
	@XmlAttribute(name = "first-name")
	private String firstName;

	@XmlAttribute(name = "last-name")
	private String lastName;

	@XmlElement(name = "sold-products")
	private ProductSoldWrapperDto sellingProducts;
}