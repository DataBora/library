package com.bizanaliza.library.utils;

import com.bizanaliza.library.rest.ErrorMessages;
import com.bizanaliza.library.service.AppException;

public class AttributeLengthValidation {
	
	public static void checkLenght(String target, int maxLength) {
		
		if(target != null && target.length() > maxLength) {
			throw new AppException(ErrorMessages.attribute_too_long);
		}
	}
}
