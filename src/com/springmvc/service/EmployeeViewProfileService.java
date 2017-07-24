package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.dao.EmployeeDAO;
import com.sprinmvc.entities.Customer;

public class EmployeeViewProfileService {
	
	
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	@ResponseBody
	public List<Customer> getAllCustomer(int page) {
		
		return employeeDAO.getAllCustomers(page, 20);		
	}
}
