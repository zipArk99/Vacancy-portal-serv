package com.app.vacancyportal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.factory.UserDetailServiceFactory;
import com.app.vacancyportal.service.UserDetailService;

public class UserProfileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDetailService userDetailService;

	public UserProfileController() {
		userDetailService = UserDetailServiceFactory.createUserDetailServiceInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		UserDetail userDetail = (UserDetail) session.getAttribute("userDetail");
		if (userDetail == null) {
			System.out.println("called from fetch user");
			User user = (User) session.getAttribute("user");
			userDetail = userDetailService.fetchUserByEmailId(user.getEmail());
			session.setAttribute("userDetail", userDetail);
		}
		System.out.println("CALLED USER PROFILE");
		req.setAttribute("email", userDetail.getUser().getEmail());
		req.setAttribute("fname", userDetail.getFirstName());
		req.setAttribute("lname", userDetail.getLastName());
		req.setAttribute("role", userDetail.getUser().getRoleId());
		req.setAttribute("profileId", userDetail.getProfilePicture().getPictureId());
		req.setAttribute("profile", userDetail.getProfilePicture().getProfilePath());
		req.getRequestDispatcher("/profile_page.jsp").forward(req, resp);

	}

}
