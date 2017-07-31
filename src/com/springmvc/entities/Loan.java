package com.springmvc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long LoanNo;
	
	@Column
	private int TimePeriod;
	
	@Column
	private double RateOfInterest;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date LoanDate;
	
	@Column
	private char approved;

	public long getLoanNo() {
		return LoanNo;
	}

	public void setLoanNo(long loanNo) {
		LoanNo = loanNo;
	}

	public int getTimePeriod() {
		return TimePeriod;
	}

	public void setTimePeriod(int timePeriod) {
		TimePeriod = timePeriod;
	}

	public double getRateOfInterest() {
		return RateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		RateOfInterest = rateOfInterest;
	}

	public Date getLoanDate() {
		return LoanDate;
	}

	public void setLoanDate(Date loanDate) {
		LoanDate = loanDate;
	}

	public char getApproved() {
		return approved;
	}

	public void setApproved(char approved) {
		this.approved = approved;
	}
	
	public Loan() {
		// TODO Auto-generated constructor stub
		super();
		this.approved = 'U';
	}

	@Override
	public String toString() {
		return "Loan [LoanNo=" + LoanNo + ", TimePeriod=" + TimePeriod + ", RateOfInterest=" + RateOfInterest
				+ ", LoanDate=" + LoanDate + ", approved=" + approved + "]";
	}
}
