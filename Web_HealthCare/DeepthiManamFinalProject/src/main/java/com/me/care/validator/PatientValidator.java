package com.me.care.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.care.model.Patient;
import com.me.care.model.User;



public class PatientValidator implements Validator{

	

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Patient.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Patient patient = (Patient)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "validate.firstName", "Your firstName Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "validate.lastName", "Your lastName Is Incorrenct");
		
	}

}
