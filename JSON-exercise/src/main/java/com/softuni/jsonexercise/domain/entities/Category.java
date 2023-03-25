package com.softuni.jsonexercise.domain.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
	@Column(nullable = false)
	@Size(min = 3, max = 15)
	private String name;

	@ManyToMany(mappedBy = "categories")
	private Set<Product> products;

	public Category() {
		this.products = new HashSet<>();
	}

	public Category(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() < 3 || name.length() > 15) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(name, other.name) && Objects.equals(getId(), other.getId());
	}
}
