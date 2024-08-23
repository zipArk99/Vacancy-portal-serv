package com.app.vacancyportal.service.impl;

import java.util.List;

import com.app.vacancyportal.dao.ProfilePictureDao;
import com.app.vacancyportal.dto.ProfilePicResponse;
import com.app.vacancyportal.entity.ProfilePicture;
import com.app.vacancyportal.service.ProfilePictureService;

public class ProfilePictureServiceImpl implements ProfilePictureService {

	ProfilePictureDao profilePictureDao;

	public ProfilePictureServiceImpl(ProfilePictureDao profilePictureDao) {
		this.profilePictureDao = profilePictureDao;
	}

	@Override
	public ProfilePicture addProfilePicture(ProfilePicture picture) {
		ProfilePicture profilePicture = profilePictureDao.add(picture);
		return profilePicture;
	}

	@Override
	public List<ProfilePicResponse> fetchProfilesByEmailId(String email) {
		List<ProfilePicResponse> profilePictures=null;
		try {

			 profilePictures = profilePictureDao.fetchProfiles(email);

		} catch (Exception excp) {
			excp.printStackTrace();
		}
		return profilePictures;

	}

}
