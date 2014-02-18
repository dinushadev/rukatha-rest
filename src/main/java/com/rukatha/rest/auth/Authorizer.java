
package com.rukatha.rest.auth;

import java.security.GeneralSecurityException;

import com.google.api.server.spi.response.UnauthorizedException;

/**
 * @author dinusha
 *
 */
public interface Authorizer {

	public boolean authorize(String idToken, String email)
			  throws GeneralSecurityException, UnauthorizedException;
}