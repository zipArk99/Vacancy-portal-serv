package com.app.vacancyportal.controller;

import java.io.IOException;
import java.util.Objects;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		userDetail.setUser(user);
		return userDetail;

	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDetail userDetail = setUserDetailsWithRequestParam(req);
		UserDetail updatedUserDetail = userDetailService.updateUserDetail(userDetail);
		
		if(!Objects.isNull(updatedUserDetail)) {
		HttpSession session = req.getSession(false);
		session.setAttribute("userDetail", updatedUserDetail);
		resp.sendRedirect(req.getContextPath()+"/portal/userprofile");
		}else {
				
		}
		
	
	}

}
