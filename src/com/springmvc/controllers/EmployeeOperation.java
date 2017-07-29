package com.springmvc.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.springmvc.entities.Customer;
import com.springmvc.service.ManageCustomerService;
import com.springmvc.service.ManageLoanService;
import com.springmvc.service.ManagePolicyService;

@Controller
@SessionAttributes("loginedEmployeeId")
@RequestMapping(path = "/m", method = RequestMethod.GET)
public class EmployeeOperation {

	@Autowired
	private ManageCustomerService manageCustomerService;
	@Autowired
	private ManageLoanService manageLoansService;
	@Autowired
	private ManagePolicyService managePolicyService;

	@RequestMapping(path = "/customers")
	public ModelAndView viewCustomersProfiles() {
		int customerNum = manageCustomerService.countCustomer();
		ModelAndView modelAndView = new ModelAndView("manageCustomers", "customerNum", customerNum);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/customers/{page}")
	public List<Customer> getCustomersJSONData(@PathVariable(value = "page") Integer page,
			Map<String, Object> map) {
		if (map.get("loginedEmployeeId") == null) {
			return null;
		}
		System.out.println("loading page: " + page);	
		List<Customer> list = manageCustomerService.getAllCustomer(page);
		System.out.println("Ajax get to JSON: " + list.size());
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/customers/s")
	public List<Customer> searchCustomerJSONData(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name, @RequestParam(value = "email") String email, 
			Map<String, Object> map) {
		if (map.get("loginedEmployeeId") == null) {
			return null;
		}
		System.out.println("search: " + id + name + email);	
		List<Customer> list = manageCustomerService.searchCustomer(id, name, email);
		System.out.println("Ajax get to JSON: " + list.size());
		return list;
	}
	
	@ResponseBody
	@RequestMapping(path = "/customer/validation")
	public List<Customer> checkCustomer(@RequestParam(value = "customerId") Integer id) {
		System.out.println("check validation");
		return manageCustomerService.searchCustomer(id, "", "");		
	}
	
	@RequestMapping("/loans")
	public ModelAndView manageLoans() {
		int loans = 0;
		ModelAndView modelAndView = new ModelAndView("manageLoans", "loans", loans);
		return modelAndView;
	}
	
	@RequestMapping("/policies")
	public ModelAndView managePolicies() {
		int policies = 0;
		ModelAndView modelAndView = new ModelAndView("managePolicies", "policies", policies);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(path="/policy", method=RequestMethod.POST)
	public String newPolicy(@RequestParam(value = "cusId") Integer cusId, 
			@RequestParam(value = "type") String insurType, 
			@RequestParam(value = "startDate") String startDate, 
			@RequestParam(value = "expDate") String expDate, 
			Map<String, Object> map) {
		if (map.get("loginedEmployeeId") == null) {
			return "unauthorized";
		}
		if (cusId == null || insurType == null || startDate == null || expDate == null) {
			return "Please fill all fields";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date endDate = null;
		int empId = (int) map.get("loginedEmployeeId");
		try {
			fromDate = simpleDateFormat.parse(startDate);
			endDate = simpleDateFormat.parse(expDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (fromDate == null || endDate == null) {
			return "date error";
		}
		String result = managePolicyService.newPolicy(cusId, insurType, fromDate, endDate, empId);
		return result;			
	}

	@RequestMapping("/index")
	public String viewEmployeeindex() {
		return "employeeIndex";
	}
}
