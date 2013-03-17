package com.urushibata.struts1.businessLogic;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * ユーザ認証クラス
 */
public class UserAuthentication {
	/*
	 * コンストラクタ
	 */
	public UserAuthentication(){}

	/*
	 * ユーザ認証
	 */
	public String authentication() throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		String result = "";
		String query = "select * from users where userId ='' and userpassword = '';";

		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();

			stmt = conn.createStatement();
			ResultSet rest = stmt.executeQuery(query);

		}catch(NamingException ex){
			result = "faild";
		}
		//result = "success";
		result = "failure";

		return result;
	}
}