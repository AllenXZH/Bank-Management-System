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

@SessionAttributes({"loginedEmployee"})
@Controller
@RequestMapping(path="/index", method=RequestMethod.GET)
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final String HolderHome = "holderHome";
	
	
	@RequestMapping()
	public String login(LoginCustomer customer) {
		String username = customer.getUsername();
		String password = customer.getPassword();
		if (username.equals("allen") && password.equals("123")) {
			return HolderHome;
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
			String loginedEmployee  = employee.getEmployeeName();
			map.put("loginedEmployee", loginedEmployee);
			return "employeeIndex";
		}
		return ERROR;
	}
	
	public ModelAndView returnModelAndView() {
		ModelAndView modelAndView = new ModelAndView("view");
		
		modelAndView.addObject("name", "allen");
		
		return modelAndView;
	}
	
}
