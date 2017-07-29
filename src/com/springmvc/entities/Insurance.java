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
	private int insuranceId;

	@Column
	private String insuranceName;

	@Column
	private double insurancePrice;

	@Column
	private int EmpId;

	@Column
	private String description;

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
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

	public void setEmpId(int empId) {
		EmpId = empId;
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
		EmpId = empId;
		this.description = description;
	}

	public Insurance() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", insuranceName=" + insuranceName + ", insurancePrice="
				+ insurancePrice + ", EmpId=" + EmpId + ", description=" + description + "]";
	}

}