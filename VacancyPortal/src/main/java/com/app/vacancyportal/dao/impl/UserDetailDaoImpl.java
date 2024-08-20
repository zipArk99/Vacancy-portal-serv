package com.app.vacancyportal.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.vacancyportal.dao.UserDao;
import com.app.vacancyportal.dao.UserDetailDao;
import com.app.vacancyportal.entity.ProfilePicture;
import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.factory.UserDaoFactory;
import com.app.vacancyportal.util.HibernateUtil;

public class UserDetailDaoImpl implements UserDetailDao {

	UserDao userDao;

	public UserDetailDaoImpl() {
		userDao = UserDaoFactory.createUserDao();
	}

	private SessionFactory getSession() {
		return HibernateUtil.getSessionFactory();
	}

	@Override
	public UserDetail add(UserDetail userDetail) throws UserNotFoundException {
		org.hibernate.Transaction transaction = null;
		UserDetail newUserDetail = null;
		try (Session session = getSession().openSession()) {
			transaction = session.beginTransaction();
			User user = userDao.fetchUserByEmailId(userDetail.getUser().getEmail());
			userDetail.setUser(user);
			newUserDetail = (UserDetail) session.save(userDetail);
			newUserDetail.getUser().setHashPassword("");
			transaction.commit();
		} catch (Exception excp) {
			if (excp instanceof UserNotFoundException) {
				throw new UserNotFoundException("sorry, user is not registered");
			}
			if (transaction != null) {
				System.out.println(excp.getMessage());
				transaction.rollback();
			}
		}
		return newUserDetail;

	}

	@Override
	public UserDetail update(UserDetail userDetail) {
		return null;
	}

	@Override
	public List<UserDetail> fetchUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetail fetchUser(String email) {
		UserDetail userDetail = null;
		try (Session session = getSession().openSession()) {

			userDetail = (UserDetail) session.get(UserDetail.class, email);

		} catch (Exception e) {

		}
		return userDetail;
	}

}
