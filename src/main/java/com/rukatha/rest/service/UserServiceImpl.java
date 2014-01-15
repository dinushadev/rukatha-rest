package com.rukatha.rest.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rukatha.rest.dao.UserDao;
import com.rukatha.rest.dto.UserDto;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDto createOrUpdateUser(UserDto newUser) {
		
		UserDto user = userDao.createOrUpdateUser(newUser);
		return user;
	}

}
