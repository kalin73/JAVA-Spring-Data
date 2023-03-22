package com.softuni.gamestore.services.Game;

import java.math.BigDecimal;
import java.time.LocalDate;

//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.softuni.gamestore.domain.dtos.GameDTO;
import com.softuni.gamestore.domain.entities.Game;
import com.softuni.gamestore.repositories.GameRepository;
import com.softuni.gamestore.services.User.UserService;

@Service
public class GameServiceImpl implements GameService {
	private final GameRepository gameRepository;
//	private final ModelMapper modelMapper = new ModelMapper();

	private final UserService userService;

	public GameServiceImpl(GameRepository gameRepository, UserService userService) {
		this.gameRepository = gameRepository;
		this.userService = userService;
	}

	@Override
	public String addGame(String[] args) {
		if (this.userService.getLoggedInUser() != null && this.userService.getLoggedInUser().getIsAdmin()) {

			final String title = args[1];
			final BigDecimal price = new BigDecimal(args[2]);
			final float size = Float.parseFloat(args[3]);
			final String trialer = args[4];
			final String imageUrl = args[5];
			final String description = args[6];
			final LocalDate releaseDate = LocalDate.now();

			GameDTO gameDTO = new GameDTO(title, trialer, imageUrl, size, price, description, releaseDate);

			Game game = gameDTO.toGame();

			if (this.gameRepository.existsByTitle(game.getTitle())) {
				throw new IllegalArgumentException("Game already exists!");
			}
			this.gameRepository.save(game);

			return "Added " + game.getTitle();
		}

		return "Imposible command!";
	}

	@Override
	public String editGame(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteGame(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
