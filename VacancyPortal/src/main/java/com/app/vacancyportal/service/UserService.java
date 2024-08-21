package com.app.vacancyportal.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.exception.UserAlreadyRegisteredException;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.exception.UserRegistrationException;
import com.app.vacancyportal.model.Login;

public interface UserService {
	
	void registerUser(User user) throws UserAlreadyRegisteredException, UserRegistrationException;
	User loginUser(Login login) throws UserNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException;
	void updatePassword(String oldPassword,String newPassword);
	boolean removeUser	(String email);

}
