package com.urushibata.struts1.filter;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.urushibata.struts1.common.ExceptionLiterals;
import com.urushibata.struts1.exception.ApplicationException;

/**
 * エラーメッセージ取得フィルター
 * @author urushibata
 */
public class GetErrorMassagesFilter implements Filter {
	private FilterConfig filterConfig;

	public void init(FilterConfig arg0) throws ServletException{
		this.filterConfig = arg0;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
						throws IOException, ServletException{

		System.out.print("GetErrorMassagesFilter START\n");
		String errPath = filterConfig.getInitParameter("errMsg");
//		errPath = filterConfig.getServletContext().getRealPath(errPath);
		try{
			XMLDecoder xmldec = new XMLDecoder(new BufferedInputStream(new FileInputStream(errPath)));
			Object msgs = xmldec.readObject();
			xmldec.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		}

		System.out.print("GetErrorMassagesFilter END\n");
		chain.doFilter(request,response);
	}

	public void destroy(){}
}