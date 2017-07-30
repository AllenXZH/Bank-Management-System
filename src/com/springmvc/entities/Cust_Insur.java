package com.springmvc.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Cust_Insurance")
public class Cust_Insur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int comId;

	@Column
	private int custId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "InsurId")
	private Insurance insurance;

	@Temporal(TemporalType.DATE)
	private Date purchaseDate;

	@Temporal(TemporalType.DATE)
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column
	private boolean approved;

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Cust_Insur(int custId, Date fromDate, Date endDate) {
		super();
		this.custId = custId;
		this.purchaseDate = new Date();
		this.fromDate = fromDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Cust_Insur [comId=" + comId + ", custId=" + custId + ", insurance=" + insurance + ", purchaseDate="
				+ purchaseDate + ", fromDate=" + fromDate + ", endDate=" + endDate + ", approved=" + approved + "]";
	}

}
