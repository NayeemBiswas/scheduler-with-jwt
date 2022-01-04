package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UIController {

	/**
	 * This controller is use for redirect UI without data
	 * 
	 */
	
	
	@RequestMapping("/dashboard")
	public String lowest_salary() {
		return "dashboard";
	}
	
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/")
	public String signin() {
		return "signin";
	}
	

}