package com.robomq.service;

import java.sql.ResultSet;


import com.robomq.pojo.Customer;

public interface CustomerService {
	public boolean createCustomer(Customer c);
	public ResultSet displayCustomer(Customer c);
	public boolean deleteCustomer(Customer c);
	public boolean updateCustomer(Customer c);
	public ResultSet loginCustomer(Customer c);
}
