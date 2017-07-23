package com.springmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.EmployeeViewProfileService;
import com.sprinmvc.entities.Customer;


@SessionAttributes()
@Controller
@RequestMapping(path="/e", method=RequestMethod.GET)
public class EmployeeOperation {
	
	@Autowired
	private EmployeeViewProfileService employeeViewProfileService;
	
	@RequestMapping(path="/customersProfiles")
	public ModelAndView viewCustomersProfiles(@RequestParam String page) {
		
		List<Customer> list = employeeViewProfileService.getAllCustomer(1);
		ModelAndView modelAndView = new ModelAndView("customersProfiles", "customerList", list);
		return modelAndView;
	}
}
