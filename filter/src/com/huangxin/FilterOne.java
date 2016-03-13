package com.huangxin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FilterOne implements Filter {

    public FilterOne() {
    	System.out.println("========FilterOne构造函数==========");
    }
	
    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("========FilterOne初始化方法==========");
    	String initParam=fConfig.getInitParameter("param");
    	System.out.println(initParam);
	}
	


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("========FilterOne开始执行doFilter方法==========");
		chain.doFilter(request, response);
		System.out.println("========FilterOne结束执行doFilter方法==========");
	}

    public void destroy() {
		// TODO Auto-generated method stub
    	System.out.println("========销毁方法==========");
	}

}
