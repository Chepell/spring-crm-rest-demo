package com.voytenko.springdemo.rest;

import com.voytenko.springdemo.entity.Customer;
import com.voytenko.springdemo.exception.CustomerNotFoundException;
import com.voytenko.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Artem Voytenko
 * 31.01.2019
 */

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	// inject dependency
	@Autowired
	private CustomerService customerService;

	// endpoint to get all customer from DB
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	// endpoint to add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		// also just in case the pass an id JSON ... set id to 0
		// this is force a save new item instead of update
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}

	// endpoint to add update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		// just update existing object in DB
		customerService.saveCustomer(customer);
		return customer;
	}

	// endpoint to get single customer
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id: " + customerId + ", not found!");
		}
		return customer;
	}

	// endpoint to delete customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		// try to get customer, if isn't exist throw exception
		getCustomer(customerId);
		// if exist than delete
		customerService.deleteCustomer(customerId);
		return "Customer with id: " + customerId + ", deleted!";
	}
}
