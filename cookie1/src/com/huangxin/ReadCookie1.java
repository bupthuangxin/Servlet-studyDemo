package com.huangxin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//读取所有cookie信息再筛选
		Cookie cookies[]=request.getCookies();//Cookie	name=huangxin
		System.out.println(cookies.length);
		//遍历
		for(int i=0;i<cookies.length;i++){
			Cookie cookie=cookies[i];
			//对中文的cookie进行解码
			if(cookie.getName().equals("name")){
				String val=java.net.URLDecoder.decode(cookie.getValue(),"utf-8");
				out.println(cookie.getName()+" "+val);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
