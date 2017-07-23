package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprinmvc.entities.Customer;

public class EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public String save() {
		
		
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers()
	{
		String hql = "SELECT Customer FROM Customer";
		
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery(hql);
		
		java.util.List<Customer> customers = query.list();
		
		return customers;
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers(int page, int pageSize) {
		
		String hql = "SELECT Customer FROM Customer";
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize);
		
		List<Customer> list = query.list();
		
		return list;		
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> searchCustomersByName(int page, int pageSize, String name) {
		
		String hql = "SELECT Customer FROM Customer"
					+ "WHERE customerName LIKE : name";
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter("name", "%"+name+"%");
		query.setFirstResult((page-1)*pageSize)
				.setMaxResults(pageSize);
		
		List<Customer> list = query.list();
		
		return list;
	}
	
	public void testHQL(){
		
		
	}
	
}
