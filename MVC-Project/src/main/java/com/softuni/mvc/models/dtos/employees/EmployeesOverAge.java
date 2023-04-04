package com.softuni.mvc.models.dtos.employees;

public class EmployeesOverAge {

	private String firstName;

	private String lastName;

	private int age;

	private String projectName;

	public EmployeesOverAge() {
		super();
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return String.format("Name: %s %s%nAge: %d%nProject name: %s", this.firstName, this.lastName, this.age,
				this.projectName);
	}

}
