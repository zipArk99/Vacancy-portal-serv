package com.app.vacancyportal.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import com.app.vacancyportal.entity.Vacancy;
import com.app.vacancywebservice.service.impl.VacancyServiceImpl;
import com.app.vacancywebservice.service.impl.VacancyServiceImplServiceLocator;

public class VacancyController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VacancyServiceImplServiceLocator vacancyServiceImplServiceLocator = new VacancyServiceImplServiceLocator();
		try {
			HttpSession session = req.getSession(false);
			com.app.vacancywebservice.entity.Vacancy[] vacancies = (com.app.vacancywebservice.entity.Vacancy[]) session
					.getAttribute("vacancies");

			if (Objects.isNull(vacancies)) {
				VacancyServiceImpl vacancyServiceImpl = vacancyServiceImplServiceLocator.getVacancyServiceImpl();
				vacancies = vacancyServiceImpl.fetchVacancies();
				session.setAttribute("vacancies", vacancies);
			}
			req.getRequestDispatcher("/vacancy_page.jsp").forward(req, resp);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
