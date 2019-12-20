package com.cts.dao;

import java.util.List;

import com.cts.model.Order;
import com.cts.model.SalesOrderDetails;

public interface OrderDAO {

	public long createOrder(Order oder,long itemPrice);
	public List<SalesOrderDetails> getAllOderDetails();

}
