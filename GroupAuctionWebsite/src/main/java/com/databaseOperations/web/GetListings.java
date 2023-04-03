package com.databaseOperations.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import com.databaseConnection.web.DatabaseConnection;

@WebServlet("/Listings")
public class GetListings extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter printWriter = response.getWriter();
		List<Listing> listings = DatabaseConnection.getListingsFromDatabase();
		
		if (!listings.isEmpty()) {
			for (Listing listing : listings) {
				System.out.println(listing);
			}
			request.getRequestDispatcher("viewListings.html").include(request, response);
		} else {
			printWriter.println("Unable to retrieve listings. Try Again!");
		}
	}	
}