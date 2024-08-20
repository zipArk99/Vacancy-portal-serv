package com.app.vacancyportal.util;

import java.util.Properties;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.app.vacancyportal.entity.ProfilePicture;
import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.entity.Role;
import com.app.vacancyportal.entity.UserDetail;
import com.app.vacancyportal.entity.Vacancy;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		try {
			
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties properties = new Properties();
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/jobvacancydb?useSSL=false");
			properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "admin");
			properties.put(Environment.SHOW_SQL, "true");
			properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			properties.put(Environment.HBM2DDL_AUTO, "update");

			
			configuration.setProperties(properties);
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(UserDetail.class);
			configuration.addAnnotatedClass(Role.class);
			configuration.addAnnotatedClass(Vacancy.class);
			configuration.addAnnotatedClass(ProfilePicture.class);
			
		

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			

		}
		}catch(Exception e) {
			System.out.println("Exception Occured :: "+ e.toString());
		}
		return sessionFactory;

	}
	
	  public static void shutdown() {
	        if (sessionFactory != null) {
	            sessionFactory.close();
	        }
	    }

}
