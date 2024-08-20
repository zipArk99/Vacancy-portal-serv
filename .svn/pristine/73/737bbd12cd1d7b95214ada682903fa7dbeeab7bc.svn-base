package com.app.vacancyportal.util.formvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app.vacancyportal.customannotation.MatchPassword;
import com.app.vacancyportal.entity.User;

public class ConfirmPasswordMatcherValidation implements ConstraintValidator<MatchPassword, User> {

	@Override
	public boolean isValid(User user, ConstraintValidatorContext context) {
		String password = user.getPassword();
		String confirmPassword = user.getConfirmPassword();

		if (password.isEmpty() || confirmPassword.isEmpty() || !password.equals(confirmPassword)) {
			return false;
		}
		return true;
	}

}
