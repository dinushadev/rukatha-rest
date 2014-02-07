package com.rukatha.rest.controller;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SimpleCORSFilter extends HandlerInterceptorAdapter {

	//before the actual handler will be executed
		public boolean preHandle(HttpServletRequest request, 
				HttpServletResponse response, Object handler)
		    throws Exception {
			
			response.addHeader("Access-Control-Allow-Origin", "*");
		    response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		    response.addHeader("Access-Control-Allow-Credentials", "true");
		    response.addHeader("Access-Control-Allow-Headers", "Authorization");	
		return true;
	}


}