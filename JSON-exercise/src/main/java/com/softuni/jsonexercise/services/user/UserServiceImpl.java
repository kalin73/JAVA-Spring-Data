package com.softuni.jsonexercise.services.user;

import static com.softuni.jsonexercise.constant.JsonFiles.*;
import static com.softuni.jsonexercise.constant.Utils.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.softuni.jsonexercise.domain.dtos.users.UserDto;
import com.softuni.jsonexercise.domain.dtos.users.UsersWithProductsDto;
import com.softuni.jsonexercise.domain.dtos.users.UsersWithSoldProductsDto;
import com.softuni.jsonexercise.domain.dtos.users.wrappers.UsersWithProductsWrapperDto;
import com.softuni.jsonexercise.domain.dtos.users.wrappers.UsersWithSoldProductsWrapperDto;
import com.softuni.jsonexercise.repositories.UserRepository;

import jakarta.xml.bind.JAXBException;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UsersWithSoldProductsDto> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName()
			throws IOException, JAXBException {
		final List<UsersWithSoldProductsDto> users = this.userRepository
				.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName()
				.orElseThrow(NoSuchElementException::new).stream()
				.map(user -> modelMapper.map(user, UsersWithSoldProductsDto.class)).collect(Collectors.toList());

		final UsersWithSoldProductsWrapperDto usersWrapper = new UsersWithSoldProductsWrapperDto()
				.ofListOfUsersWithSoldProductsDto(users);

		writeXmlIntoFile(usersWrapper, USERS_WITH_SOLD_PRODUCTS_XML);

		// writeJsonIntoFile(users, USERS_WITH_SOLD_PRODUCTS_JSON);

		return users;

	}

	@Override
	public UsersWithProductsWrapperDto usersAndProducts() throws IOException, JAXBException {
		final List<UsersWithProductsDto> object = this.userRepository
				.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName()
				.orElseThrow(NoSuchElementException::new)
				.stream()
				.map(user -> modelMapper.map(user, UserDto.class))
				.map(UserDto::toUsersWithProductsDto)
				.collect(Collectors.toList());

		UsersWithProductsWrapperDto usersWithProductsWrapperDto = new UsersWithProductsWrapperDto(object);
		
		writeXmlIntoFile(usersWithProductsWrapperDto, USERS_AND_PRODUCTS_XML);
		// writeJsonIntoFile(usersWithProductsWrapperDto, USERS_AND_PRODUCTS_JSON);

		return usersWithProductsWrapperDto;

	}

}
