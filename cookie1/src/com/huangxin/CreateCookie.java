package com.huangxin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCookie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String name=java.net.URLEncoder.encode("黄鑫","utf-8");
		
		//创建cookie
		Cookie cookie=new Cookie("name",name);
		//设置cookie的生命周期
		cookie.setMaxAge(3600);
		//把cookie信息回写给浏览器
		response.addCookie(cookie);//Set-Cookie	name=huangxin; Expires=Thu, 17-Dec-2015 15:04:00 GMT
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
