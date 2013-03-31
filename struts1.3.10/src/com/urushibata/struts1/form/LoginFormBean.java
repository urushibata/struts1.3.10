package com.urushibata.struts1.form;

import org.apache.struts.validator.ValidatorForm;

public class LoginFormBean extends ValidatorForm {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userPassword;

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	public String getUserPassword(){
		return userPassword;
	}
}