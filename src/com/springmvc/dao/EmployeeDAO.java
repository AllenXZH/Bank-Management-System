package com.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprinmvc.entities.Customer;
import com.sprinmvc.entities.Employee;

@Repository
public class EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public String save() {
		Customer customer = new Customer();
		customer.setCustomerName("xu");
		customer.setGender("M");
		sessionFactory.getCurrentSession().save(customer);
		sessionFactory.getCurrentSession().getTransaction().commit();
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers()
	{
		String hql = "SELECT Customer FROM Customer";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		List<Customer> customers = query.list();
		
		return customers;
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers(int page, int pageSize) {
		
		String hql = "SELECT Customer FROM Customer";
		/*Query<Customer> query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setFirstResult((page-1)*pageSize)
		.setMaxResults(pageSize);*/
		
		//List<Customer> list = query.list();
		
		List<Customer> list = new ArrayList<>();
		Customer customer = new Customer();
		customer.setCustomerName("ccc"); customer.setGender("M");
		list.add(customer);
		System.out.println(list);
		return list;		
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> searchCustomersByName(int page, int pageSize, String name) {
		
		String hql = "SELECT Customer FROM Customer"
					+ "WHERE customerName LIKE : name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter("name", "%"+name+"%");
		query.setFirstResult((page-1)*pageSize)
				.setMaxResults(pageSize);
		
		List<Customer> list = query.list();
		
		return list;
	}
	
	public void testHQL(){
		
		
	}
	
	public Employee login(String id, String password) {
		
		if (id!=null && password != null && id.equals("allen") && password.equals("123")) {
			Employee employee = new Employee();
			employee.setEmployeeName("allen");
			employee.setGender("M");
			return employee;
		} else {
			return null;
		}
	}
	
}
