package com.rukatha.rest.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Dinusha Nandika
 *
 */
public class AuthFilterInterceptor implements HandlerInterceptor {

	
	private static final Logger log = LoggerFactory.getLogger(AuthFilterInterceptor.class);

	
	
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
	        log.info("*******************************************************");

			String authzToken = null;
			String idToken = null;
			boolean isTokenValid = false;
			String authProvier =null;
			String email =null;
			
			//Temp only for ui navigation / not for restful web service
			String sessionVal =(String) request.getSession().getAttribute("USER_SESSION");
			
			if(request.getRequestURI().startsWith("/ui") && sessionVal!=null && sessionVal.equals("ON")){
				return true;
			}
			
			
					authzToken = request.getHeader("Authorization");
					if(authzToken== null){
						throw new UnauthorizedException("Invalid Auth tag");
					}
					String [] tokenArr = authzToken.split(" ");
					if(tokenArr.length<2){
						throw new UnauthorizedException("Invalid Auth tag");
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
							authorizer = AuthorizerFactory.createAutorizer(authProvier);
							
							isTokenValid  = authorizer.authorize(idToken,email);
							
							//Temp only for ui navigation / not for restful web service
							if(isTokenValid){
								request.getSession().setAttribute("USER_SESSION", "ON");
							}else{
								request.getSession().setAttribute("USER_SESSION", "OFF");
							}
							
							
						}else{
							throw new UnauthorizedException("Valid token required");
						}
						
					}else{
						 throw new UnauthorizedException("Valid token required");
					}
					
			
					
				
			
			
			return true;
	}



}