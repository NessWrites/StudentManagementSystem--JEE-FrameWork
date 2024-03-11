/*
 * Author: NessWrites
 * ness4business@gmail.com
 * Student_Management_System Login Servlet Messages
 * Islington College
 * AI-3
 * */
package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DataBaseController;

@WebServlet(urlPatterns = "/login", asyncSupported = true)

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataBaseController dbController = new DataBaseController();

	public LoginServlet() {
		this.dbController = new DataBaseController();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws

			ServletException, IOException {
		String userName = request.getParameter("username");

		String password = request.getParameter("password");

		int loginResult = dbController.getStudentLoginInfo(userName, password);

		if (loginResult == 1) {
		    response.sendRedirect(request.getContextPath() + "/pages/welcome.html");
		} else {
		}
	}
}
