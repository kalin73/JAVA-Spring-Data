package com.softuni.jsonexercise.domain.dtos.users;

import java.util.List;

import com.softuni.jsonexercise.domain.dtos.products.ProductSoldDto;
import com.softuni.jsonexercise.domain.dtos.products.wrappers.ProductSoldWrapperDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
public class UsersWithSoldProductsDto {

	private String firstName;

	private String lastName;

	private List<ProductSoldDto> sellingProducts;

	public static List<UserWithSoldProductsXmlDto> toUsersWithSoldProductsDto(List<UsersWithSoldProductsDto> input) {
		return input.stream().map(user -> new UserWithSoldProductsXmlDto(user.getFirstName(), user.getLastName(),
				new ProductSoldWrapperDto(user.getSellingProducts()))).toList();
	}

}
