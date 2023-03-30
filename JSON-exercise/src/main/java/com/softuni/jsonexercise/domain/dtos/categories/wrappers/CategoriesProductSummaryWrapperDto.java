package com.softuni.jsonexercise.domain.dtos.categories.wrappers;

import java.util.List;

import com.softuni.jsonexercise.domain.dtos.categories.CategoryProductsSummaryDto;

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
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesProductSummaryWrapperDto {
	@XmlElement(name = "category")
	private List<CategoryProductsSummaryDto> categories;
}
