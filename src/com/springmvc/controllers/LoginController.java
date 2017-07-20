package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/login", method=RequestMethod.POST)
public class LoginController {
	
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	@RequestMapping()
	public String login() {
		
		return SUCCESS;
	}
	
	@RequestMapping(path="/manager")
	public String managerLogin() {
		
		return "manager";
	}
	
}
