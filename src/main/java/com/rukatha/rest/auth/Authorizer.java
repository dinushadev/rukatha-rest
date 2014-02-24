package com.rukatha.rest.auth;

import java.security.GeneralSecurityException;



/**
 * @author dinusha
 *
 */
public interface Authorizer {

	
	public boolean authorize(String idToken, String email)
			  throws GeneralSecurityException, UnauthorizedException;
}
