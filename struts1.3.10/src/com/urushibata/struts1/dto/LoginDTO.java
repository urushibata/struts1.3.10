package com.urushibata.struts1.dto;

import java.io.Serializable;

import com.urushibata.struts1.vo.UsersVO;

public class LoginDTO implements Serializable{
	private static final long serialVersionUID = -8829945103350600249L;
	/**
	 * メンバ
	 */
	private String userId;
	private String userPassword;
	private UsersVO vo;

	/*
	 * コンストラクタ
	 */
	public LoginDTO(){}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return this.userId;
	}

	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	public String getUserPassword(){
		return this.userPassword;
	}

	public void setVO(UsersVO vo){
		this.vo = vo;
	}

	public UsersVO getVO(){
		return this.vo;
	}
}