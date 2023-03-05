package com.login.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import com.databaseConnection.web.DatabaseConnection;
import com.insertRegistration.web.Customer;

@WebServlet("/LoginCheck")
public class login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		String eAddress = request.getParameter("email");
		String password = request.getParameter("pass");
		
		boolean status = DatabaseConnection.login(eAddress, password);
		
		if (status == true) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Successful Login");
			//Get Customer values
			Customer c = new Customer();
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			printWriter.println("User Email and Password do not match, Please try again!!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}
	
}
