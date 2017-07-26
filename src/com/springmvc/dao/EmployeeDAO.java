package com.springmvc.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springmvc.entities.Employee;

@Repository
public class EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public String save() {
		Employee employee = new Employee();
		employee.setEmployeeName("allen");
		employee.setGender("M");
		employee.setPassword("123");
		sessionFactory.getCurrentSession().save(employee);
		sessionFactory.getCurrentSession().getTransaction().commit();
		return "success";
	}

	@SuppressWarnings("unchecked")
	public Employee login(String id, String password) {
		if (id != null && password != null) {
			Employee employee = null;
			String hql = "SELECT new Employee(employeeId, employeeName) FROM Employee"
					+ " WHERE employeeId = :id AND password = :password";
			Query query = getSession().createQuery(hql);
			query.setInteger("id", Integer.parseInt(id)).setString("password", password);
			List<Employee> list = query.list();
			if (list != null || list.size() != 0) {
				employee = list.get(0);
				System.out.println(employee);
				return employee;
			}
		}
		return null;
	}

}
