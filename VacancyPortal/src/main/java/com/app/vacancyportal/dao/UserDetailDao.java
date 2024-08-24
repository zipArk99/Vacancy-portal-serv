package com.app.vacancyportal.dao;

import java.util.List;

import com.app.vacancyportal.entity.UserDetail;

public interface UserDetailDao {
	public UserDetail add(UserDetail userDetail);

	public UserDetail update(UserDetail userDetail);

	public List<UserDetail> fetchUsers();

	public UserDetail fetchUser(String email);
	
	public boolean updateProfile(UserDetail userDetail, int id);
}
