package com.example.demo.entities.dtos.address;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressXMLDto {
	@XmlElement
	private long id;

	@XmlElement
	private String country;

	@XmlElement
	private String city;

	public AddressXMLDto(long id, String country, String city) {
		this.id = id;
		this.country = country;
		this.city = city;
	}

	public AddressXMLDto() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AddressXMLDto [id=" + id + ", country=" + country + ", city=" + city + "]";
	}

}
