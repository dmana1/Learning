package com.me.care.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.care.model.User;



public class UserValidator implements Validator{

	

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "validate.userName", "Your Name Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.password", "Your password Is Incorrenct");
	}

}
