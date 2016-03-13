package com.huangxin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		String passwd=request.getParameter("password");
		String checkcode=request.getParameter("checkcode");
		String checkcode2=(String) request.getSession().getAttribute("checkcode");
		if(checkcode.equals(checkcode2)){
			//验证码正确，去数据库验证
		}else{
			request.setAttribute("err", "验证码有误");
			request.getRequestDispatcher("/Login").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
