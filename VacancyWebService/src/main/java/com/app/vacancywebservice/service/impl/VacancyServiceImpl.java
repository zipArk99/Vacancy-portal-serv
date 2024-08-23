package com.app.vacancywebservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.hibernate.Session;


import com.app.vacancywebservice.entity.Vacancy;
import com.app.vacancywebservice.service.VacancyService;
import com.app.vacancywebservice.util.HibernateUtil;




public class VacancyServiceImpl implements VacancyService {

	@Override
	public String fetchVacancies() {
		System.out.println("get vcccccc");
		List<Vacancy> vacancies = new ArrayList<>();
		try {
			System.out.println("lol");
			HibernateUtil bu = HibernateUtil.getInstance();
			Session session = bu.getSessionFactory().openSession();
	
			vacancies = (List<Vacancy>) session.createQuery("SELECT vac FROM Vacancy vac").list();
			System.out.println("vacancies:" + vacancies);
		} catch (Exception e) {
			System.out.println("error message ::" + e.getMessage());
			e.printStackTrace();
		}
		
		  return vacancies.stream() .map(Vacancy::getVacancyTitle) // Extract titles
		  .collect(Collectors.joining(", ")); // Join titles
		 	}


}
