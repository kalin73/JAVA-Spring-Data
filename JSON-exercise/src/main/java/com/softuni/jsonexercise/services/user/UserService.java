package com.softuni.jsonexercise.services.user;

import java.io.IOException;
import java.util.List;

import com.softuni.jsonexercise.domain.dtos.users.UsersWithSoldProductsDto;
import com.softuni.jsonexercise.domain.dtos.users.wrappers.UsersWithProductsWrapperDto;

import jakarta.xml.bind.JAXBException;

public interface UserService {
	List<UsersWithSoldProductsDto> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName() throws IOException, JAXBException;

	UsersWithProductsWrapperDto usersAndProducts() throws IOException, JAXBException;
}
