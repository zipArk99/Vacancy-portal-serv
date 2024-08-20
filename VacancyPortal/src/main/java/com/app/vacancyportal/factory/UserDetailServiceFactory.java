package com.app.vacancyportal.factory;

import com.app.vacancyportal.dao.impl.UserDetailDaoImpl;
import com.app.vacancyportal.service.UserDetailService;
import com.app.vacancyportal.service.impl.UserDetailServiceImpl;

public class UserDetailServiceFactory {
	private static UserDetailService userDetailService;

	private UserDetailServiceFactory() {
		// TODO Auto-generated constructor stub
	}

	public static UserDetailService createUserDetailServiceInstance() {
		if (userDetailService == null) {
			synchronized (UserDetailService.class) {
				userDetailService = new UserDetailServiceImpl(new UserDetailDaoImpl());
			}
		}
		return userDetailService;

	}

}
