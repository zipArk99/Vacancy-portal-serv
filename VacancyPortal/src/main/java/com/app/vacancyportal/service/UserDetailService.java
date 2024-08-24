package com.app.vacancyportal.service;

import java.util.List;

import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.exception.UserNotFoundException;

public interface UserDetailService {
	
	
	public UserDetail fetchUserByEmailId(String email);
	public List<UserDetail> fetchAllUsers();
	UserDetail addUserDetail(UserDetail userDetail) throws UserNotFoundException;
	UserDetail updateUserDetail(UserDetail userDetail);
	public boolean changeUserProfile(UserDetail userDetail, int id);

}
