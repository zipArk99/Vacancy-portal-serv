package com.app.vacancyportal.factory;

import com.app.vacancyportal.dao.UserDao;
import com.app.vacancyportal.dao.impl.UserDaoImpl;

public class UserDaoFactory {
	 private static UserDao userDao; 
	
	private UserDaoFactory() {
		
	}
	
	public static UserDao createUserDao() {
		
		if(userDao==null) {
			
			synchronized (UserDaoImpl.class) {
				
				userDao = new UserDaoImpl();
				
			}
			
		}
		return userDao;
		
		
		
	}

}
