package com.app.vacancyportal.service;

import java.util.List;

import com.app.vacancyportal.entity.ProfilePicture;

public interface ProfilePictureService  {
	
	ProfilePicture addProfilePicture(ProfilePicture picture);
	List<ProfilePicture> fetchProfilesByEmailId(String email);
	

}
