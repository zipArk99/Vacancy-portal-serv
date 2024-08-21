package com.app.vacancyportal.controller;

import java.io.File;
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

import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.factory.UserDetailServiceFactory;
import com.app.vacancyportal.service.UserDetailService;
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

	private boolean uploadProfile(InputStream inputStream, String path) {
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			byte [] fileByte = new byte [inputStream.available()];
			inputStream.read(fileByte);
			fileOutputStream.write(fileByte);
			fileOutputStream.close();
						
		} catch ( IOException |UncheckedIOException  e ) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		/*
		 * file = new File("/userprofile/"+userEmail+fileName+"__"+uuid.toString());
		 * OutputStream outputStream = new FileOutputStream(file); byte [] byteFile =
		 * new byte[inputStream.available()]; inputStream. outputStream.write();
		 */
		return false;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDetail userDetail = setUserDetailsWithRequestParam(req);
		Part file = req.getPart("profile");
		String path= req.getRealPath("profilepicture");
		System.out.println(path);
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getSubmittedFileName());
		//uploadProfile(file.getInputStream(), path );

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
