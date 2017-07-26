package com.springmvc.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.springmvc.entities.Customer;
import com.springmvc.service.EmployeeViewProfileService;

@Controller
@SessionAttributes()
@RequestMapping(path = "/m", method = RequestMethod.GET)
public class EmployeeOperation {

	@Autowired
	private EmployeeViewProfileService employeeViewProfileService;

	@RequestMapping(path = "/customers")
	public ModelAndView viewCustomersProfiles() {
		int customerNum = employeeViewProfileService.countCustomer();
		ModelAndView modelAndView = new ModelAndView("manageCustomers", "customerNum", customerNum);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/customers/page")
	public List<Customer> getCustomersJSONData(@RequestParam(value = "page") String page) {
		System.out.println("loading page: " + page);	
		List<Customer> list = employeeViewProfileService.getAllCustomer(Integer.parseInt(page));
		System.out.println(list);
		/*List<Customer> list = new ArrayList<>();
		list.add(new Customer("Mike", "M"));
		list.add(new Customer("Mary", "F"));*/
		return list;
	}

	@RequestMapping("/index")
	public String viewEmployeeindex() {
		return "employeeIndex";
	}
}
