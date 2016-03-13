package com.huangxin.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//从cookie中选出keep
		String id="";
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("id")){
					id=cookie.getValue();
				}
			}
		}
		
		out.print("<h1>用户登录</h1>");
		out.print("<form action='/cookie2/LoginCl' method='post'>");
		out.print("用户id:<input type='text' name='id' value='"+id+"'/><br/>");
		out.print("密 码:<input type='password' name='password'/><br/>");
		out.print("<input type='checkbox' value='keep' name='iskeepinfo'/>在此电脑上记住用户名<br/>");
		out.print("<input type='checkbox' value='nokeep' name='iskeepinfo'/>不在电脑上记住用户名<br/>");
		out.print("<input type='submit' value='登录'/><br/>");
		out.print("</from>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
