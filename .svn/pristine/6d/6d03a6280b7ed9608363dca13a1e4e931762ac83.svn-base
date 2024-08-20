package com.app.vacancyportal.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.vacancyportal.util.formvalidation.ConfirmPasswordMatcherValidation;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmPasswordMatcherValidation.class)
public @interface MatchPassword {
	String message() default "Password is not matching";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
