package com.softuni.gamestore;

import static com.softuni.gamestore.constants.Commands.ADD_GAME;
import static com.softuni.gamestore.constants.Commands.LOGIN_USER;
import static com.softuni.gamestore.constants.Commands.LOGOUT_USER;
import static com.softuni.gamestore.constants.Commands.REGISTER_USER;
import static com.softuni.gamestore.constants.Validations.COMMAND_NOT_FOUND_MESSAGE;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.softuni.gamestore.services.Game.GameService;
import com.softuni.gamestore.services.User.UserService;

@Component
public class ConsoleRunner implements CommandLineRunner {
	private final Scanner sc;
	private final UserService userService;
	private final GameService gameService;

	public ConsoleRunner(UserService userService, GameService gameService) {
		sc = new Scanner(System.in);
		this.userService = userService;
		this.gameService = gameService;
	}

	@Override
	public void run(String... args) throws Exception {
		String[] input = sc.nextLine().split("\\|");

		while (!input[0].equals("close")) {
			final String command = input[0];

			final String output = switch (command) {
			case REGISTER_USER -> userService.registerUser(input);
			case LOGIN_USER -> userService.loginUser(input);
			case LOGOUT_USER -> userService.logoutUser();
			case ADD_GAME -> gameService.addGame(input);

			default -> COMMAND_NOT_FOUND_MESSAGE;
			};

			System.out.println(output);

			input = sc.nextLine().split("\\|");
		}
	}

}
