package com.app.vacancyportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.vacancyportal.factory.UserServiceFactory;
import com.app.vacancyportal.service.UserService;

public class DeleteUserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService;
	
	public DeleteUserController() {
		userService = UserServiceFactory.createUserService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		if(userService.removeUser(email)) {
			resp.sendRedirect(req.getContextPath()+"/portal/usermanagement");
		}else {
			resp.setContentType("text/html");
			PrintWriter out =resp.getWriter();
			out.print("<h2>Sorry, some error occured while deleting user</h2>");
		}
	}
}
