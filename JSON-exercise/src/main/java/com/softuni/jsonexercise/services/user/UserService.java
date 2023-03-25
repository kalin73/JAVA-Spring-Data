package com.softuni.jsonexercise.services.user;

import java.io.IOException;
import java.util.List;

import com.softuni.jsonexercise.domain.dtos.users.UsersWithProductsWrapperDto;
import com.softuni.jsonexercise.domain.dtos.users.UsersWithSoldProductsDto;

public interface UserService {
	List<UsersWithSoldProductsDto> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName() throws IOException;

	UsersWithProductsWrapperDto usersAndProducts() throws IOException;
}
