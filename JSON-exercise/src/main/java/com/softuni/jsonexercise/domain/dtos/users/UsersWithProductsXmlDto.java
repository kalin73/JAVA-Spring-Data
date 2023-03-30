package com.softuni.jsonexercise.domain.dtos.users;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersWithProductsXmlDto {
	private List<UsersWithProductsDto> users;
}
