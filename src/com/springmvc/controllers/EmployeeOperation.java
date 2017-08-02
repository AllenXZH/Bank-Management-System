package com.springmvc.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.springmvc.entities.Customer;
import com.springmvc.entities.Loan;
import com.springmvc.service.ManageCustomerService;
import com.springmvc.service.ManageLoanService;
import com.springmvc.service.ManagePolicyService;

@Controller
@SessionAttributes({"loginedEmployeeId", "loginedEmployeeName"})
@RequestMapping(path = "/m")
public class EmployeeOperation {

	@Autowired
	private ManageCustomerService manageCustomerService;
	@Autowired
	private ManageLoanService manageLoansService;
	@Autowired
	private ManagePolicyService managePolicyService;
	
	@RequestMapping(path = "/customers")
	public ModelAndView viewCustomersProfiles(ModelMap map) {
		if (map.get("loginedEmployeeId") == null) {
			return new ModelAndView("redirect:/business/loginManager");
		}
		int customerNum = manageCustomerService.countCustomer();
		ModelAndView modelAndView = new ModelAndView("manageCustomers", "customerNum", customerNum);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/customers/{page}")
	public List<Customer> getCustomersJSONData(@PathVariable(value = "page") Integer page,
			ModelMap map) {
		if (map.get("loginedEmployeeId") == null) {
			return null;
		}
		System.out.println("loading customer page: " + page);	
		List<Customer> list = manageCustomerService.getAllCustomer(page);
		System.out.println("Ajax get to JSON: " + list.size());
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/customers/s")
	public List<Customer> searchCustomerJSONData(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name, @RequestParam(value = "email") String email, 
			ModelMap map) {
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
	public String checkCustomer(@RequestParam(value = "customerId") Integer id) {
		System.out.println("check validation");
		List<Customer> list = manageCustomerService.searchCustomer(id, "", "");	
		if (list == null || list.size() == 0) {
			return null;
		}		
		return list.get(0).getCustomerName();
	}
	
	//Manage Loan Operations
	@RequestMapping("/loans")
	public ModelAndView manageLoans(ModelMap map) {
		if (map.get("loginedEmployeeId") == null) {
			return new ModelAndView("redirect:/business/loginManager");
		}
		int loanNum = manageLoansService.countLoan();
		ModelAndView modelAndView = new ModelAndView("manageLoans", "loanNum", loanNum);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/loans/{page}")
	public List<Loan> getLoansJSONData(@PathVariable(value = "page") Integer page, ModelMap map) {
		if (map.get("loginedEmployeeId") == null) {
			return null;
		}
		System.out.println("loading loan page: " + page);	
		List<Loan> list = manageLoansService.getAllLoans(page);
		System.out.println("Ajax get to JSON: " + list.size());
		return list;
	}
	
	//UPDATE
	@ResponseBody
	@RequestMapping(path="/loan/{loanNo}", method=RequestMethod.PUT)
	public String updateLoanByNo(@PathVariable(value = "loanNo") long loanNo, 
			@RequestParam(value = "approve") char approve, ModelMap map) {
		if (map.get("loginedEmployeeId") == null) {
			return "Unauthorized";
		}
		if (approve == 'Y') {
			manageLoansService.approveLoan(loanNo, true);			
			return "Approve success!";
		}
		if (approve == 'N') {
			manageLoansService.approveLoan(loanNo, false);			
			return "Reject success!";
		}
		return "Unknow Operation";
	}
	//DELETE
	@ResponseBody
	@RequestMapping(path="/loan/{loanNo}", method=RequestMethod.DELETE)
	public String deleteLoanByNo(@PathVariable(value = "loanNo") long loanNo, ModelMap map) {
		if (map.get("loginedEmployeeId") == null) {
			return "Unauthorized";
		}
		if (manageLoansService.deleteLoan(loanNo)) {
			return "Delete success!";			
		} else {
			return "ERROR!";
		}
	}
	
	//Manage Policy Operations
	@RequestMapping("/policies")
	public ModelAndView managePolicies(ModelMap map) {
		if (map.get("loginedEmployeeId") == null) {
			return new ModelAndView("redirect:/business/loginManager");
		}
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
			ModelMap map) {
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

	@RequestMapping(path="/index")
	public String goEmployeeindex(ModelMap map) {
		if (map.get("loginedEmployeeId") == null) {
			return "redirect:/business/loginManager";
		}
		return "employeeIndex";
	}
	
	@RequestMapping("/Logout")
	public String signout(SessionStatus session) {
		session.setComplete();
		return "redirect:/";
	}
}
