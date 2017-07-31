package com.springmvc.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entities.Loan;

@Repository
public class LoanDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public boolean newLoan() {
		Loan loan = new Loan();
		loan.setRateOfInterest(2.80);
		loan.setTimePeriod(3);
		loan.setLoanDate(new Date());
		try {
			getSession().save(loan);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Loan> getAllLoans(int page, int pageSize) {
		String hql = "FROM Loan";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);
		List<Loan> list = query.list();
		return list;
	}
	
	public int countLoan() {
		String hql = "SELECT COUNT(*) FROM Loan";
		Query query = getSession().createQuery(hql);
		int count = (int)(long)query.uniqueResult();
		System.out.println("total loan: " + count);
		return count;
	}
	
	public boolean approveLoan(long LoanNo, boolean approve) {
		try {
			Loan loan = (Loan) getSession().createQuery("FROM Loan WHERE LoanNo = " + LoanNo).uniqueResult();
			if (loan != null) {
				if (loan.getApproved() != 'U') {
					return false;
				}
				loan.setApproved(approve?'Y':'N');
				System.out.println("update: " + loan);
				getSession().update(loan);
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteLoan(long LoanNo) {
		try {
			Loan loan = (Loan) getSession().createQuery("FROM Loan WHERE LoanNo = " + LoanNo).uniqueResult();
			if (loan != null) {
				System.out.println("delete: " + loan);
				getSession().delete(loan);
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
