package com.huangxin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取session 当没有就自动创建
		HttpSession session=request.getSession();
		//给该session放入属性
		session.setAttribute("uname", "黄鑫"); 
		session.setAttribute("age", 100); 
		//生命周期 默认30分钟 在tomcat-conf-web.xml中
		//session.setMaxInactiveInterval(30);30s
		out.println("session创建成功");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
