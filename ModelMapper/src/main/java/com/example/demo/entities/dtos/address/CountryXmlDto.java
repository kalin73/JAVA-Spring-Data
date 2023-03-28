package com.example.demo.entities.dtos.address;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryXmlDto {
	@XmlAttribute
	private String value;

	public CountryXmlDto() {
		
	}

	public CountryXmlDto(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CountryXmlDto [value=" + value + "]";
	}

}
