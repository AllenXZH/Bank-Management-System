package com.springmvc.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entities.Customer;
import com.springmvc.entities.Employee;
import com.springmvc.entities.roles.LoginCustomer;
import com.springmvc.entities.roles.LoginEmplyee;
import com.springmvc.service.LoginService;

import org.springframework.ui.ModelMap;

@Controller
@RequestMapping(path="/index", method=RequestMethod.GET)
@SessionAttributes({"loginedEmployee", "loginedCustomerName"})
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final String CustomerHome = "customerIndex";
	private static final String EmployeeHome = "employeeIndex";
	
	
	@RequestMapping()
	public String login(LoginCustomer logincustomer, Map<String, Object> map) {
		String username = logincustomer.getUsername();
		String password = logincustomer.getPassword();
		if (username == null || password == null || username.length() == 0 || password.length() == 0) {
			return ERROR;
		}
		Customer customer = (Customer) loginService.login(username, password, "customer");
		if (customer != null) {
			String loginedCustomerName = customer.getCustomerName();
			map.put("loginedCustomerName", loginedCustomerName);
			return CustomerHome; 
		}
		return ERROR;
	}
	
	@RequestMapping(path="/manager")
	public String managerLogin(LoginEmplyee loginEmplyee, Map<String, Object> map) {
		
		String id = loginEmplyee.getId();
		String password = loginEmplyee.getPassword();
		if (id == null || password == null || id.length() == 0 || password.length() == 0) {
			return ERROR;
		}
		Employee employee = (Employee) loginService.login(id, password, "employee");
		if (employee != null) {
			String loginedEmployeeName  = employee.getEmployeeName();
			map.put("loginedEmployeeName", loginedEmployeeName);
			return EmployeeHome;
		}
		return ERROR;
	}
	
	public ModelAndView returnModelAndView() {
		ModelAndView modelAndView = new ModelAndView("view");
		
		modelAndView.addObject("name", "allen");
		
		return modelAndView;
	}
	
}
