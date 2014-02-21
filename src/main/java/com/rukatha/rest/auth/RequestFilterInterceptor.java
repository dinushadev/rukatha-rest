package com.rukatha.rest.auth;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Dinusha Nandika
 *
 */
public class RequestFilterInterceptor implements HandlerInterceptor {

	
	private static final Logger log = LoggerFactory.getLogger(RequestFilterInterceptor.class);

	private String googleClientID;
	
	private Authorizer authorizer;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		 	log.info("*******************************************************");
	        log.info("** Remote Address : " + request.getRemoteAddr());
	        log.info("** Context Path    : " + request.getContextPath());
	        log.info("** Request URI    : " + request.getRequestURI());
	        log.info("** Query Pram   : " + request.getParameter("ref"));
	        log.info("*******************************************************");

			String authzToken = null;
			String idToken = null;
			boolean isTokenValid = false;
			String authProvier =null;
			String email =null;
			
		
			
			
				try {
					authzToken = request.getHeader("Authorization");
					if(authzToken== null){
						throw new UnauthorizedException("ex");
					}
					String [] tokenArr = authzToken.split(" ");
					if(tokenArr.length<2){
						throw new ForbiddenException();
					}
					String tokenData = tokenArr[1];
					String[] tokenDataArr= null;
					if(tokenData!= null){
						tokenDataArr = tokenData.split(":");
						if(tokenDataArr.length<3){
							throw new ForbiddenException();
						}
						authProvier =tokenDataArr[0];
						idToken  = tokenDataArr[1];
						email = tokenDataArr[2];
						
						if(idToken!=null && authProvier!=null && authProvier.equals("GOOGLE")){
							authorizer = new GoogleAuthorizer(googleClientID);
							
							isTokenValid  = authorizer.authorize(idToken,email);
						}else{
							throw new UnauthorizedException("Valid token required");
						}
						
					}else{
						 throw new UnauthorizedException("Valid token required");
					}
					
			
					
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//throw new UnauthorizedException("Ex");
					 throw new UnauthorizedException("Valid token required");
				}
			
			
			return true;
	}

	public void setGoogleClientID(String googleClientID) {
		this.googleClientID = googleClientID;
	}

}