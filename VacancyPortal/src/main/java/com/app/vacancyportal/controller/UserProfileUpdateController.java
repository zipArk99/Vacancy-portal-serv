package com.app.vacancyportal.controller;

import java.io.IOException;
import java.util.Objects;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.vacancyportal.entity.ProfilePicture;
import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.factory.UserDetailServiceFactory;
import com.app.vacancyportal.service.UserDetailService;

public class UserProfileUpdateController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDetailService userDetailService;

	public UserProfileUpdateController() {
		userDetailService = UserDetailServiceFactory.createUserDetailServiceInstance();
	}

	private UserDetail setUserDetailsWithRequestParam(HttpServletRequest req) {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName(req.getParameter("fname"));
		userDetail.setLastName(req.getParameter("lname"));
		User user = new User();
		user.setEmail(req.getParameter("email"));
		ProfilePicture pP = new ProfilePicture();
		pP.setProfilePath(req.getParameter("profile"));
		pP.setPictureId(Integer.parseInt(req.getParameter("profId")));

		userDetail.setUser(user);
		userDetail.setProfilePicture(pP);
		return userDetail;

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("print email::"+req.getAttribute("email"));
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		System.out.println("path :: " + pathInfo);
		
		if (!Objects.isNull(pathInfo) && pathInfo.equals("/get")) {
			
			req.getRequestDispatcher("/updateuserdetail_page.jsp").forward(req, resp);
		} else {

			UserDetail userDetail = setUserDetailsWithRequestParam(req);
			UserDetail updatedUserDetail = userDetailService.updateUserDetail(userDetail);

			if (!Objects.isNull(updatedUserDetail)) {
				HttpSession session = req.getSession(false);
				session.setAttribute("userDetail", updatedUserDetail);
				resp.sendRedirect(req.getContextPath() + "/portal/userprofile");
			} else {

			}

		}
	}

}
