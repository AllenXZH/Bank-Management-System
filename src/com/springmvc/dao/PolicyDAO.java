package com.springmvc.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.entities.Cust_Insur;
import com.springmvc.entities.Insurance;

@Repository
public class PolicyDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();		
	}
	
	public boolean newPolicy(Integer custId, String insurType, Date fromDate,  Date endDate, Integer empId) {
		Insurance insurance = new Insurance(insurType, 250.0, empId, "");
		try {
			Cust_Insur policy = new Cust_Insur(custId, fromDate, endDate);
			policy.setInsurance(insurance);
			
			getSession().save(policy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
