package com.example.demo.entities.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.entities.dtos.addresses.CreateAddressDTO;
import com.google.gson.annotations.Expose;

public class CreateEmployeeDTO {
	@Expose
	private String firstName;

	private String lastName;

	@Expose
	private BigDecimal salary;
	
	private LocalDate birthday;

	@Expose
	private CreateAddressDTO address;

	public CreateEmployeeDTO(String firstName, String lastName, BigDecimal salary, LocalDate birthday,
			CreateAddressDTO address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.birthday = birthday;
		this.address = address;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public CreateAddressDTO getAddress() {
		return address;
	}

}
