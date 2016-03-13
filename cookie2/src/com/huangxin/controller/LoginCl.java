package com.huangxin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//是否愿意保留
		String value = request.getParameter("iskeepinfo");
		String id = request.getParameter("id");
		//String password = request.getParameter("password");
		if(value!=null&&value.equals("keep")){
			//保存id
			//创建cookie保存到登录用户的机器上
			Cookie cookie=new Cookie("id",id);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
			
			request.getRequestDispatcher("/Ok").forward(request, response);
		}else if(value!=null&&value.equals("nokeep")){
			Cookie[] cookies=request.getCookies();
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("id")){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}else{
			request.getRequestDispatcher("/Ok").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
