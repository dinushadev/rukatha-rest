package com.rukatha.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class UIController {

	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/signin")
	public String signin() {
		
		return "signin";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		
		return "signup";
	}
}
