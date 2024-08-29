package com.wu.springbootdemo.MySpringBootRestApp.DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.wu.springbootdemo.MySpringBootRestApp.entity.Customer;

import jakarta.persistence.EntityManager;



@Repository
public class CustomerDAOImpl implements CustomerDAO {
	// in spring boot the work of sessionFactory done by following entityManager;
	
	private EntityManager entityManager; 
	
	public CustomerDAOImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public ArrayList<Customer> getCustomers() {
		// TODO Auto-generated method stub
//		ArrayList<Customer> customers = new ArrayList<Customer>();
//		Customer c1 = new Customer("121", "Aditya", "Bonte", "ab@wu.com");
//		customers.add(c1);
//		return customers;
		
		
		Query theQuery= (Query) entityManager.createQuery("from Customer",Customer.class);
		
		
//		Session currentSession = entityManager.unwrap(Session.class);
		//Query theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		ArrayList<Customer> customers = (ArrayList<Customer>) theQuery.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		
		
		// ##way 1
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Customer.class, id);
		
		
		//######## way 2
//		Query theQuery = currentSession.createQuery("from Customer where id=:aditya",Customer.class);
		
//		theQuery.setParameter("aditya", id);
//		Customer customers = (Customer) theQuery.getSingleResult();
//		return customers;
	}

	@Override
	@Transactional
	public Customer saveCustomer(Customer c1) {
		// TODO Auto-generated method stub
		
		//Method 1 
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(c1);
		return c1;
		
		//Method 2 easy
//		Customer res = entityManager.merge(c1);
//		return res;
	}

	@Override
	@Transactional
	public Customer deleteCustomer(Customer c1) {
		// TODO Auto-generated method stub
		entityManager.remove(c1);
		return c1;
	}
	
	
	

}
