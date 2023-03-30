package com.softuni.jsonexercise.domain.dtos.products;

import java.math.BigDecimal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeWithoutBuyerDto {
	@XmlAttribute
	private String name;

	@XmlAttribute
	private BigDecimal price;

	@XmlAttribute
	private String seller;

	public ProductInRangeWithoutBuyerDto() {

	}

	public ProductInRangeWithoutBuyerDto(String name, BigDecimal price, String seller) {
		this.name = name;
		this.price = price;
		this.seller = seller;
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

}
