package com.softuni.gamestore.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.softuni.gamestore.domain.entities.Game;

public class GameDTO {

	private String title;

	private String trailerId;

	private String imageUrl;

	private float size;

	private BigDecimal price;

	private String description;

	private LocalDate releaseDate;

	public GameDTO() {

	}

	public GameDTO(String title, String trailerId, String imageUrl, float size, BigDecimal price, String description,
			LocalDate releaseDate) {
		setTitle(title);
		setTrailerId(trailerId);
		setImageUrl(imageUrl);
		setSize(size);
		setPrice(price);
		setDescription(description);
		setReleaseDate(releaseDate);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (!Character.isUpperCase(title.charAt(0)) && title.length() < 3 || title.length() > 100) {
			throw new IllegalArgumentException("Not a valid game title.");

		}
		this.title = title;
	}

	public String getTrailerId() {
		return trailerId;
	}

	public void setTrailerId(String trailerId) {
		if (trailerId == null || trailerId.length() != 11) {
			throw new IllegalArgumentException("Trailer ID should be exactly 11.");

		}
		this.trailerId = trailerId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		if (imageUrl == null || !imageUrl.startsWith("http://") && !imageUrl.startsWith("https://")) {
			throw new IllegalArgumentException("Link should begin with http ...");
		}
		this.imageUrl = imageUrl;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		if (size < 0.1) {
			throw new IllegalArgumentException("Size should be postive number.");
		}
		this.size = size;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		if (price == null || price.compareTo(BigDecimal.valueOf(0)) < 1) {
			throw new IllegalArgumentException("Price should be postive number.");

		}
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description == null || description.length() < 20) {
			throw new IllegalArgumentException("Description should be at least 20 characters.");
		}
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Game toGame() {
		return new Game(this.title, this.trailerId, this.imageUrl, this.size, this.price, this.description,
				this.releaseDate);
	}
}
