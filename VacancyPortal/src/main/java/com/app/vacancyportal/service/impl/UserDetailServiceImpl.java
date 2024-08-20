package com.app.vacancyportal.service.impl;

import com.app.vacancyportal.dao.UserDetailDao;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.service.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService {

	UserDetailDao userDetailDao;

	public UserDetailServiceImpl(UserDetailDao userDetailDao) {
		this.userDetailDao = userDetailDao;
	}

	@Override
	public UserDetail addUserDetail(UserDetail userDetail) throws UserNotFoundException {

		UserDetail newUserDetail = userDetailDao.add(userDetail);
		return newUserDetail;
	}

	@Override
	public UserDetail updateUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetail fetchUserByEmailId(String email) {
		UserDetail userDetail = userDetailDao.fetchUser(email);
		userDetail.getUser().setHashPassword(email);
		return userDetail;
	}	

}
