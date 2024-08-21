package com.app.vacancyportal.service.impl;

import java.util.List;

import com.app.vacancyportal.dao.UserDetailDao;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.service.UserDetailService;

import net.bytebuddy.asm.Advice.Return;

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
		userDetailDao.update(userDetail);
		UserDetail updatedUserDetail = userDetailDao.fetchUser(userDetail.getUser().getEmail());
		return updatedUserDetail;
	}

	@Override
	public UserDetail fetchUserByEmailId(String email) {
		UserDetail userDetail = userDetailDao.fetchUser(email);
		userDetail.getUser().setHashPassword(email);
		return userDetail;
	}

	@Override
	public List<UserDetail> fetchAllUsers() {
		List<UserDetail> usersDetail = userDetailDao.fetchUsers();
		return usersDetail;
	}

}
