/*
 * Author: NessWrites
 * ness4business@gmail.com
 * Student_Management_System Register Servlet
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

import org.apache.tomcat.dbcp.dbcp2.Utils;

import controller.DataBaseController;
import model.StudentModel;
import utils.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterServlet" })

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DataBaseController dbController = new DataBaseController();

	public RegisterServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws

			ServletException, IOException {
		String userName = request.getParameter("username");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		LocalDate dob = LocalDate.parse(request.getParameter("birthday"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phoneNumberStr = request.getParameter("phoneNumber");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		
		//String retypePassword = request.getParameter("retypePassword");

		// Data Validation

		// Regular expressions for validation
		
		
  
		// Perform validation
		boolean isValid = true;
		if (!firstname.matches(StringUtils.FIRST_NAME_REGEX)) {
			isValid = false;
			response.getWriter().println(StringUtils.FIRST_NAME);
		}

		if (!lastname.matches(StringUtils.LAST_NAME_REGEX)) {
			isValid = false;
			response.getWriter().println(StringUtils.LAST_NAME);
		}

		if (!gender.matches(StringUtils.GENDER_REGEX)) {
			isValid = false;
			response.getWriter().println(StringUtils.GENDER);
		}

		try {

			String dobString = dob.toString();
			if (dobString == null || dobString.isEmpty()) {
				isValid = false;
				response.getWriter().println(StringUtils.BIRTHDAY);
			} else {

				if (!dobString.matches(StringUtils.BIRTHDAY_REGEX)) {
					isValid = false;
					response.getWriter().println(StringUtils.BIRTHDAY);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!phoneNumberStr.matches(StringUtils.PHONE_NUMBER_REGEX)) {
			isValid = false;
			response.getWriter().println(StringUtils.PHONE_NUMBER);
		}

		if (isValid) {
			StudentModel studentModel = new StudentModel(firstname, lastname, dob, gender, email, 
					phoneNumberStr,subject, userName, password);

			int result = dbController.registerStudent(studentModel);

			if (result > 0) { // rootpath, parent path, contextPath in a way is webapp...

				// goes to its own servlet first
				// in order to navigate to the html folder we establist rootpath with
				// getContextPath()
				// response.sendRedirect(request.getContextPath() + "/pages/login.html");
				response.sendRedirect(request.getContextPath() + "/pages/login.html");
			} else {

			}
			response.getWriter().println("Registration successful!");
		} else {
			// Send failure response
			response.getWriter().println("Registration failed. Please check your input.");
		}

	}
}
