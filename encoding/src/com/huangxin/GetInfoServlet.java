package com.huangxin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//乱码
		//request.setCharacterEncoding("utf-8");
		//String u=new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		String u=request.getParameter("username");
		System.out.println(u);
		//把接收的数据传给下一个页面
		String uu=new String(u.getBytes("utf-8"),"iso-8859-1");
		response.sendRedirect("/encoding/Wel?yy="+uu);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
