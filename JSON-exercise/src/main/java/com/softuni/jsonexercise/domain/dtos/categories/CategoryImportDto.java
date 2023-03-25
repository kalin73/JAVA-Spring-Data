package com.softuni.jsonexercise.domain.dtos.categories;

import com.google.gson.annotations.Expose;

public class CategoryImportDto {
	@Expose
	private String name;

	public CategoryImportDto() {

	}

	public CategoryImportDto(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
