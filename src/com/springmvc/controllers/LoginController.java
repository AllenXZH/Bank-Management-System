package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.loginRole.PolicyHolder;

@Controller
@RequestMapping(path="/login", method=RequestMethod.GET)
public class LoginController {
	
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final String HolderHome = "holderHome";
	
	
	@RequestMapping()
	public String login(PolicyHolder holder) {
		String username = holder.getUsername();
		String password = holder.getPassword();
		if (username.equals("allen") && password.equals("123")) {
			return HolderHome;
		}
		return ERROR;
	}
	
	@RequestMapping(path="/manager")
	public String managerLogin() {
		
		return "manager";
	}
	
}
