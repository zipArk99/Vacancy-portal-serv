package com.app.vacancyportal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.vacancyportal.dao.ProfilePictureDao;
import com.app.vacancyportal.factory.ProfilePictureServiceFactory;
import com.app.vacancyportal.service.ProfilePictureService;

public class ProfilePictureController extends HttpServlet {
	
	ProfilePictureService profilePictureService;
	public ProfilePictureController() {
		profilePictureService = ProfilePictureServiceFactory.createProfilePictureServiceInstance();
 	}

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
	}

}
