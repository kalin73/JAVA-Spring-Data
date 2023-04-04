package com.softuni.mvc.models.dtos.employees;

import java.util.List;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportEmployeesDto {
	@XmlElement(name = "employee")
	private List<ImportEmployeeDto> employees;

	public ImportEmployeesDto() {
		
	}

	public ImportEmployeesDto(List<ImportEmployeeDto> employees) {
		this.employees = employees;
	}

	public List<ImportEmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<ImportEmployeeDto> employees) {
		this.employees = employees;
	}
}
