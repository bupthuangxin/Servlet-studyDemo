package com.hx;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		//PrintWriter out = response.getWriter();
		//out.println("hello world");
		
		OutputStream os=response.getOutputStream();
		os.write("hello world".getBytes());
		
		testcache(response);
	}

	private void testcache(HttpServletResponse response) throws IOException {
		response.setDateHeader("Expires", -1);
		//缓存一个小时
		//response.setDateHeader("Expires", System.currentTimeMillis()+3600*1000*24); 
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		//定时刷新
		//response.setHeader("Refresh", "5;url=/servletProject2/ResponseTest");
		//状态码
		//response.setStatus(302);
		//response.setHeader("Location", "/servletPro/Servlet2");
		//response.sendRedirect("/servletPro/Servlet2");
		PrintWriter out = response.getWriter();
		out.println("hello world "+new java.util.Date().toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
