package com.rukatha.rest.entity;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class UserEntity extends BaseEntity {
	public static final String FIELD_NAME_GIVEN_NAME = "given_name";
	public static final String FIELD_NAME_FAMILY_NAME = "family_name";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_GENDER = "gender";
	public static final String FIELD_POTO_URL = "poto";

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
		return (String) entity.getProperty(FIELD_EMAIL);
	}

	public void setEmail(String email) {
		entity.setProperty(FIELD_EMAIL, email);
	}

	public String getGivenName() {
		return (String) entity.getProperty(FIELD_NAME_GIVEN_NAME);
	}

	public void setGivenNname(String firstname) {
		entity.setProperty(FIELD_NAME_GIVEN_NAME, firstname);
	}

	public String getFamilyName() {
		return (String) entity.getProperty(FIELD_NAME_FAMILY_NAME);
	}

	public void setFamilyName(String lastName) {
		entity.setProperty(FIELD_NAME_FAMILY_NAME, lastName);
	}

	public String getGender() {
		return (String) entity.getProperty(FIELD_GENDER);
	}

	public void setGender(String gendr) {
		entity.setProperty(FIELD_GENDER, gendr);
	}

	public String getPotoUrl() {
		return (String) entity.getProperty(FIELD_POTO_URL);
	}

	public void setPotoUrl(String potourl) {
		entity.setProperty(FIELD_POTO_URL, potourl);
	}
}
