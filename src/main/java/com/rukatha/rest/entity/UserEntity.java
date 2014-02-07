package com.rukatha.rest.entity;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class UserEntity extends BaseEntity{
	  public static final String FIELD_NAME_F_NAME = "fname";
	  public static final String FIELD_NAME_L_NAME = "lname";
	  public static final String FIELD_NAME_EMAIL = "email";

	  public UserEntity(Entity entity) {
	    super(entity);
	  }

	  public UserEntity(String kind, String userId) {
	    super(kind, userId);
	  }

	
	  public UserEntity(Key key) {
		this(new Entity(key));
	}

	public String getUserId() {
	    return entity.getKey().getName();
	  }

	  public String getEmail() {
	    return (String) entity.getProperty(FIELD_NAME_EMAIL);
	  }

	 
	  public void setEmail(String email) {
	    entity.setProperty(FIELD_NAME_EMAIL, email);
	  }

	  
	  public String getFname() {
	    return (String) entity.getProperty(FIELD_NAME_F_NAME);
	  }

	  
	  public void setFname(String firstname) {
	    entity.setProperty(FIELD_NAME_F_NAME, firstname);
	  }
	  
	  public String getLname() {
		    return (String) entity.getProperty(FIELD_NAME_L_NAME);
		  }

		  
		  public void setLname(String lastName) {
		    entity.setProperty(FIELD_NAME_L_NAME, lastName);
		  }
}
