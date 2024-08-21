package com.app.vacancyportal.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.factory.UserDetailServiceFactory;
import com.app.vacancyportal.service.UserDetailService;

public class UserManagementController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserDetailService userDetailService;

	private UserDetail setUserDetailsWithRequestParam(HttpServletRequest req) {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName(req.getParameter("fname"));
		userDetail.setLastName(req.getParameter("lname"));
		User user = new User();
		user.setEmail(req.getParameter("email"));

		userDetail.setUser(user);
		return userDetail;

	}

	public UserManagementController() {
		userDetailService = UserDetailServiceFactory.createUserDetailServiceInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserDetail> usersDetail = userDetailService.fetchAllUsers();
		HttpSession session = req.getSession();
		req.setAttribute("usersDetail", usersDetail);
		req.getRequestDispatcher("/usermanagement_page.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDetail userDetail = setUserDetailsWithRequestParam(req);
		UserDetail updatedUserDetail = userDetailService.updateUserDetail(userDetail);
		if(updatedUserDetail!=null) {
			doGet(req, resp);	
		}

	}
}
