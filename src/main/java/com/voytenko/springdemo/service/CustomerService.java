package com.voytenko.springdemo.service;

import java.util.List;

import com.voytenko.springdemo.entity.Customer;

public interface CustomerService {

	void saveCustomer(Customer customer);

	List<Customer> getCustomers();

	Customer getCustomer(int id);

	void deleteCustomer(int id);
	
}
