package com.softuni.jsonexercise.domain.dtos.users.wrappers;

import java.util.List;

import com.softuni.jsonexercise.domain.dtos.users.UserWithSoldProductsXmlDto;
import com.softuni.jsonexercise.domain.dtos.users.UsersWithSoldProductsDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsWrapperDto {

	@XmlElement(name = "user")
	private List<UserWithSoldProductsXmlDto> users;

	public UsersWithSoldProductsWrapperDto ofListOfUsersWithSoldProductsDto(List<UsersWithSoldProductsDto> input) {
		users = UsersWithSoldProductsDto.toUsersWithSoldProductsDto(input);
		return this;
	}
}
