package com.databaseOperations.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import com.classes.Customer;
import com.databaseConnection.web.DatabaseConnection;

@WebServlet("/LoginCheck")
public class login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		Customer user = new Customer();
		
		String eAddress = request.getParameter("email");
		String password = request.getParameter("pass");
		
		try {
			user = DatabaseConnection.login(eAddress, password);
//			JFrame frame = new JFrame();
//			JOptionPane.showMessageDialog(frame, user.getfName());
			request.getRequestDispatcher("viewListingsIn.html").include(request, response);
		} catch(Exception ex) {
			System.out.println("Login unsuccessful");
			printWriter.println("User Email and Password do not match, Please try again!!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		

	}
}
