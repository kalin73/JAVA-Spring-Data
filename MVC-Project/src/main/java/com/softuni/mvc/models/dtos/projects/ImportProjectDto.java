package com.softuni.mvc.models.dtos.projects;

import java.math.BigDecimal;

import com.softuni.mvc.models.dtos.companies.ImportCompanyDto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportProjectDto {

	@XmlElement
	@NotNull
	private String name;

	@XmlElement
	@NotNull
	private String description;

	@XmlElement(name = "is-finished")
	private Boolean isFinished;

	@XmlElement
	@NotNull
	private BigDecimal payment;

	@XmlElement(name = "start-date")
	private String startDate;

	@XmlElement(name = "company")
	@NotNull
	private ImportCompanyDto company;

	public ImportProjectDto() {

	}

	public ImportProjectDto(String name, String description, Boolean isFinished, BigDecimal payment, String startDate,
			ImportCompanyDto company) {
		this.name = name;
		this.description = description;
		this.isFinished = isFinished;
		this.payment = payment;
		this.startDate = startDate;
		this.company = company;
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

	public Boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public ImportCompanyDto getCompany() {
		return company;
	}

	public void setCompany(ImportCompanyDto company) {
		this.company = company;
	}

}
