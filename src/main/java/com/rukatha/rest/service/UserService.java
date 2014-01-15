package com.rukatha.rest.service;

import com.rukatha.rest.dto.UserDto;

public interface UserService {

	UserDto createOrUpdateUser(UserDto newUser);

}
