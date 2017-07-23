package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.EmployeeDAO;

public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

}
