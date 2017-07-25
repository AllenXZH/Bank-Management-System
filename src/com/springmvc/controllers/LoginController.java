package com.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.springmvc.entities.roles.LoginCustomer;
import com.springmvc.entities.roles.LoginEmplyee;
import com.springmvc.service.LoginService;
import com.sprinmvc.entities.Customer;
import com.sprinmvc.entities.Employee;

import org.springframework.ui.ModelMap;

@SessionAttributes("loginedEmployee")
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
	public String managerLogin(LoginEmplyee emplyee) {
		
		String id = emplyee.getId();
		String password = emplyee.getPassword();
		Employee loginedEmployee = (Employee) loginService.login(id, password, "employee");
		if (loginedEmployee != null) {
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
