package com.app.vacancywebservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;


import com.app.vacancywebservice.entity.Vacancy;
import com.app.vacancywebservice.service.VacancyService;
import com.app.vacancywebservice.util.HibernateUtil;




public class VacancyServiceImpl implements VacancyService {

	@Override
	public List<Vacancy> fetchVacancies() {
		List<Vacancy> vacancies = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			vacancies = (List<Vacancy>) session.createQuery("SELECT * FROM Vacancy vac");
		} catch (Exception e) {
			System.out.println("error message ::" + e.getMessage());
			e.printStackTrace();
		}
		return vacancies;
	}

}
