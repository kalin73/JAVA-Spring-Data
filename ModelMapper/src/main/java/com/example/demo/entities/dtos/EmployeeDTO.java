package com.example.demo.entities.dtos;

import java.math.BigDecimal;

public class EmployeeDTO {
	private String firstName;
	private BigDecimal salary;
	private String addressCity;

	public EmployeeDTO() {

	}

	@Override
	public String toString() {
		return "EmployeeDTO [firstName=" + firstName + ", salary=" + salary + ", city=" + addressCity + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

}
