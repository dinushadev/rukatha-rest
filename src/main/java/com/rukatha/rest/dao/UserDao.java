package com.rukatha.rest.dao;

import com.rukatha.rest.dto.UserDto;

public interface UserDao {

	UserDto createOrUpdateUser(UserDto newUser);

}
