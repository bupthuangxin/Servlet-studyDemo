package com.huangxin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>欢迎购买</h1>");
		
		//访问一下session
		request.getSession();
		//url重写
		String url1=response.encodeURL("/myCart/BuyBookCl?id=1&name=java");
		String url2=response.encodeURL("/myCart/BuyBookCl?id=2&name=oracle");
		String url3=response.encodeURL("/myCart/BuyBookCl?id=3&name=cpp");
		
		out.println("<a href='"+url1+"'>java</a><br/>");
		out.println("<a href='"+url2+"'>oracle</a><br/>");
		out.println("<a href='"+url3+"'>cpp</a><br/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
