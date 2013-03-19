package com.urushibata.struts1.businessLogic;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.urushibata.struts1.dto.LoginDTO;

/*
 * ユーザ認証クラス
 */
public class UserAuthentication {
	private LoginDTO dto;
	/*
	 * コンストラクタ
	 */
	public UserAuthentication(){}
	public UserAuthentication(LoginDTO argdto){
		dto = argdto;
	}

	/*
	 * ユーザ認証
	 */
	public String authentication() throws SQLException{
		System.out.println("authentication businessLogig");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rest = null;
		String result = "";
		ActionMessages ams = new ActionMessages();
		ActionMessage msg;
		String userId = dto.getUserId();
		String userPassword = dto.getUserPassword();
		String query = "select * from users where userId ='" + userId + "' and userpassword = '" + userPassword + "'";
		System.out.println("execute SQL Query :" + query);

		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();

			stmt = conn.createStatement();
			rest = stmt.executeQuery(query);

		}catch(NamingException ex){
			result = "failure";
		}

		if(rest.next()){
			msg = new ActionMessage("ようこそ！");
			ams.add(ActionMessages.GLOBAL_MESSAGE, msg);
			result = "success";
		}else{
			result = "failure";
		}

		return result;
	}
}