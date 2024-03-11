/*
 * 
 * Author: NessWrites
 * ness4business@gmail.com
 * Student_Management_System Data Base Controller
 * Islington College
 * AI-3
 * */

package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.StudentModel;
import utils.StringUtils;

public class DataBaseController {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(StringUtils.DRIVER_NAME); // Load the MySQL JDBC driver

		return DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME,
				StringUtils.LOCALHOST_PASSWORD);
	}

	public int registerStudent(StudentModel student) {
		try {
			PreparedStatement stt = getConnection().prepareStatement(StringUtils.REGISTER_STUDENT_QUERY);
			stt.setString(1, student.getFirstname());
			stt.setString(2, student.getLastname());
			stt.setDate(3, Date.valueOf(student.getDate()));

			stt.setString(4, student.getGender());
			stt.setString(5, student.getEmail());
			stt.setString(6, student.getPhoneNumberStr());
			stt.setString(7, student.getSubject());
			stt.setString(8, student.getUsername());
			stt.setString(9, student.getPassword());

			int result = stt.executeUpdate();
			if (result > 0) {
				return 1;

			} else {
				return 0;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1;

		}
	}

	public int getStudentLoginInfo(String username, String password)
	{
		try( Connection con = getConnection())
		{
			PreparedStatement st = con.prepareStatement(StringUtils.GET_ALL_STUDENT_INFO);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet result = st.executeQuery();
			
			if (result.next()) 
				{
				// User name and password match in the database
				String userDb = result.getString("username");
				String passwordDb = result.getString("password");
				//
				if (userDb.equals(username) && passwordDb.equals(password))
				return 1;
				
				else 
				return 0;
		}
			else 
			{
			return -1 ;	
			}
		} catch (SQLException|ClassNotFoundException ex)
			{
			ex.printStackTrace();
			return -2;
			}
	
	
	
	
	}
}