package com.app.vacancyportal.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
		int savedPp;
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
		return false;
	}

	@Override
	public List<ProfilePicture> fetchProfiles(String email) {
		List<ProfilePicture> profilePictures = new ArrayList<>();
		try (Session session = getSession().openSession()) {
			profilePictures = session
					.createQuery(
							"SELECT pp.profilePath, pp.pictureId FROM ProfilePicture pp WHERE pp.user.email=:emailId")
					.setParameter("emailId", email).list();

		} catch (Exception excp) {
			excp.printStackTrace();
		}
		return profilePictures;
	}

}
