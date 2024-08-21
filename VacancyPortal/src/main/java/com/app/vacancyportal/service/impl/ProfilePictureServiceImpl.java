package com.app.vacancyportal.service.impl;

import com.app.vacancyportal.dao.ProfilePictureDao;
import com.app.vacancyportal.entity.ProfilePicture;
import com.app.vacancyportal.service.ProfilePathService;

public class ProfilePictureServiceImpl implements ProfilePathService {

	ProfilePictureDao profilePictureDao;

	public ProfilePictureServiceImpl(ProfilePictureDao profilePictureDao) {
		this.profilePictureDao = profilePictureDao;
	}

	@Override
	public ProfilePicture addProfilePicture(ProfilePicture picture) {
		// TODO Auto-generated method stub
		return null;
	}

}
