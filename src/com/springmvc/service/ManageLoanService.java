package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.LoanDAO;

@Service
public class ManageLoanService {
	@Autowired
	private LoanDAO loanDAO;
}
