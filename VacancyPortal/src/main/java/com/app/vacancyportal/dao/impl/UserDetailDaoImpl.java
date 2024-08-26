package com.app.vacancyportal.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.vacancyportal.dao.ProfilePictureDao;
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
	ProfilePictureDao profilePictureDao;

	public UserDetailDaoImpl() {
		userDao = UserDaoFactory.createUserDao();
		profilePictureDao = new ProfilePictureDaoImpl();
	}

	private SessionFactory getSession() {
		return HibernateUtil.getSessionFactory();
	}

	private void rollBackTransaction(Transaction transaction) {

		if (transaction != null) {
			transaction.rollback();
		}

	}

	@Override
	public UserDetail add(UserDetail userDetail) throws UserNotFoundException {
		org.hibernate.Transaction transaction = null;
		UserDetail newUserDetail = null;
		try (Session session = getSession().openSession()) {
			transaction = session.beginTransaction();

			// fetching user by email
			User user = userDao.fetchUserByEmailId(userDetail.getUser().getEmail());

			// saving profile picture
			ProfilePicture profilePicture = new ProfilePicture();
			profilePicture.setUser(user);
			profilePicture.setProfilePath(userDetail.getProfilePicture().getProfilePath());
			ProfilePicture uploadedProfilePicture = profilePictureDao.add(profilePicture);

			// saving user detail
			userDetail.setUser(user);
			userDetail.setProfilePicture(uploadedProfilePicture);
			userDetail.getProfilePicture().setUser(user);
			session.save(userDetail);
			// newUserDetail.getUser().setHashPassword("");
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
		org.hibernate.Transaction transaction = null;
		UserDetail updatedUserDetail = null;
		try (Session session = getSession().openSession()) {
			transaction = session.beginTransaction();
			session.update(userDetail);
			transaction.commit();
		} catch (Exception excp) {
			System.out.println(excp.getMessage());
			excp.printStackTrace();
			rollBackTransaction(transaction);
		}
		return updatedUserDetail;
	}

	@Override
	public List<UserDetail> fetchUsers() {
		List<UserDetail> usersDetail = null;
		try (Session session = getSession().openSession()) {
			usersDetail = session.createQuery(
					"SELECT ud FROM UserDetail ud WHERE ud.user.email NOT IN (SELECT u.email FROM User u WHERE u.roleId=1)")
					.list();
			System.out.println(usersDetail.size());
			// usersDetail.stream().filter(user->user.)
		} catch (Exception excp) {

			excp.printStackTrace();
		}
		return usersDetail;
	}

	@Override
	public UserDetail fetchUser(String email) {
		UserDetail userDetail = null;
		try (Session session = getSession().openSession()) {

			userDetail = (UserDetail) session.get(UserDetail.class, email);
			System.out.println(userDetail.getProfilePictureList().size());
			userDetail.getUser().setHashPassword("");

		} catch (Exception e) {

		}
		return userDetail;
	}

	@Override
	public boolean updateProfile(UserDetail userDetail, int id) {
		Transaction transaction = null;
		try (Session session = getSession().openSession()) {
			transaction = session.beginTransaction();
			session.update(userDetail);
		
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
