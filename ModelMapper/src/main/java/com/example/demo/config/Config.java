package com.example.demo.config;

import java.util.Scanner;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class Config {

	@Bean
	ModelMapper createModelMapper() {
		return new ModelMapper();
	}

	@Bean
	Gson createGson() {
		return new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.create();
	}
	
	@Bean
	Scanner createScanner() {
		return new Scanner(System.in);
	}
}
