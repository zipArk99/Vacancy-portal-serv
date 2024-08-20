package com.app.vacancyportal.dao;

import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.exception.UserAlreadyRegisteredException;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.exception.UserRegistrationException;
import com.app.vacancyportal.model.Login;

public interface UserDao {
	public void addUser(User registration) throws UserAlreadyRegisteredException, UserRegistrationException ;

	public void deleteUser(String email);

	boolean ifUserRegistered(String email) throws UserRegistrationException;

	User fetchUserByEmailId(String email) throws UserNotFoundException;
}
