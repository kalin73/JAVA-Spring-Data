package com.example.demo.config;

import java.time.LocalDate;
import java.util.Scanner;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entities.dtos.address.AddressXMLDto;
import com.example.demo.entities.dtos.address.CountryXmlDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

@Configuration
public class Config {

	@Bean
	ModelMapper createModelMapper() {
		ModelMapper mapper = new ModelMapper();
		Converter<String, LocalDate> converter = context -> LocalDate.parse(context.getSource());
		mapper.addConverter(converter, String.class, LocalDate.class);
		
		return mapper;
	}

	@Bean
	Gson createGson() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	}

	@Bean
	Scanner createScanner() {
		return new Scanner(System.in);
	}

	@Bean(name = "addressContext")
	JAXBContext createAddressContext() throws JAXBException {
		return JAXBContext.newInstance(AddressXMLDto.class);
	}
	
	@Bean(name = "countryContext")
	JAXBContext createCountryContext() throws JAXBException {
		return JAXBContext.newInstance(CountryXmlDto.class);
	}

}
