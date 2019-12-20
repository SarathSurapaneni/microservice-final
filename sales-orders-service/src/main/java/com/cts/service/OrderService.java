package com.cts.service;

import java.util.List;

import com.cts.model.Order;
import com.cts.model.SalesOrderDetails;

public interface OrderService {

	public long createOrder(Order oder,long itemPrice);
	public List<SalesOrderDetails> getAllOderDetails();
	
}
