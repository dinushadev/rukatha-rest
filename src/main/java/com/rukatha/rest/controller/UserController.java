package com.rukatha.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rukatha.rest.dao.UserDao;
import com.rukatha.rest.dto.UserDto;
import com.rukatha.rest.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/reg",method =RequestMethod.POST)
	public void registerUser(UserDto newUser){
		
		UserDto user = userService.createOrUpdateUser(newUser);
		
	}

}
