package com.rukatha.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rukatha.rest.auth.BaseController;

@Controller
@RequestMapping("/ui")
public class UIController extends BaseController{

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
	
	@RequestMapping("/userhome")
	public String userhome() {
		
		return "userhome";
	}
	
	@RequestMapping("/kataworkbench")
	public String kataworkbench() {
		
		return "kataworkbench";
	}
	
	@RequestMapping("/logout")
	public @ResponseBody String logout(HttpServletRequest request) {
		request.getSession().setAttribute("USER_SESSION", "OFF");
		return "{\"status\":\"true\"}";
	}
}
