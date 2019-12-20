package com.cts.validation;

import org.springframework.stereotype.Component;

import com.cts.exception.ValidationException;

@Component
public class OrderValidatorImpl implements OrderValidator{

	@Override
	public void validateOrder(long quantity) throws ValidationException {
		
		if(quantity == 0){
			throw new ValidationException("Quantity cannot be zero");
		}
		
	}

}
