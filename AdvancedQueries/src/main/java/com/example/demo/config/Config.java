package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class Config {
	@Autowired
	private Environment environment;

	@Bean
	public DataSource createDataSource() {
		DriverManagerDataSource manager = new DriverManagerDataSource();
		
		manager.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
		manager.setUrl(environment.getProperty("spring.datasource.url"));
		manager.setUsername(environment.getProperty("spring.datasource.username"));
		manager.setPassword(environment.getProperty("spring.datasource.password"));   

		return manager;
	}
	
	
}
