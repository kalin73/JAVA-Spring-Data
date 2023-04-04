package com.softuni.mvc.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Configuration
public class Config {
	@Bean
	ModelMapper createModeldMapper() {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.addConverter(mappingContext -> LocalDate.parse(mappingContext.getSource(),
				DateTimeFormatter.ofPattern("yyyy-MM-dd")), String.class, LocalDate.class);

		return modelMapper;
	}

	@Bean
	Validator createValidator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}
}
