package com.rukatha.rest.auth;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid token")
	@ResponseBody
	public String handleDataFormatException(UnauthorizedException ex,
	    HttpServletResponse response) {

	  logger.info("Handlng UnauthorizedException - Catching: "
	      + ex.getClass().getSimpleName());
	  return ex.getMessage();
	}

}
