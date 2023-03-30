package com.softuni.jsonexercise.domain.dtos.products;

import java.math.BigDecimal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldDto {
	@XmlElement
	private String name;

	@XmlElement
	private BigDecimal price;

	@XmlElement(name = "buyer-first-name")
	private String buyerFirstName;

	@XmlElement(name = "buyer-last-name")
	private String buyerLastName;

	public ProductSoldDto() {

	}

	public ProductSoldDto(String name, BigDecimal price, String buyerFirstName, String buyerLastName) {
		this.name = name;
		this.price = price;
		this.buyerFirstName = buyerFirstName;
		this.buyerLastName = buyerLastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getBuyerFirstName() {
		return buyerFirstName;
	}

	public void setBuyerFirstName(String buyerFirstName) {
		this.buyerFirstName = buyerFirstName;
	}

	public String getBuyerLastName() {
		return buyerLastName;
	}

	public void setBuyerLastName(String buyerLastName) {
		this.buyerLastName = buyerLastName;
	}

}
