package com.app.vacancyportal.dao.impl;

import java.util.List;

import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.app.vacancyportal.dao.UserDao;
import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.exception.UserAlreadyRegisteredException;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.exception.UserRegistrationException;
import com.app.vacancyportal.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	private SessionFactory getSession() {
		return HibernateUtil.getSessionFactory();
	}

	@Override
	public void addUser(User registration) throws UserAlreadyRegisteredException, UserRegistrationException {
		Transaction transaction = null;
		Session session = null;
		try {
			session = getSession().openSession();
			transaction = session.beginTransaction();
			if (!ifUserRegistered(registration.getEmail())) {
				session.save(registration);
				transaction.commit();
			} else {
				System.out.println("inidex already registered");
				throw new UserAlreadyRegisteredException("User is already registered");
			}
			session.close();
		} catch (HibernateException | IllegalStateException | RollbackException e) {
			System.out.println("Exception occured::" + e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
		// mysql :: YYYY-MM-DD HH:MI:SS
		// Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
	}

	@Override
	public boolean deleteUser(String email) {
		Transaction transaction = null;
		try (Session session = getSession().openSession()) {
			transaction = session.beginTransaction();
			User user = fetchUserByEmailId(email);
			session.remove(user);
			transaction.commit();	
			return true;
		} catch (Exception excp) {
			if (transaction != null) {
				transaction.rollback();
			}
			excp.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean ifUserRegistered(String email) throws UserRegistrationException {
		List<String> results;
		try (Session session = getSession().openSession()) {
			NativeQuery<String> query = session
					.createSQLQuery("select email_id from registration where email_id = :emailId");
			query.setParameter("emailId", email);
			results = query.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw new UserRegistrationException("Error occured while registering user !!");
		}
		return !results.isEmpty();
	}

	@Override
	public User fetchUserByEmailId(String email) throws UserNotFoundException {
		User result;
		try (Session session = getSession().openSession()) {
			result = session.get(User.class, email);
			if (result == null) {
				throw new UserNotFoundException("User not found");
			}
			return result;
		}
	}
}
