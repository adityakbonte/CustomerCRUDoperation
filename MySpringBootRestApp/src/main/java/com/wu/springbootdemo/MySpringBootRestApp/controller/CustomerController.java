package com.wu.springbootdemo.MySpringBootRestApp.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.springbootdemo.MySpringBootRestApp.DAO.CustomerDAO;
import com.wu.springbootdemo.MySpringBootRestApp.entity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	CustomerDAO customerDAO;
	
	public CustomerController(CustomerDAO theCustomerDAO) {
		this.customerDAO =  theCustomerDAO;
	}
	
	@GetMapping("/hi")
	public String sayHi() {
		return "Say hi!";
	}
	
	@GetMapping("/customers")
	public ArrayList<Customer> getCustomer(){
		return customerDAO.getCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		
		Customer c1= customerDAO.getCustomerById(id);
		if(c1==null) {
			throw new CustomerNotFoundException("Customer Does Not Exist!!");
		}
		return c1;
	}
	
	@PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer c) {
		Customer c1 = customerDAO.saveCustomer(c);
		return c1;
	}
	
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer c) {
		Customer c1 = customerDAO.saveCustomer(c);
		return c1;
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		Customer c1= customerDAO.getCustomerById(id);
		customerDAO.deleteCustomer(c1);
		return "Customer deleted Successfully!";
	}
}
