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
	
	public List<Customer> getAllCustomers()
	{
		String hql = "SELECT Customer FROM Customer";
		
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery(hql);
		
		java.util.List<Customer> customers = query.list();
		//System.out.println(customers);
		return customers;
	}
	
	public List<Customer> getCustomers(int page, int num) {
		
		String hql = "SELECT Customer FROM Customer";
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setFirstResult(page-1).setMaxResults(num);
		
		List<Customer> list = query.list();
		//System.out.println(customers);
		return list;		
	}
	
	public EmployeeDAO() {
		//sessionFactory.openSession().beginTransaction();
	}
	
	public void testHQL(){
		
		
	}
	
}
