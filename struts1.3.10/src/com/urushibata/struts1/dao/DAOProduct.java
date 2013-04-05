package com.urushibata.struts1.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.urushibata.struts1.common.AppConsts;

public abstract class DAOProduct{
	private DataSource datasource;
	try{
		InitialContext initialContext = new InitialContext();
		this.datasource = (DataSource) initialContext.lookup(AppConsts.DATASOURCE_DB_NAME);
		Connection conn = this.datasource.getConnection();
	}catch(NamingException e) {

	}
}
