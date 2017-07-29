package com.springmvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "policy")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyNo;
	
	@Column
	private int customerId;

	@Column
	private String type;
	
	@Column
	private String purchaseDate;
	
	@Column
	private String policyStartDate;
	
	@Column
	private String policyExpDate;
	
	@Column
	private String approved;
}
