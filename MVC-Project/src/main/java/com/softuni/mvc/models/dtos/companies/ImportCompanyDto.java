package com.softuni.mvc.models.dtos.companies;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCompanyDto {
	@XmlAttribute(name = "name")
	private String name;

	public ImportCompanyDto() {

	}

	public ImportCompanyDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
