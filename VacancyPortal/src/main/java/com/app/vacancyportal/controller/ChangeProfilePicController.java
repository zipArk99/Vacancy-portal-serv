package com.app.vacancyportal.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.factory.UserDetailServiceFactory;
import com.app.vacancyportal.service.UserDetailService;

public class ChangeProfilePicController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDetailService userDetailService;

	public ChangeProfilePicController() {
		userDetailService = UserDetailServiceFactory.createUserDetailServiceInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int profileId = Integer.parseInt(req.getParameter("imageId"));
		String profilePath = req.getParameter("profilePath");
		HttpSession session = req.getSession();
		UserDetail userDetail = (UserDetail) session.getAttribute("userDetail");
		if (!Objects.isNull(userDetail)) {
			userDetail.getProfilePicture().setPictureId(profileId);
			userDetail.getProfilePicture().setProfilePath(profilePath);
			boolean b = userDetailService.changeUserProfile(userDetail, profileId);
			if (b) {
				session.setAttribute("userDetail", userDetail);
				resp.sendRedirect(req.getContextPath()+"portal/updateprofile/get");
			}
		}else {
			
			session.invalidate();
			//redirect to login page
		}
	}

}
