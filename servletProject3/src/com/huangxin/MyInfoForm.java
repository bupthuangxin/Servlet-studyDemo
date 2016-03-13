package com.huangxin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInfoForm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<form action='/servletProject3/RegisterCl' method='post'>");
		out.println("用户名:<input type='text' name='username'/><br/>");
		out.println("密 码: <input type='password' name='pwd'/><br/>");
		out.println("性 别: <input type='radio' name='sex' value='男'/>男 <input type='radio' name='sex' value='女'/>女<br/>");
		out.println("你的爱好:<input type='checkbox' name='hobby' value='音乐'>音乐<input type='checkbox' name='hobby' value='体育'>体育<input type='checkbox' name='hobby' value='旅游'>旅游<br/>");
		out.println("所在城市:<select name='city'><option value='bj'>北京</option><option value='sh'>上海</option></select><br/>");
		out.println("你的介绍:<textarea cols='20' rows='10' name='intro'>请输入...</textarea><br/>");
		out.println("提交照片:<input type='file' name='photo'>");
		//数据不希望用户看到 不希望影响界面同时要使用该数据
		out.println("<input type='hidden' value='abc' name='hidden1'/>");
		out.println("<br/><input type='submit' value='提交信息'/>");
		out.println("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
