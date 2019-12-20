package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.dao.OrderDAO;
import com.cts.model.Order;
import com.cts.model.SalesOrderDetails;
import com.cts.validation.OrderValidator;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrderValidator validator;

	@Override
	public long createOrder(Order order,long itemPrice) {
		validator.validateOrder(order.getQuantity());
		return orderDAO.createOrder(order,itemPrice);
	}

	@Override
	public List<SalesOrderDetails> getAllOderDetails() {
		
		return orderDAO.getAllOderDetails();
	}

	
	
}
