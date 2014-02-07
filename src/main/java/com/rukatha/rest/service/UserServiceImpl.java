package com.rukatha.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rukatha.rest.HomeController;
import com.rukatha.rest.dao.UserEntityManager;
import com.rukatha.rest.dao.UserEntityManagerImpl;
import com.rukatha.rest.dto.UserDto;
import com.rukatha.rest.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Autowired
	private UserEntityManagerImpl userEntityManager;
	
	@Override
	public UserDto createOrUpdateUser(UserDto newUser) {
		
		//UserDto user = userDao.createOrUpdateUser(newUser);
		//return user;
		return null;
	}



	@Override
	public UserDto registerUser(UserDto newUser) {
		 
		UserEntity userEntity = userEntityManager.newUser(newUser.getEmail());
		userEntity.setEmail(newUser.getEmail());
		userEntity.setFname(newUser.getFirstName());
		userEntity.setLname(newUser.getLastName());
		
		logger.info("user id:"+userEntity.getUserId());
		
		UserEntity persistUserEntry = userEntityManager.persistEntity(userEntity);
		
		return newUser;
	}



	@Override
	public Boolean isRegisterdUser(UserDto user) {
		
		UserEntity userEntity = userEntityManager.getUserByEmail(user.getEmail());
		
		if(userEntity != null )
			return true;
		else
			return false;
	}

}
