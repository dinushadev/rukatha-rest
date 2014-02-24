package com.rukatha.rest.auth;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;


public class GoogleAuthorizer implements Authorizer{

	private  String clientId ="293977541097-8ug38b334t08qcssdk4jlvh0qol9q9c2.apps.googleusercontent.com";
	
	public GoogleAuthorizer() {
		// TODO Auto-generated constructor stub
	}
	
	  /**
	 * @param cLIENT_ID
	 */
	public GoogleAuthorizer(String cLIENT_ID) {
		super();
		clientId = cLIENT_ID;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
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