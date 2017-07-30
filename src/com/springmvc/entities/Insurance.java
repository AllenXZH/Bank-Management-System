package com.springmvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insurance")
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int InsurId;

	@Column
	private String insuranceName;

	@Column
	private double insurancePrice;

	@Column
	private int EmpId;

	@Column
	private String description;

	public int getInsurId() {
		return InsurId;
	}

	public void setInsurId(int InsurId) {
		this.InsurId = InsurId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int EmpId) {
		this.EmpId = EmpId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Insurance(String insuranceName, double insurancePrice, int empId, String description) {
		super();
		this.insuranceName = insuranceName;
		this.insurancePrice = insurancePrice;
		this.EmpId = empId;
		this.description = description;
	}

	public Insurance() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + InsurId + ", insuranceName=" + insuranceName + ", insurancePrice="
				+ insurancePrice + ", EmpId=" + EmpId + ", description=" + description + "]";
	}

}