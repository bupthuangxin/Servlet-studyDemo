package com.huangxin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String u=request.getParameter("username");
		String p=request.getParameter("pwd");
		String sex=request.getParameter("sex");
		String city=request.getParameter("city");
		String intro=request.getParameter("intro");
		String hidden1=request.getParameter("hidden1");
		//如果接收复选框
		String[] hobbies=request.getParameterValues("hobby");
		
		out.println(u+"<br/>");
		out.println(p+"<br/>");
		out.println(sex+"<br/>");
		if(hobbies!=null){
			for(int i=0;i<hobbies.length;i++){
				out.println(hobbies[i]);
			}
		}else{
			out.println("你没有选任何爱好");
		}
		out.println("<br/>"+city);
		out.println("<br/>"+intro);
		out.println("<br/>"+hidden1);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
