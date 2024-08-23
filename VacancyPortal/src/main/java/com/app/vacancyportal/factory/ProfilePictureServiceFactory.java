package com.app.vacancyportal.factory;

import com.app.vacancyportal.dao.impl.ProfilePictureDaoImpl;
import com.app.vacancyportal.dao.impl.UserDetailDaoImpl;
import com.app.vacancyportal.service.ProfilePictureService;
import com.app.vacancyportal.service.UserDetailService;
import com.app.vacancyportal.service.impl.ProfilePictureServiceImpl;
import com.app.vacancyportal.service.impl.UserDetailServiceImpl;

public class ProfilePictureServiceFactory {

	private static ProfilePictureService profilePathService;

	private ProfilePictureServiceFactory() {
		// TODO Auto-generated constructor stub
	}

	public static ProfilePictureService createProfilePictureServiceInstance() {
		if (profilePathService == null) {
			synchronized (ProfilePictureService.class) {
				profilePathService = new ProfilePictureServiceImpl(new ProfilePictureDaoImpl());
			}
		}
		return profilePathService;

	}

}
