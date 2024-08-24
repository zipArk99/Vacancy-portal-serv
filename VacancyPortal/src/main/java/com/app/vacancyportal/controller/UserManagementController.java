package com.app.vacancyportal.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.vacancyportal.dto.ProfilePicResponse;
import com.app.vacancyportal.entity.ProfilePicture;
import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.factory.ProfilePictureServiceFactory;
import com.app.vacancyportal.factory.UserDetailServiceFactory;
import com.app.vacancyportal.service.ProfilePictureService;
import com.app.vacancyportal.service.UserDetailService;

public class UserManagementController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserDetailService userDetailService;
	private final ProfilePictureService profilePictureService;

	public UserManagementController() {
		userDetailService = UserDetailServiceFactory.createUserDetailServiceInstance();
		profilePictureService = ProfilePictureServiceFactory.createProfilePictureServiceInstance();
	}

	private UserDetail setUserDetailsWithRequestParam(HttpServletRequest req) {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName(req.getParameter("fname"));
		userDetail.setLastName(req.getParameter("lname"));

		ProfilePicture profilePicture = new ProfilePicture();
		profilePicture.setPictureId(Integer.parseInt(req.getParameter("profileId")));
		profilePicture.setProfilePath(req.getParameter("profilePath"));

		User user = new User();
		user.setEmail(req.getParameter("email"));

		userDetail.setUser(user);
		userDetail.setProfilePicture(profilePicture);
		return userDetail;

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
		String pathInfo = req.getPathInfo();
		UserDetail userDetail = setUserDetailsWithRequestParam(req);

		if (!Objects.isNull(pathInfo) && pathInfo.equals("/edit")) {
			HttpSession session = req.getSession(false);
			session.setAttribute("userManagment", userDetail);
			System.out.println("called edit page");
			req.getRequestDispatcher("/usermanagement_edit_page.jsp").forward(req, resp);
		} else {

			UserDetail updatedUserDetail = userDetailService.updateUserDetail(userDetail);
			if (updatedUserDetail != null) {
				doGet(req, resp);
			}
		}
	}
}
