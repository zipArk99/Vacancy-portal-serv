package com.app.vacancyportal.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.vacancyportal.dao.ProfilePictureDao;
import com.app.vacancyportal.entity.ProfilePicture;
import com.app.vacancyportal.util.HibernateUtil;

public class ProfilePictureDaoImpl implements ProfilePictureDao {

	private SessionFactory getSession() {
		return HibernateUtil.getSessionFactory();
	}

	@Override
	public ProfilePicture add(ProfilePicture profilePicture) {
		Transaction transaction = null;
		int savedPp ;
		try (Session session = getSession().openSession()) {
			transaction = session.beginTransaction();
			savedPp = (int) session.save(profilePicture);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profilePicture;
	}

	@Override
	public boolean update(String emailId, ProfilePicture picture) {
		// TODO Auto-generated method stub
		return false;
	}

}
