package com.springmvc.controllers;

import java.util.Map;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
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
@RequestMapping()
@SessionAttributes({"loginedEmployeeName", "loginedEmployeeId", "loginedCustomerName"})
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	//jsp name list
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final String CustomerHome = "customerIndex";
	private static final String EmployeeHome = "employeeIndex";
	
	@RequestMapping()
	public String login(LoginCustomer logincustomer, ModelMap map) {
		
		String username = logincustomer.getUsername();
		String password = logincustomer.getPassword();
		if (username == null || password == null || username.length() == 0 || password.length() == 0) {
			return ERROR;
		}
		Customer customer = (Customer) loginService.login(username, password, "customer");
		if (customer != null) {
			String loginedCustomerName = customer.getCustomerName();
			map.put("loginedCustomerName", loginedCustomerName);
			
			return "redirect:/business/index";
		}
		return ERROR;
	}
	
	@RequestMapping(path="/m")
	public String managerLogin(LoginEmplyee loginEmplyee, ModelMap map) {
		
		String id = loginEmplyee.getId();
		String password = loginEmplyee.getPassword();
		if (id == null || password == null || id.length() == 0 || password.length() == 0) {
			return ERROR;
		}
		Employee employee = (Employee) loginService.login(id, password, "employee");
		if (employee != null) {
			String loginedEmployeeName  = employee.getEmployeeName();
			int loginedEmployeeId  = employee.getEmployeeId();
			map.put("loginedEmployeeName", loginedEmployeeName);
			map.put("loginedEmployeeId", loginedEmployeeId);
			
			return "redirect:/business/index";
		}
		return ERROR;
	}
	
	@RequestMapping("/index")
	public String loginAutoForward(ModelMap map) {
		if (map.get("loginedEmployeeId") != null) {
			return EmployeeHome;			
		}
		if (map.get("loginedCustomerName") != null) {
			return CustomerHome;
		}
		return "redirect:/";
	}
	
	@RequestMapping(path={"/loginManager", "/m/*"})
	public String testManagerLogin(ModelMap map) {
		if (map.get("loginedEmployeeId") != null) {
			return EmployeeHome;
		} else {
			return "loginManager";
		}
	}
	@RequestMapping(path={"/loginCustomer", "/*"})
	public String testCustomerLogin(ModelMap map) {
		if (map.get("loginedEmployeeId") != null) {
			return CustomerHome;
		} else {
			return "login";
		}
	}
	
}
