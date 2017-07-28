package com.springmvc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springmvc.dao.CustomerDAO;
import com.springmvc.entities.Customer;

@Service
@Transactional
public class ManageCustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public List<Customer> getAllCustomer(int page) {

		List<Customer> list = customerDAO.getAllCustomers(page, 10);

		return list;
	}
	
	public List<Customer> searchCustomer(Integer id, String name, String email) {
		return customerDAO.searchCustomer(id, name, email);
	}

	public int countCustomer() {
		return customerDAO.countCustomer();
	}
}
