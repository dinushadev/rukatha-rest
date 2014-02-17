package com.rukatha.rest.service;

import com.rukatha.rest.dto.UserReqDto;

public interface UserService {

	UserReqDto createOrUpdateUser(UserReqDto newUser);

	UserReqDto registerUser(UserReqDto newUser);

	Boolean isRegisterdUser(UserReqDto user);

}
