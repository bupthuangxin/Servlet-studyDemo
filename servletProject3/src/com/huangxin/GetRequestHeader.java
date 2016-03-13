package com.huangxin;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetRequestHeader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		//getHeader
		String Host=request.getHeader("Host");
		System.out.println(Host);
		//getHeaderNames
		Enumeration<String> headers=request.getHeaderNames();
		while(headers.hasMoreElements()){
			String headername=headers.nextElement();
			System.out.println(headername+" "+request.getHeader(headername));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
