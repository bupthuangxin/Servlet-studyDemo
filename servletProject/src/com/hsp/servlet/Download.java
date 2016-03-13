package com.hsp.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String temp=java.net.URLEncoder.encode("科比.jpg","utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+temp);
		String path=this.getServletContext().getRealPath("/images/科比.jpg");
		
		FileInputStream fis=new FileInputStream(path);
		byte buff[]=new byte[1024];
		int len=0;
		OutputStream os=response.getOutputStream();
		while((len=fis.read(buff))>0){
			os.write(buff, 0, len);
		}
		os.close();
		fis.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
