package com.softuni.mvc.models.dtos.employees;

import com.softuni.mvc.models.dtos.projects.ImportProjectDto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportEmployeeDto {

	@XmlElement(name = "first-name")
	@NotNull
	private String firstName;

	@XmlElement(name = "last-name")
	@NotNull
	private String lastName;

	@XmlElement
	@NotNull
	private int age;

	@XmlElement(name = "project")
	@NotNull
	private ImportProjectDto project;

	public ImportEmployeeDto() {

	}

	public ImportEmployeeDto(String firstName, String lastName, int age, ImportProjectDto project) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.project = project;
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

	public ImportProjectDto getProject() {
		return project;
	}

	public void setProject(ImportProjectDto project) {
		this.project = project;
	}

}
