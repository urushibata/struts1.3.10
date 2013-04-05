package com.urushibata.struts1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 文字コード設定フィルター
 * @author urushibata
 */
public class SetCharacterEncodingFilter implements Filter {
	private FilterConfig filterConfig;

	public void init(FilterConfig arg0) throws ServletException{
		this.filterConfig = arg0;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
						throws IOException, ServletException{

		System.out.print("SetCaracterEncodingFilter START\n");
		request.setCharacterEncoding(filterConfig.getInitParameter("encoding"));

		System.out.print("SetCaracterEncodingFilter END\n");
		chain.doFilter(request,response);
	}

	public void destroy(){}
}