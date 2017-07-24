package com.springmvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.EmployeeViewProfileService;
import com.sprinmvc.entities.Customer;


@Controller
@SessionAttributes()
@RequestMapping(path="/e", method=RequestMethod.GET)
public class EmployeeOperation {
	
	
	private EmployeeViewProfileService employeeViewProfileService = new EmployeeViewProfileService();
	
	@RequestMapping(path="/customers")
	public ModelAndView viewCustomersProfiles(@RequestParam(value="page") String page) {
		System.out.println("page: " + page);
		
		List<Customer> list = employeeViewProfileService.getAllCustomer(1);
		
		/*List<Customer> list = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setCustomerName("ccc"); customer.setGender("M");
		list.add(customer);*/
		System.out.println(list);
		ModelAndView modelAndView = new ModelAndView("customersProfiles", "customerList", list);
		return modelAndView;
	}
	
	@RequestMapping("/index")
	public String viewEmployeeindex() {
		return "employeeIndex";
	}
}
