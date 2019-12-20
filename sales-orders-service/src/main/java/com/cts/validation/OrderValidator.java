package com.cts.validation;

import com.cts.exception.ValidationException;

public interface OrderValidator {
	
	void validateOrder(long quantity) throws ValidationException;

}
