package com.CustomerManagementAPI.service;

import java.util.List;

import com.CustomerManagementAPI.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
