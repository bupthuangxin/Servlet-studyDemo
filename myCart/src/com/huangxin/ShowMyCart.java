package com.huangxin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMyCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HashMap<String,Book> myBooks=(HashMap<String,Book>) request.getSession().getAttribute("myBook");
		Iterator iterator=myBooks.keySet().iterator();
		while(iterator.hasNext()){
			 String key=(String) iterator.next();
			 Book book=myBooks.get(key);
			 out.println(book.getName()+" "+book.getNum()+"<br/>");
		}

		String url=response.encodeURL("/myCart/ShowBook");
		out.println("<a href='"+url+"'>返回</a><br/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
