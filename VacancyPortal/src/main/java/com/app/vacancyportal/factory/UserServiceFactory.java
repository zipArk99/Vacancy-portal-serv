package com.app.vacancyportal.factory;

import com.app.vacancyportal.service.UserService;
import com.app.vacancyportal.service.impl.UserServiceImpl;

public class UserServiceFactory {
	
	private static UserService userService;
	
	private UserServiceFactory() {
		
	}
	
	public static UserService createUserService() {
		if(userService==null) {
			synchronized (UserService.class) {
				userService = new UserServiceImpl(UserDaoFactory.createUserDao());
			}
		}
		return userService;
		
	}

}
