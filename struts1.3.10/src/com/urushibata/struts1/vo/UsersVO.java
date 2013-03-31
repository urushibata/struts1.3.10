package com.urushibata.struts1.vo;

import org.apache.commons.beanutils.BeanUtils;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersVO extends BeanUtils{
	private String userId;
	private String userName;
	private String address;
	private String mail;
	private String companyName;
	private String employeeNo;
	private String userPassword;

	public UsersVO(ResultSet res) throws SQLException {
		this.userId = res.getString("userid");
		this.userName = res.getString("username");
		this.address = res.getString("address");
		this.mail = res.getString("mail");
		this.companyName = res.getString("companyName");
		this.employeeNo = res.getString("employeeNo");
		this.userPassword = res.getString("userPassword");
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @return companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @return employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @return userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
}