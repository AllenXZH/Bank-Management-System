package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.PolicyDAO;

@Service
public class ManagePolicyService {
	@Autowired
	private PolicyDAO policyDAO;
}
