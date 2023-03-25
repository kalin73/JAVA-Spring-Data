package com.softuni.jsonexercise.domain.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

	@Column
	@Size(min = 3)
	private String name;

	@Column(nullable = false)
	private BigDecimal price;

	@ManyToOne(optional = true)
	@Fetch(FetchMode.JOIN)
	private User buyer;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	private User seller;

	@ManyToMany
	@Fetch(FetchMode.JOIN)
	private Set<Category> categories;

	public Product() {
		this.categories = new HashSet<>();
	}

	public Product(String name, BigDecimal price, User buyer, User seller) {
		this();
		this.name = name;
		this.price = price;
		this.buyer = buyer;
		this.seller = seller;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() < 3) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}
