package com.softuni.gamestore.services.Game;

public interface GameService {
	String addGame(String[] args);

	String editGame(String[] args);

	String deleteGame(Long id);
}
