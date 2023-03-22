package com.softuni.gamestore.services.User;

import static com.softuni.gamestore.constants.Validations.USERNAME_OR_PASSWORD_NOT_VALID_MESSAGE;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.softuni.gamestore.domain.dtos.UserLoginDTO;
import com.softuni.gamestore.domain.dtos.UserRegisterDTO;
import com.softuni.gamestore.domain.entities.User;
import com.softuni.gamestore.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private User logedInUser;
	private final UserRepository userRepository;
	private final ModelMapper modelMapper = new ModelMapper();

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public String registerUser(String[] args) {
		final String email = args[1];
		final String password = args[2];
		final String confirmPassword = args[3];
		final String fullName = args[4];

		final UserRegisterDTO userDTO;

		try {
			userDTO = new UserRegisterDTO(email, password, confirmPassword, fullName);
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}

		final User user = this.modelMapper.map(userDTO, User.class);

		if (this.userRepository.count() == 0) {
			user.setIsAdmin(true);
		}

		boolean isUserFound = this.userRepository.existsByEmail(userDTO.getEmail());

		if (isUserFound) {
			return "Email already exists!";
		}

		this.userRepository.save(user);

		return userDTO.successfulRegisterFormat();
	}

	@Override
	public String loginUser(String[] input) {
		final String email = input[1];
		final String password = input[2];

		final UserLoginDTO userLogin = new UserLoginDTO(email, password);

		Optional<User> user = this.userRepository.findFirstByEmail(userLogin.getEmail());

		if (user.isPresent() && this.logedInUser == null && user.get().getPassword().equals(userLogin.getPassword())) {
			this.logedInUser = user.get();

			return "Successfully logged in " + this.logedInUser.getFullname();
		}

		return USERNAME_OR_PASSWORD_NOT_VALID_MESSAGE;
	}

	@Override
	public String logoutUser() {
		if (this.logedInUser == null) {
			return "Cannot log out. No user was logged in.";
		}

		String output = "User " + logedInUser.getFullname() + " successfully logged out.";
		this.logedInUser = null;

		return output;
	}

	@Override
	public User getLoggedInUser() {
		return this.logedInUser;
	}

}
