package com.app.vacancyportal.util.formvalidation;


import java.util.HashMap;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public class BasicFormValidation<T> {
	private final Validator validator;

	public BasicFormValidation() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	public HashMap<String,String> checkValidations(T object) {
		Set<ConstraintViolation<T>> set = validator.validate(object);
		HashMap<String,String> map = new HashMap<>();
		
		for(ConstraintViolation<T> s : set ) {	
			if(s.getPropertyPath().toString().isEmpty()) {
				map.put("classlevelerror", s.getMessage());
				continue;
			}
			map.put(s.getPropertyPath().toString(), s.getMessage());
		}
		
		return map;
	}

}
