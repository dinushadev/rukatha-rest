package com.rukatha.rest.auth;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.server.spi.response.UnauthorizedException;


public class GoogleAuthorizer implements Authorizer{

	private  String clientId ;
	
	
	
	  /**
	 * @param cLIENT_ID
	 */
	public GoogleAuthorizer(String cLIENT_ID) {
		super();
		clientId = cLIENT_ID;
	}

	public  boolean verifyToken(String idToken, String email)
	      throws GeneralSecurityException, IOException, UnauthorizedException {
		  try{
		  Checker checker = new Checker(new String[]{clientId}, clientId);
          GoogleIdToken.Payload jwt = checker.check(idToken);
		  if(jwt!=null){
			  if(jwt.getEmail().equals(email.trim())){ 
				  return true;
			  }else{
				  throw new UnauthorizedException("Ex");
			  }
		  }else{
			  throw new UnauthorizedException("Ex");
		  }
		  }catch(Exception e){
			  throw new UnauthorizedException("Ex");
		  }
	  }
	  
	  @Override
	  public boolean authorize(String idToken, String email)
			  throws GeneralSecurityException, UnauthorizedException {
		  try{
		  Checker checker = new Checker(new String[]{clientId}, clientId);
          GoogleIdToken.Payload jwt = checker.check(idToken);
		  if(jwt!=null){
			  if(jwt.getEmail().equals(email.trim())){ 
				  return true;
			  }else{
				  throw new UnauthorizedException("Ex");
			  }
		  }else{
			  throw new UnauthorizedException("Ex");
		  }
		  }catch(Exception e){
			  throw new UnauthorizedException("Ex");
		  }
	  }
	  
}