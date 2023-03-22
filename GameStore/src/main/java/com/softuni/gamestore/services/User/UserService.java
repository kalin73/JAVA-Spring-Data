package com.softuni.gamestore.services.User;

import com.softuni.gamestore.domain.entities.User;

public interface UserService {
	String registerUser(String[] args);

	String loginUser(String[] input);

	String logoutUser();
	
	User getLoggedInUser();
}
