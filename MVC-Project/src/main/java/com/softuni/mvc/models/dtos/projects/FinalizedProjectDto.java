package com.softuni.mvc.models.dtos.projects;

import java.math.BigDecimal;

public class FinalizedProjectDto {

	private String name;

	private String description;

	private BigDecimal payment;

	public FinalizedProjectDto() {

	}

	public FinalizedProjectDto(String name, String description, BigDecimal payment) {
		this.name = name;
		this.description = description;
		this.payment = payment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return String.format("Project name: %s%n	Description: %s%n	%s", this.name, this.description,
				this.payment);
	}
}
