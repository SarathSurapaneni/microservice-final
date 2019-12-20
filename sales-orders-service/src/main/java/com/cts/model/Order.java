package com.cts.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This request is to create an Order")
public class Order {

	private long orderId;
	
	@ApiModelProperty(name = "orderdate", notes = "orderDate must be in DD/MM/YYYY", value = "24/11/2019", required = true)
	@Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", message = "orderdate must be in DD/MM/YYYY format")
	private String orderDate;
	
	@ApiModelProperty(notes = "orderdesc should have atleast few words", name = "orderdesc", value = "Redmi note8 pro has 64 MP camera", required = true)
	@NotBlank(message = "orderdesc should have atleast few words")
	private String orderDescription;
	@Positive(message = "custid should be a positive value")
	
	@NotNull(message = "quantity should have atleast 1 digit")
	@ApiModelProperty(notes = "Quantity should have positive value", name = "Quantity", value = "1L", required = true)
	private long quantity;
	
	@Positive(message = "custid should be a positive value")
	@NotNull(message = "custid should have atleast 1 digit")
	@ApiModelProperty(notes = "customer id should have positive value", name = "custid", value = "1L", required = true)
	private int customerId;
	
	@ApiModelProperty(notes = "itemName should have atleast few words", name = "orderdesc", value = "Redmi note8 pro has 64 MP camera", required = true)
	@NotBlank(message = "itemName should have atleast few words")
	private String itemName;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

	
}
