package com.rukatha.rest.dto;

public class UserDto {

	
	private String email;
	
	private String givenName;
	
	private String familyName;

	private String gender;
	
	private String potourl;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPotourl() {
		return potourl;
	}

	public void setPotourl(String potourl) {
		this.potourl = potourl;
	}



}
