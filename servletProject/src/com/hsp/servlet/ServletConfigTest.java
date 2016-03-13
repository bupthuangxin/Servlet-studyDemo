package com.hsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String encoding=this.getServletConfig().getInitParameter("encoding");
		response.setCharacterEncoding(encoding);
		PrintWriter out = response.getWriter();
		out.print("编号是"+encoding);
		
		Enumeration<String> names=this.getServletConfig().getInitParameterNames();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			out.println(name);
			out.println(this.getServletConfig().getInitParameter(name));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
