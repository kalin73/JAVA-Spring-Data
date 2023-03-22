package com.softuni.gamestore.domain.entities;

import java.util.HashSet;
import java.util.Set;

import static com.softuni.gamestore.constants.Validations.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(nullable = false, unique = true)
	@Email(regexp = EMAIL_PATTERN)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(name = "full_name", nullable = false)
	private String fullname;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE })
	private Set<Game> games;

	@OneToMany(targetEntity = Order.class, mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Order> orders;

	@Column
	private Boolean isAdmin;

	public User() {
		this.games = new HashSet<>();
		this.orders = new HashSet<>();
	}

	public User(String email, String password, String fullname) {
		this();
		this.email = email;
		this.password = password;
		this.fullname = fullname;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
