package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.LoanDAO;
import com.springmvc.entities.Loan;

@Service
@Transactional
public class ManageLoanService {
	@Autowired
	private LoanDAO loanDAO;
	
	public boolean newLoan() {
		return loanDAO.newLoan();
	}
	
	public List<Loan> getAllLoans(int page) {
		return loanDAO.getAllLoans(page, 10);
	}
	
	public int countLoan() {
		return loanDAO.countLoan();
	}
	
	public boolean approveLoan(long LoanNo, boolean approve) {
		return loanDAO.approveLoan(LoanNo, approve);
	}
	
	public boolean deleteLoan(long LoanNo) {
		return loanDAO.deleteLoan(LoanNo);
	}
}
