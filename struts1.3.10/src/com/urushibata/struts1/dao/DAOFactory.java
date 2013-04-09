package com.urushibata.struts1.dao;

/**
 * @author urushibata
 * DAOFactoryクラス
 */
public abstract class DAOFactory {
	
	public static DAOProduct createDAO(String daoName, String sqlId){
		DAOProduct dao = null;
		try {
			dao = (DAOProduct)Class.forName(daoName).newInstance();
			dao.setId(sqlId);
		}catch(InstantiationException | IllegalAccessException e1){
			e1.printStackTrace();
		}catch(ClassNotFoundException e2){
			System.out.println("指定したDAOクラスが見つかりません。");
		}

		return dao;
	}
}