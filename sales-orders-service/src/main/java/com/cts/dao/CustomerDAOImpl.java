package com.cts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.model.Customer;

@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
    private JdbcTemplate jdbctemplate;

	@Override
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMER_SOS ( cust_id,cust_email,cust_first_name,cust_last_name) values (?, ?, ?,?)";
		jdbctemplate.update(sql,customer.getCustomerId(),customer.getEmail(),customer.getFirstName(),customer.getLastName());
	}

	@Override
	public boolean isCustomerExists(int customerId) {
		boolean result = false;
		String sql = "SELECT count(1) FROM CUSTOMER_SOS where cust_id=?";
		int count = jdbctemplate.queryForObject(
	                        sql, new Object[] { customerId }, Integer.class);
		if (count > 0) {
			result = true;
		}
		return result;
	}
}
