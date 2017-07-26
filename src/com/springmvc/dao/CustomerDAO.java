package com.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entities.Customer;

@Repository
public class CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public String save() {
		Customer customer = new Customer();
		customer.setCustomerName("Mike");;
		customer.setGender("M");
		customer.setPassword("111");
		sessionFactory.getCurrentSession().save(customer);
		sessionFactory.getCurrentSession().getTransaction().commit();
		return "success";
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		String hql = "SELECT Customer FROM Customer";

		Query query = getSession().createQuery(hql);

		List<Customer> customers = query.list();

		return customers;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers(int page, int pageSize) {

		String hql = "SELECT Customer FROM Customer";
		Query query = getSession().createQuery(hql);

		query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);

		List<Customer> list = query.list();

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> searchCustomersByName(int page, int pageSize, String name) {

		String hql = "SELECT Customer FROM Customer" + "WHERE customerName LIKE : name";
		Query query = getSession().createQuery(hql);

		query.setParameter("name", "%" + name + "%");
		query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);

		List<Customer> list = query.list();

		return list;
	}
}
