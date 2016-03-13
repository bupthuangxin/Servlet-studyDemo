package com.hsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String referer=request.getHeader("Referer");
		out.println("referer="+referer);
		if(referer==null||!referer.startsWith("http://localhost:8080/servletProject")){
			response.sendRedirect("/servletProject/Error");
			return;
		}
		String host=request.getHeader("Host");
		out.println("host="+host);
		out.println("这是非常重要的信息");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
