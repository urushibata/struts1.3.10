package com.urushibata.struts1.service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.urushibata.struts1.common.AppConsts;
import com.urushibata.struts1.dto.LoginDTO;
import com.urushibata.struts1.exception.ApplicationException;
import com.urushibata.struts1.vo.UsersVO;

/*
 * ユーザ認証クラス
 */
public class UserAuthentication {
	private LoginDTO dto;

	/*
	 * コンストラクタ
	 */
	public UserAuthentication() {
	}

	public UserAuthentication(LoginDTO argdto) {
		dto = argdto;
	}

	/*
	 * ユーザ認証
	 */
	public void authentication() throws SQLException{
		final Logger logger = Logger.getLogger("myLogger");
		final InputStream inStream;

		try {
			inStream = getClass().getClassLoader().getResourceAsStream(AppConsts.LOGGING_PROPERTIES);
			LogManager.getLogManager().readConfiguration(inStream);
			inStream.close();
		}catch(IOException e){
			logger.warning("ログ設定ファイルがありません。" + AppConsts.LOGGING_PROPERTIES);
		}
		logger.info("authentication businessLogic START");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rest = null;
		UsersVO vo;

		String userId = dto.getUserId();
		String userPassword = dto.getUserPassword();
		String query = "select * from users where userId ='" + userId
				+ "' and userpassword = '" + userPassword + "'";
		System.out.println("execute SQL Query :" + query);

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();

			stmt = conn.createStatement();
			rest = stmt.executeQuery(query);

		} catch (NamingException e) {

		}

		if (rest.next()) {
			vo = new UsersVO(rest);
			dto.setVO(vo);
		} else {
			conn.close();
			logger.warning("E00010:IDかパスワードが違います。");
			throw new ApplicationException("errors.E00010", "ID", "パスワード");
		}

		conn.close();

		logger.info("authentication businessLogic END");
	}
}