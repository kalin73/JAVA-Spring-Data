package com.softuni.jsonexercise.domain.dtos.categories;

import com.google.gson.annotations.Expose;

public class CategoryDto {
	@Expose
	private String name;

	public CategoryDto() {
		super();
	}

	public CategoryDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
