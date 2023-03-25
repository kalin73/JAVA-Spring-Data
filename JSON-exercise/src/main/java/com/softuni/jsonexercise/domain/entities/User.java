package com.softuni.jsonexercise.domain.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.google.gson.annotations.Expose;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(nullable = true, name = "first_name")
	@Expose
	private String firstName;

	@Column(name = "last_name")
	@Size(min = 3)
	@Expose
	private String lastName;

	@Column(nullable = true)
	@Expose
	private int age;

	@OneToMany(targetEntity = Product.class, mappedBy = "seller")
	@Fetch(FetchMode.JOIN)
	private Set<Product> sellingProducts;

	@OneToMany(targetEntity = Product.class, mappedBy = "buyer")
	@Fetch(FetchMode.JOIN)
	private Set<Product> bughtProducts;

	@ManyToMany
	@Fetch(FetchMode.JOIN)
	private Set<User> friends;

	public User() {
		this.sellingProducts = new HashSet<>();
		this.bughtProducts = new HashSet<>();
		this.friends = new HashSet<>();
	}

	public User(String firstName, String lastName, int age) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Product> getSellingProducts() {
		return sellingProducts;
	}

	public void setSellingProducts(Set<Product> sellingProducts) {
		this.sellingProducts = sellingProducts;
	}

	public Set<Product> getBughtProducts() {
		return bughtProducts;
	}

	public void setBughtProducts(Set<Product> bughtProducts) {
		this.bughtProducts = bughtProducts;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(getId(), other.getId());
	}
}
