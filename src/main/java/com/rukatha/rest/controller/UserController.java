package com.rukatha.rest.controller;

import javax.xml.ws.ResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rukatha.rest.dto.UserDto;
import com.rukatha.rest.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value ="/reg",method =RequestMethod.POST)
	public @ResponseBody UserDto registerUser(@RequestBody final UserDto newUser){
		
		
		UserDto user = userService.registerUser(newUser);
		return user;
	}
	
	@RequestMapping(value ="/check",method =RequestMethod.POST)
	public @ResponseBody String userCheck(@RequestBody final UserDto user){
		
		Boolean  status = userService.isRegisterdUser(user);
		
		return "{'statuse':'"+status+"'}";
	}

	@RequestMapping(value ="/check",method =RequestMethod.GET)
	public @ResponseBody String userCheck(){
		
		
		return "{'statuse':true}";
	}
}
