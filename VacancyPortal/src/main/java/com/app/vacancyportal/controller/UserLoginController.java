package com.app.vacancyportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.vacancyportal.entity.User;
import com.app.vacancyportal.exception.InvalidUserCredentialsException;
import com.app.vacancyportal.exception.UserNotFoundException;
import com.app.vacancyportal.factory.UserServiceFactory;
import com.app.vacancyportal.model.Login;
import com.app.vacancyportal.service.UserService;
import com.app.vacancyportal.util.formvalidation.BasicFormValidation;

public class UserLoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserService userService;
	private final BasicFormValidation<Login> basicFormValidation;

	public UserLoginController() {
		userService = UserServiceFactory.createUserService();
		basicFormValidation = new BasicFormValidation<Login>();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		System.out.println("user login called");
		Login loginInfo = new Login(req.getParameter("lEmail"), req.getParameter("lPassword"));
		RequestDispatcher dispatcher;
		try {
			HashMap<String, String> validationResponse = basicFormValidation.checkValidations(loginInfo);
			if (validationResponse.isEmpty()) {
				try {
					System.out.println("callascascjk kkkkjjjjknk");
					User user = userService.loginUser(loginInfo);
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					resp.sendRedirect(req.getContextPath()+"/portal/dashboard");
				} catch (InvalidUserCredentialsException excp) {
					out.print("<h2>Wrong Login Credentials, Please Try Again</h2>");
					excp.printStackTrace();
				} catch (UserNotFoundException excp) {
					out.print("<h2>User not Found, please first register yourself</h2>");
					excp.printStackTrace();
				}
			} else {
				System.out.println("called::"+validationResponse);
				req.setAttribute("loginUserValidation", validationResponse);
				dispatcher = req.getRequestDispatcher("/login_page.jsp");
				dispatcher.forward(req, resp);
				System.out.println("called::"+validationResponse);
			}	

		} catch (Exception excp) {
			excp.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login_page.jsp").forward(req, resp);
	}

}
