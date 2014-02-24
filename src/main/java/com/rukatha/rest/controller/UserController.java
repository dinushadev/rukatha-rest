package com.rukatha.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rukatha.rest.auth.BaseController;
import com.rukatha.rest.dto.UserReqDto;
import com.rukatha.rest.service.UserService;


@Controller
@RequestMapping("/rest/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value ="/reg",method =RequestMethod.POST)
	public @ResponseBody UserReqDto registerUser(@RequestBody final UserReqDto newUser){
		
		
		UserReqDto user = userService.registerUser(newUser);
		return user;
	}
	
	@RequestMapping(value ="/check",method =RequestMethod.POST)
	public @ResponseBody String userCheck(@RequestBody final UserReqDto user){
		
		Boolean  status = userService.isRegisterdUser(user);
		
		return "{\"status\":"+status+"}";
	}

}
