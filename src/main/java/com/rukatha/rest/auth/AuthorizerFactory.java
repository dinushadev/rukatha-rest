package com.rukatha.rest.auth;


public class AuthorizerFactory {

	public static Authorizer createAutorizer(String authorizerName) {
		Authorizer authorizer = null;
		switch (authorizerName) {
		case "GOOGLE":
			authorizer = new GoogleAuthorizer();
			break;
		default:
			return null;
		}

		return authorizer;
	}

}
