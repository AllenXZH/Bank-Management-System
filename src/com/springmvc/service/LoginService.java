package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.EmployeeDAO;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public Object login(String id, String password, String role) {
		
		if (role.equals("customer")) {
			return null;
		} else if (role.equals("employee")) {
			return employeeDAO.login(id, password);
		} else {
			return null;
		}
	}
	
}
