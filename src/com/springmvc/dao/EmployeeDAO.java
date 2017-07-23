package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.springmvc.entities.roles.Customer;

public class EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public String save() {
		
		
		return "success";
	}
	
	public List<Customer> getAllContacts()
	{
		String hql = "SELECT worker "
				+ "FROM Worker worker "
				+ "WHERE worker.pay.month > :para AND worker.id < :id";
		
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery(hql);
		
		
		query.setParameter("para", 46)
			.setParameter("id", 8);
		
		
		java.util.List<Customer> customers = query.list();
		System.out.println(customers);
		return customers;
	}
	
	public EmployeeDAO() {
		sessionFactory.openSession().beginTransaction();
	}
	
	public void testHQL(){
		
		
	}
	
}
