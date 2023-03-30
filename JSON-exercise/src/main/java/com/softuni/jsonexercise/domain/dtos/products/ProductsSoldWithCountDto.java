package com.softuni.jsonexercise.domain.dtos.products;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSoldWithCountDto {
	
	@XmlAttribute
	private Integer count;

	@XmlElement(name = "product")
	private List<ProductBasicInfoDto> products;

	public ProductsSoldWithCountDto() {
		
	}

	public ProductsSoldWithCountDto(List<ProductBasicInfoDto> products) {
		this.products = products;
		this.count = products.size();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<ProductBasicInfoDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBasicInfoDto> products) {
		this.products = products;
	}

}
