package com.huangxin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取cookie
		//"lasttime" "2011-11-11 11:11:11"
		Cookie[] cookies=request.getCookies();
		boolean b=false;//假设没有此cookie
		if(cookies!=null){
			for(Cookie cookie:cookies){
				String name=cookie.getName();
				if("lasttime".equals(name)){
					out.println("您上次登录的时间:"+cookie.getValue());
					//更新
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowTime = simpleDateFormat.format(new java.util.Date());
					//Cookie mycookie=new Cookie("lasttime",nowTime);
					cookie.setValue(nowTime);
					cookie.setMaxAge(3600);
					response.addCookie(cookie);
					
					b=true;
					break;
				}
			}
		}
		
		if(b==false){
			out.println("first");
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String nowTime = simpleDateFormat.format(new java.util.Date());
			Cookie cookie=new Cookie("lasttime",nowTime);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
