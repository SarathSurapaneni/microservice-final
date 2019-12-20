package com.cts.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SalesOrderDetailsRowMapper implements RowMapper<SalesOrderDetails> {
	
	@Override
	public SalesOrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		SalesOrderDetails salesOrderDetails = new SalesOrderDetails();
		salesOrderDetails.setCustomerId(rs.getString("cust_id"));
		salesOrderDetails.setCustomerEmail(rs.getString("cust_email"));
		salesOrderDetails.setFirstName(rs.getString("cust_first_name"));
		salesOrderDetails.setLastName(rs.getString("cust_last_name"));
		salesOrderDetails.setOrderId(rs.getString("ORDER_ID"));
		salesOrderDetails.setOrderDate(rs.getString("order_date"));
		salesOrderDetails.setOrderDesc(rs.getString("order_desc"));
		salesOrderDetails.setTotalPrice(rs.getString("total_price"));
		salesOrderDetails.setOrderLineItemId(rs.getString("ORDER_LINE_ID"));
		salesOrderDetails.setItemQuantity(rs.getString("item_quantity"));
		return salesOrderDetails;
	}

}
