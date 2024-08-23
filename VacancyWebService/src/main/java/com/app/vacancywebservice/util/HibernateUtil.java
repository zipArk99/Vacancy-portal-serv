package com.app.vacancywebservice.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.app.vacancywebservice.entity.Vacancy;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    static HibernateUtil instance = null;

    private HibernateUtil() {
        // Configure sessionFactory here using a configuration file or environment variables
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        // Load properties from a configuration file (optional)
        try {
            //configuration.configure("hibernate.cfg.xml");
        } catch (Exception e) {
            // Handle configuration file loading errors
            System.err.println("Error loading configuration file: " + e.getMessage());
        }

        // Set properties directly (or load from environment variables)
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "admin");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Vacancy.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static synchronized HibernateUtil getInstance() {
        if (sessionFactory == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // ... other methods if needed
}