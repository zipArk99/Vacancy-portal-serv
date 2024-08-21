package com.app.vacancyportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.factory.UserDetailServiceFactory;
import com.app.vacancyportal.service.UserDetailService;

public class UserManagementController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserDetailService userDetailService;
	
	
	public UserManagementController() {
		userDetailService = UserDetailServiceFactory.createUserDetailServiceInstance();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<UserDetail> usersDetail= userDetailService.fetchAllUsers();
	req.setAttribute("usersDetail", usersDetail);
	req.getRequestDispatcher("/usermanagement_page.jsp").forward(req, resp);
	}
}
