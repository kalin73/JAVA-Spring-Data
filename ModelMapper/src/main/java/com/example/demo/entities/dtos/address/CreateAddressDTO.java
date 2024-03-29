package com.example.demo.entities.dtos.address;

import com.google.gson.annotations.Expose;

public class CreateAddressDTO {
	@Expose
	private String country;
	
	@Expose
	private String city;

	public CreateAddressDTO(String country, String city) {
		this.country = country;
		this.city = city;
	}

	public CreateAddressDTO() {

	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
