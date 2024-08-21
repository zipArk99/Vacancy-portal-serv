package com.app.vacancyportal.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.app.vacancyportal.dao.UserDao;
import com.app.vacancyportal.dao.impl.UserDaoImpl;
import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.exception.InvalidUserCredentialsException;
import com.app.vacancyportal.exception.UserAlreadyRegisteredException;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.exception.UserRegistrationException;
import com.app.vacancyportal.factory.UserDaoFactory;
import com.app.vacancyportal.model.Login;
import com.app.vacancyportal.service.UserService;
import com.app.vacancyportal.util.PasswordHasher;
import com.app.vacancyportal.util.PasswordValidator;

public class UserServiceImpl implements UserService {

	final private UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void registerUser(User user) throws UserAlreadyRegisteredException, UserRegistrationException {
		String hashPassword = "";
		try {
			hashPassword = PasswordHasher.generateHashPassword(user.getPassword());
			user.setHashPassword(hashPassword);
			user.setRoleId(2);
			userDao.addUser(user);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User loginUser(Login login) throws UserNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException {
		User user = null;

		user = userDao.fetchUserByEmailId(login.getEmail());
		if (PasswordValidator.validatePassword(login.getPassword(), user.getHashPassword())) {
			user.setHashPassword("");
		} else {
			throw new InvalidUserCredentialsException("Wrong user credentials");
		}
		return user;
	}

	@Override
	public void updatePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean removeUser(String email) {
		return userDao.deleteUser(email);
	}

}
