package com.huangxin.listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.huangxin.entity.User;
import com.huangxin.util.SessionUtil;


public class MyServletRequestListener implements ServletRequestListener {
	
	private ArrayList<User> userList;
	
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    	userList=(ArrayList<User>) arg0.getServletContext().getAttribute("userList");
    	
    	if(userList==null){
    		userList=new ArrayList<User>();
    	}
    	
    	HttpServletRequest request = (HttpServletRequest)arg0.getServletRequest();
    	String sessionidString = request.getSession().getId();
    	
    	
    	//一个用户对应一个sessionID，通过此ID获取用户信息，放入arraylist中，此arraylist让所有servlet共享
    	if(SessionUtil.getUserBySessionId(userList,sessionidString)==null){
    		User user = new User();
    		user.setSessionIdString(sessionidString);
    		user.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    		user.setIpString(request.getRemoteAddr());
    		userList.add(user);
    	}
    	arg0.getServletContext().setAttribute("userList", userList);
    }
	
}
