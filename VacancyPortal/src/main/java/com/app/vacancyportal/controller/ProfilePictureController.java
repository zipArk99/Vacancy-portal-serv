package com.app.vacancyportal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.app.vacancyportal.dao.ProfilePictureDao;
import com.app.vacancyportal.entity.ProfilePicture;
import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.factory.ProfilePictureServiceFactory;
import com.app.vacancyportal.service.ProfilePictureService;
import com.app.vacancyportal.util.FileUploaderUtil;

@MultipartConfig
public class ProfilePictureController extends HttpServlet {

	ProfilePictureService profilePictureService;

	public ProfilePictureController() {
		profilePictureService = ProfilePictureServiceFactory.createProfilePictureServiceInstance();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user= (User)req.getSession().getAttribute("user");
		Part file = req.getPart("profile");
		String fileName = file.getSubmittedFileName();
		String uploadPath = FileUploaderUtil.uploadFile(file, fileName, user.getEmail());

		//adding profile to DB
		ProfilePicture profilePicture = new ProfilePicture();
		profilePicture.setUser(user);
		profilePicture.setProfilePath(uploadPath);
		profilePictureService.addProfilePicture(profilePicture);
		resp.sendRedirect("/VacancyPortal/updateuserdetail_page.jsp");

	}

}
