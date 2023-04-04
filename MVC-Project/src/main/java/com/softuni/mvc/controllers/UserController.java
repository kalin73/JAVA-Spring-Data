package com.softuni.mvc.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.softuni.mvc.models.dtos.users.LoginDto;
import com.softuni.mvc.models.entities.User;
import com.softuni.mvc.services.UserService;

@Controller
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users/login")
	public String login() {
		return "user/login";
	}

	@PostMapping("/users/login")
	public String doLogin(LoginDto loginDto) {
		System.out.println(loginDto);
		Optional<User> user = this.userService.login(loginDto);

		if (user.isPresent()) {
			return "redirect:/home";
		}

		return "user/login";
	}

}
