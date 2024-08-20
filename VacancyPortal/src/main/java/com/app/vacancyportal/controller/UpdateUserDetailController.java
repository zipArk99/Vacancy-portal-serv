package com.app.vacancyportal.controller;

import javax.servlet.http.HttpServlet;

import com.app.vacancyportal.factory.UserDetailServiceFactory;
import com.app.vacancyportal.service.UserDetailService;

public class UpdateUserDetailController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	UserDetailService userDetailService;

	public UpdateUserDetailController() {
		userDetailService = UserDetailServiceFactory.createUserDetailServiceInstance();
	}
	
	do
}
