package com.databaseOperations.web;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import com.classes.Customer;
import com.databaseConnection.web.DatabaseConnection;

@WebServlet("/InsertRegistrationInfo")
public class InsertRegistration extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
		
			String fName = request.getParameter("fname");
			String lName = request.getParameter("lname");
			String email = request.getParameter("email");
			String password = request.getParameter("pass");

			Customer cust = new Customer();
			cust.setfName(fName);
			cust.setlName(lName);
			cust.setEmail(email);
			cust.setPassword(password);
			
			int status = DatabaseConnection.save(cust);
			
			if(status > 0) {
//				JFrame frame = new JFrame();
//				JOptionPane.showMessageDialog(frame, "Registration Saved!");
				request.getRequestDispatcher("index.html").include(request, response);
			} else {
				printWriter.println("Unable to save. Try Again!!");
			}
	}	
}
