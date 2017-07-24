package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.EmployeeDAO;

public class LoginService {
	
	
	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public Object login(String id, String password, String role) {
		
		if (role.equals("customer")) {
			return true;
		} else if (role.equals("employee")) {
			return employeeDAO.login(id, password);
		} else {
			return false;
		}
	}
	
}
