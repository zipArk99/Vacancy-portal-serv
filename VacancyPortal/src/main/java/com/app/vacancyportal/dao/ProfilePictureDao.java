package com.app.vacancyportal.dao;

import java.util.List;

import com.app.vacancyportal.dto.ProfilePicResponse;
import com.app.vacancyportal.entity.ProfilePicture;

public interface ProfilePictureDao {
	public ProfilePicture add(ProfilePicture profilePicture);

	public boolean update(String emailId, ProfilePicture picture);
	
	public List<ProfilePicResponse> fetchProfiles(String email);

}
