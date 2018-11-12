package com.CustomerManagementAPI.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerManagementAPI.entity.Customer;
import com.CustomerManagementAPI.error.CustomerNotFoundException;
import com.CustomerManagementAPI.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController 
{
	//autowire the customerService
	@Autowired
	private CustomerService customerService;
	
	
	//add the mapping for GET /customers - get List of Customer
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	//add the mapping to GET /customers/{customerId} - get a single Customer
	@GetMapping("/customers/{theCustomerId}")
	public Customer getCustomer(@PathVariable int theCustomerId)
	{
		Customer theCustomer = customerService.getCustomer(theCustomerId);
		if(theCustomer == null)
		{
			throw new CustomerNotFoundException("the customer Id:"+theCustomerId+" not Found");
		}
		return theCustomer;
		
	}
	
	//add the mapping to POST /customers - create a new Customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer)
	{
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	//add the mapping to PUT /customers - update a Customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	//add the mapping to DELETE /customers/{theCustomerId} - detele a Customer
	@DeleteMapping("/customers/{theCustomerId}")
	public String deleteCustomer(@PathVariable int theCustomerId)
	{
		Customer theCustomer = customerService.getCustomer(theCustomerId);
		if(theCustomer == null)
		{
			throw new CustomerNotFoundException("the customer Id:"+theCustomerId+" not Found");
		}
		customerService.deleteCustomer(theCustomerId);
		return "Deleted Customer id:"+theCustomerId;
	}

}
