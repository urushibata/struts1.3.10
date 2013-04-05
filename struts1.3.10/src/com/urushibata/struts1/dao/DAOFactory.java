package com.urushibata.struts1.dao;

/**
 * @author urushibata
 * DAOFactoryクラス
 */
public abstract class DAOFactory {
	
	public final DAOProduct createDAO();
	
	protected abstract DAOProduct selectDAO();
}