package com.sprinmvc.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(columnDefinition="VARCHAR",length=10,nullable=false)
	private int id;

	@Column(columnDefinition="VARCHAR",length=20,nullable=false)
	private String customerName;

	@Column(columnDefinition="VARCHAR",length=20,nullable=false)
	private String password;

	@Column(columnDefinition="VARCHAR",length=1,nullable=false)
	private String gender;

	@Column
	private double loan;

	@ManyToMany
	@JoinTable(name = "Cust_Insur", joinColumns = { @JoinColumn(name = "CustId") }, inverseJoinColumns = {
			@JoinColumn(name = "InsurId") })
	private Set<Insurance> insurancesOrdered = new HashSet<>();

	@OneToMany
	@JoinColumn(name = "CustId")
	private Set<Query> queriesCreated = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getLoan() {
		return loan;
	}

	public void setLoan(double loan) {
		this.loan = loan;
	}

	public Set<Insurance> getInsurancesOrdered() {
		return insurancesOrdered;
	}

	public void setInsurancesOrdered(Set<Insurance> insurancesOrdered) {
		this.insurancesOrdered = insurancesOrdered;
	}

	public Set<Query> getQueriesCreated() {
		return queriesCreated;
	}

	public void setQueriesCreated(Set<Query> queriesCreated) {
		this.queriesCreated = queriesCreated;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + id + ", customerName=" + customerName + ", password=" + password
				+ ", gender=" + gender + "]";
	}

}
