package com.softuni.mvc.utils;

import org.springframework.stereotype.Component;

import jakarta.validation.Validator;

@Component
public class ValidationUtil {
	private final Validator validator;

	public ValidationUtil(Validator validator) {
		this.validator = validator;
	}

	public <E> boolean isValid(E entity) {
		return this.validator.validate(entity).isEmpty();
	}
}
