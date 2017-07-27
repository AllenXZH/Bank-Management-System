package com.springmvc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springmvc.dao.CustomerDAO;
import com.springmvc.entities.Customer;

@Service
@Transactional
public class EmployeeViewCustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public List<Customer> getAllCustomer(int page) {

		List<Customer> list = customerDAO.getAllCustomers(page, 15);

		return list;
	}

	public int countCustomer() {
		return customerDAO.countCustomer();
	}
}
