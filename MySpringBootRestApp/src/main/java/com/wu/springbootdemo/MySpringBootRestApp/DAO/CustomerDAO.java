package com.wu.springbootdemo.MySpringBootRestApp.DAO;

import java.util.ArrayList;

import com.wu.springbootdemo.MySpringBootRestApp.entity.Customer;

public interface CustomerDAO {
	public ArrayList<Customer> getCustomers();

	public Customer getCustomerById(int id);

	public Customer saveCustomer(Customer c1);

	public Customer deleteCustomer(Customer c1);
	
	
}
