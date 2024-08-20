package com.app.vacancyportal.service;

import com.app.vacancyportal.entity.UserDetail;

public interface UserDetailService {
	
	public UserDetail addUserDetail (UserDetail userDetail);
	public UserDetail updateUserDetail(UserDetail userDetail);
	public UserDetail fetchUserByEmailId(String email);

}
