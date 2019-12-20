package com.cts.controller;

import static com.cts.controller.APIConstants.CREATE_ORDER;
import static com.cts.controller.APIConstants.GET_OREDERS;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cts.exception.CustomerNotFoundException;
import com.cts.exception.ItemNotFoundException;
import com.cts.model.Item;
import com.cts.model.Order;
import com.cts.model.SalesOrderDetails;
import com.cts.service.CustomerService;
import com.cts.service.ItemServiceApiClient;
import com.cts.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "SalesOrderController", description = "REST APIs related to Sales Order Service!!!!")
public class SalesOrderController {
	
	@Autowired
	private ItemServiceApiClient itemServiceApiClient;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;

	@ApiOperation(value = "Create new Orders")
	@PostMapping(value = CREATE_ORDER,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> createOrder(@RequestBody Order order) {
		
		//validate customer
		if(!customerService.isCustomerExists(order.getCustomerId())){
			throw new CustomerNotFoundException("Customer with Id:"+order.getCustomerId() +" not found!");
		}
		
		Item item = itemServiceApiClient.getItemByItemName(order.getItemName());
		
		if(item == null || item.getItemName() == null){
			throw new ItemNotFoundException("Item with name:"+order.getItemName() +" not found!");
		}
		long orderId=orderService.createOrder(order,item.getPrice());
		return new ResponseEntity<Long>(orderId, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create all Orders")
	@GetMapping(GET_OREDERS)
	public ResponseEntity<List<SalesOrderDetails>> getAllOrders() {
		List<SalesOrderDetails> list = orderService.getAllOderDetails();
		return new ResponseEntity<List<SalesOrderDetails>>(list, HttpStatus.OK);
	}

		
}
