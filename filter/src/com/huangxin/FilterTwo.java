package com.huangxin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTwo implements Filter {

    public FilterTwo() {
        // TODO Auto-generated constructor stub
    	System.out.println("========FilterTwo构造函数==========");
    }
	
    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("========FilterTwo初始化方法==========");

	}
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("========FilterTwo开始执行doFilter方法==========");
		chain.doFilter(request, response);
		System.out.println("========FilterTwo结束执行doFilter方法==========");
	}
	public void destroy() {
		// TODO Auto-generated method stub
	 	System.out.println("========销毁方法==========");
	}

}
