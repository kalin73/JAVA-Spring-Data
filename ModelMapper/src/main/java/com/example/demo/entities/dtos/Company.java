package com.example.demo.entities.dtos;

import java.util.List;

import com.google.gson.annotations.Expose;

public class Company {
	@Expose
	private String name;

	@Expose
	private List<CreateEmployeeDTO> employees;

	public Company(String name, List<CreateEmployeeDTO> employees) {
		this.name = name;
		this.employees = employees;
	}

	public Company() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CreateEmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<CreateEmployeeDTO> employees) {
		this.employees = employees;
	}

}
