package com.huangxin.util;

import java.util.ArrayList;

import com.huangxin.entity.User;

public class SessionUtil {
	
	//根据sessionId在arraylist里找到对应user对象
	public static Object getUserBySessionId(ArrayList<User> userList,String sessionIdString){
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			if(user.getSessionIdString().equals(sessionIdString)){
				return user;
			}
		}
		return null;
	}
}
