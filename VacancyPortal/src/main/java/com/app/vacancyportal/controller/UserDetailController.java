package com.app.vacancyportal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.app.vacancyportal.entity.ProfilePicture;
import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.factory.UserDetailServiceFactory;
import com.app.vacancyportal.service.UserDetailService;
import com.app.vacancyportal.util.FileUploaderUtil;
import com.app.vacancyportal.util.formvalidation.BasicFormValidation;

@MultipartConfig
public class UserDetailController extends HttpServlet {

	/**
	 * 
	 */
	UserDetailService userDetailService;
	BasicFormValidation<UserDetail> basicFormValidation;

	private static final long serialVersionUID = 1L;

	public UserDetailController() {
		userDetailService = UserDetailServiceFactory.createUserDetailServiceInstance();
		basicFormValidation = new BasicFormValidation<UserDetail>();
	}

	private UserDetail setUserDetailsWithRequestParam(HttpServletRequest req) {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName(req.getParameter("fname"));
		userDetail.setLastName(req.getParameter("lname"));
		User user = new User();
		user.setEmail(req.getParameter("useremail"));
		userDetail.setUser(user);
		return userDetail;

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDetail userDetail = setUserDetailsWithRequestParam(req);
		Part file = req.getPart("profile");
		String fileName = file.getSubmittedFileName();
		String uploadedFilePath = FileUploaderUtil.uploadFile(file, fileName, userDetail.getUser().getEmail());
		ProfilePicture profilePicture = new ProfilePicture();
		profilePicture.setProfilePath(uploadedFilePath);
		userDetail.setProfilePicture(profilePicture);

		HashMap<String, String> validationResponse = basicFormValidation.checkValidations(userDetail);
		try {
			if (validationResponse.isEmpty()) {
				UserDetail newUserDetail = userDetailService.addUserDetail(userDetail);
				req.getSession().setAttribute("userDetail", newUserDetail);
				resp.sendRedirect(req.getContextPath() + "/portal/dashboard");
			} else {
				System.out.println(validationResponse);
				req.setAttribute("userDetailValidation", validationResponse);
				req.setAttribute("useremail", req.getParameter("useremail"));
				RequestDispatcher dispatcher = req.getRequestDispatcher("/userdetail_form.jsp");
				dispatcher.forward(req, resp);
			}

		} catch (UserNotFoundException excp) {

		} catch (Exception excp) {

		}
	}

}
