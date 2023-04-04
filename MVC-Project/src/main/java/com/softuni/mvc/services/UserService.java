package com.softuni.mvc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.softuni.mvc.models.dtos.users.LoginDto;
import com.softuni.mvc.models.entities.User;
import com.softuni.mvc.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> login(LoginDto loginDto) {
		return this.userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
	}
}
