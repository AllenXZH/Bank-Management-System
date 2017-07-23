package com.sprinmvc.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition="VARCHAR",length=20,nullable=false)
	private int employeeId;

	@Column(columnDefinition="VARCHAR",length=20,nullable=false)
	private String employeeName;
	
	@Column(columnDefinition="VARCHAR",length=20,nullable=false)
	private String password;
	
	@Column(columnDefinition="VARCHAR",length=1,nullable=false)
	private String Gender;

	@OneToMany
	@JoinColumn(name = "EmpId")
	private Set<Insurance> insurancesGenerated = new HashSet<>();

	@OneToMany
	@JoinColumn(name = "EmpId")
	private Set<Customer> loaners = new HashSet<>();

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Set<Insurance> getInsurancesGenerated() {
		return insurancesGenerated;
	}

	public void setInsurancesGenerated(Set<Insurance> insurancesGenerated) {
		this.insurancesGenerated = insurancesGenerated;
	}

	public Set<Customer> getLoaners() {
		return loaners;
	}

	public void setLoaners(Set<Customer> loaners) {
		this.loaners = loaners;
	}

}
