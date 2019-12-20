package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.model.Order;
import com.cts.model.SalesOrderDetails;
import com.cts.model.SalesOrderDetailsRowMapper;

@Transactional
@Repository
public class OrderDAOImpl implements OrderDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public long createOrder(Order order,long itemPrice) {
		
		String sql = "INSERT INTO SALES_ORDER (order_date,cust_id,order_desc,total_price) values (?, ?, ?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		
		long totalprice= itemPrice * order.getQuantity();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, order.getOrderDate());
				ps.setInt(2, order.getCustomerId());
				ps.setString(3, order.getOrderDescription());	
				ps.setLong(4,totalprice);
				return ps;
			}
		}, holder);
		long orderId= holder.getKey().longValue();
		
		//insert order_line_item
		String ORDER_LINE_ITEM_INSERT_QUERY = "INSERT INTO ORDER_LINE_ITEM ( item_name,item_quantity,order_id) values (?, ?, ?)";
		
		jdbcTemplate.update(ORDER_LINE_ITEM_INSERT_QUERY,order.getItemName(),order.getQuantity(),orderId);
		return orderId;
		
	}

	@Override
	public List<SalesOrderDetails> getAllOderDetails() {
		String sql = "SELECT CS.cust_id,CS.cust_email,CS.cust_first_name,CS.cust_last_name,SO.ORDER_ID,SO.order_date,"
				+ "SO.order_desc,SO.total_price,OLI.ORDER_LINE_ID,OLI.item_quantity "
				+ " FROM CUSTOMER_SOS CS,SALES_ORDER SO,ORDER_LINE_ITEM OLI "
				+ " WHERE CS.cust_id=SO.cust_id AND SO.ORDER_ID=OLI.order_id ";
		RowMapper<SalesOrderDetails> rowMapper = new SalesOrderDetailsRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	
}
