package com.voytenko.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.voytenko.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the sessionFactory bean from DemoAppConfig
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCustomer(Customer customer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/update the customer ... finally LOL
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query  ... sort by last name
		Query<Customer> query =
				currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results		
		return customers;
	}

	@Override
	public Customer getCustomer(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Customer customer = currentSession.get(Customer.class, id);

		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query query =
				currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);

		query.executeUpdate();
	}
}











