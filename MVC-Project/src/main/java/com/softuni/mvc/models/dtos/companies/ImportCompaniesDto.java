package com.softuni.mvc.models.dtos.companies;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCompaniesDto {
	@XmlElement(name = "company")
	private List<ImportCompanyDto> companies;

	public ImportCompaniesDto() {

	}

	public ImportCompaniesDto(List<ImportCompanyDto> companies) {
		this.companies = companies;
	}

	public List<ImportCompanyDto> getCompanies() {
		return companies;
	}

	public void setCompanies(List<ImportCompanyDto> companies) {
		this.companies = companies;
	}

}
