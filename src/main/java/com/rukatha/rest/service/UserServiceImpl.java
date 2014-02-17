package com.rukatha.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rukatha.rest.HomeController;
import com.rukatha.rest.dao.UserEntityManager;
import com.rukatha.rest.dao.UserEntityManagerImpl;
import com.rukatha.rest.dto.UserReqDto;
import com.rukatha.rest.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Autowired
	private UserEntityManagerImpl userEntityManager;
	
	@Override
	public UserReqDto createOrUpdateUser(UserReqDto newUser) {
		
		//UserDto user = userDao.createOrUpdateUser(newUser);
		//return user;
		return null;
	}



	@Override
	public UserReqDto registerUser(UserReqDto newUser) {
		 
		UserEntity userEntity = userEntityManager.newUser(newUser.getEmail());
		userEntity.setEmail(newUser.getEmail());
		userEntity.setGivenNname(newUser.getGivenName());
		userEntity.setFamilyName(newUser.getFamilyName());
		userEntity.setGender(newUser.getGender());
		userEntity.setPotoUrl(newUser.getPotourl());
		userEntity.setAuthProvider(newUser.getAuthProvider());
		
		logger.info("user id:"+userEntity.getUserId());
		
		UserEntity persistUserEntry = userEntityManager.persistEntity(userEntity);
		
		return newUser;
	}



	@Override
	public Boolean isRegisterdUser(UserReqDto user) {
		
		UserEntity userEntity = userEntityManager.getUserByEmail(user.getEmail());
		
		if(userEntity != null )
			return true;
		else
			return false;
	}

}
