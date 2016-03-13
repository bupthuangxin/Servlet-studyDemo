package com.huangxin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		out.print("<h1>用户登录</h1>");
		out.print("<form action='/mycheckcode/LoginCl' method='post'>");
		out.print("用户id:<input type='text' name='id'/><br/>");
		out.print("密 码:<input type='password' name='password'/><br/>");
		out.print("验证码:<input type='text' name='checkcode'/><img src='/mycheckcode/CreateCode'/><br/>");
		out.print("<input type='submit' value='登录'/><br/>");
		out.print("</from>");
		
		String err=(String) request.getAttribute("err");
		if(err!=null){
			out.println(err);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
