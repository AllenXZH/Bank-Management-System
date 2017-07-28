package com.springmvc.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSInput;

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
		
		String hql = "FROM Customer";
		Query query = getSession().createQuery(hql);

		query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);

		List<Customer> list = query.list();

		return list;
	}
	
	public int countCustomer() {
		String hql = "SELECT COUNT(*) FROM Customer";
		Query query = getSession().createQuery(hql);
		int count = (int)(long)query.uniqueResult();
		System.out.println("total customer: " + count);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> searchCustomer(Integer id, String name, String email) {
		String hql = "FROM Customer WHERE ";
		if (id != null && id != 0) {
			hql += "id = " + id;
		}
		if (name != null && name.length() != 0) {
			if (id != null && id != 0) {
				hql += " AND ";
			}
			hql += "customerName LIKE " + "'%" + name + "%'";
		}
		if (email != null && email.length() != 0) {
			if (id != null && id != 0 || name != null && name.length() != 0) {
				hql += " AND ";
			}
			hql += "email LIKE " + "'%" + email + "%'";
		}
		Query query = getSession().createQuery(hql);
		List<Customer> list = query.list();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Customer login(String username, String password) {
		if (username != null && password != null) {
			Customer customer = null;
			String hql = "SELECT new Customer(customerName, gender) FROM Customer"
					+ " WHERE customerName = :customerName AND password = :password";
			Query query = getSession().createQuery(hql);
			query.setString("customerName", username).setString("password", password);
			List<Customer> list = query.list();
			if (list != null && list.size() != 0) {
				customer = list.get(0);
				System.out.println(customer);
				return customer;
			}
		}				
		return null;
	}
}
