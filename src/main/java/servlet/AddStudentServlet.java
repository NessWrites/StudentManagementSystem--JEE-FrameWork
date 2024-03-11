package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/registerstudent" })
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int phoneNumber;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.print("Getting Hectic!!!!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String firstname = request.getParameter("FirstName");
        String lastname = request.getParameter("LastName");
        String date = request.getParameter("Birthday");
        String gender = request.getParameter("Gender");
        String email = request.getParameter("Email");
        String phoneNumberStr = request.getParameter("PhoneNumber");
        String subject = request.getParameter("Subject");
        String password = request.getParameter("password");
		String userName = request.getParameter("username");
               
        

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        		// Load the MySQL JDBC driver

            String localhostUrl = "jdbc:mysql://localhost:3306/student_management";
            String localhostUsername = "root";
            String localhostPassword = "";

            try (Connection connection = DriverManager.getConnection(localhostUrl, localhostUsername,
                    localhostPassword)) {
                String registerStudentQuery = "INSERT INTO student_info (firstname,lastname, birthday,gender,email,phonenumber,subject, username, password) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";

                try (PreparedStatement stt = connection.prepareStatement(registerStudentQuery)) {
                    stt.setString(1, firstname);
                    stt.setString(2, lastname);
                    stt.setString(3,date );
                    stt.setString(4,gender );
                    stt.setString(5,email );
                    
                   
                    	stt.setInt(6, phoneNumber);
                   
                    
                    
                    stt.setString(7, subject);
                    stt.setString(8, userName);
                    stt.setString(9, password);

                    int result = stt.executeUpdate();
                    if (result > 0) {
                        writer.append("Success!");
                    } else {
                        writer.append("Unsuccessful!");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            writer.append(ex.getMessage());
        }
    }
}
