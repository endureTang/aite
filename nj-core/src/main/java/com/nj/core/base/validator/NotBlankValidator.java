package com.nj.core.base.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class NotBlankValidator implements ConstraintValidator<NotBlank, CharSequence> {

	@Override
	public void initialize(NotBlank arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(CharSequence arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(arg0))
			return false;
		return true;
	}

}
