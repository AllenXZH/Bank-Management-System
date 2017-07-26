package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.CustomerDAO;
import com.springmvc.dao.EmployeeDAO;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private CustomerDAO customerDAO;
	
	public Object login(String loginId, String password, String role) {
		
		if (role.equals("customer")) {
			return customerDAO.login(loginId, password);
		} else if (role.equals("employee")) {
			return employeeDAO.login(loginId, password);
		} else {
			return null;
		}
	}
	
}
