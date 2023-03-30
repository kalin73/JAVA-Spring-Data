package com.softuni.jsonexercise.domain.dtos.products.wrappers;

import java.util.List;

import com.softuni.jsonexercise.domain.dtos.products.ProductImportDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsImportWrapperDto {

	@XmlElement(name = "product")
	private List<ProductImportDto> products;
}
