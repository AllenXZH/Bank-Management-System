package com.springmvc.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.CustomerDAO;
import com.springmvc.dao.PolicyDAO;

@Service
@Transactional
public class ManagePolicyService {
	@Autowired
	private PolicyDAO policyDAO;
	@Autowired
	private CustomerDAO customerDAO;
	
	public String newPolicy(Integer custId, String insurType, Date fromDate,  Date endDate, Integer empId) {
		if (customerDAO.searchCustomer(custId, "", "").size() == 0) {
			return "ERROR! Invalid CustomerID!";
		}
		boolean success = policyDAO.newPolicy(custId, insurType, fromDate, endDate, empId);
		if (!success) {
			return "Generate new policy ERROR!";
		}
		return "success";
	}
}
