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
		response.setContentType("text/html;charset=utf-8");
		//得到URL
		String URL=request.getRequestURL().toString();
		System.out.println(URL);
		//得到URI
		String URI=request.getRequestURI();
		System.out.println(URI);
		//queryString
		String queryString=request.getQueryString();
		System.out.println(queryString);
		//remoteAddr和localAddr
		String remoteAddr=request.getRemoteAddr();
		String localAddr=request.getLocalAddr();
		System.out.println(remoteAddr+" "+localAddr);
		//remoteHost和localName
		String remoteHost=request.getRemoteHost();
		String localName=request.getLocalName();
		System.out.println(remoteHost+" "+localName);
		//remotePort和localPort
		int remotePort=request.getRemotePort();
		int localPort=request.getLocalPort();
		System.out.println(remotePort+" "+localPort);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
