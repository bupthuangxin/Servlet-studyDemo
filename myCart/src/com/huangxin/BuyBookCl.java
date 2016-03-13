package com.huangxin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyBookCl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		String bookName=request.getParameter("name");
		String id=request.getParameter("id");
		
		HttpSession session=request.getSession();
		
		HashMap<String,Book> hm=(HashMap<String,Book>) session.getAttribute("myBook");
		if(hm==null){
			Book book=new Book();
			book.setId(id);
			book.setName(bookName);
			book.setNum(1);
			
			hm=new HashMap<String,Book>();
			hm.put(id, book);
			session.setAttribute("myBook", hm);
		}else{
			if(hm.containsKey(id)){
				Book book=hm.get(id);
				int booknum=book.getNum();
				book.setNum(booknum+1);
			}else{
				Book book=new Book();
				book.setId(id);
				book.setName(bookName);
				book.setNum(1);
				hm.put(id, book);
			}
			session.setAttribute("myBook", hm);
		}

		
		request.getRequestDispatcher("/ShowMyCart").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
