package com.voytenko.springdemo.dao;

import java.util.List;

import com.voytenko.springdemo.entity.Customer;

public interface CustomerDAO {

	void saveCustomer(Customer customer);

	List<Customer> getCustomers();

	Customer getCustomer(int id);

	void deleteCustomer(int id);

}
