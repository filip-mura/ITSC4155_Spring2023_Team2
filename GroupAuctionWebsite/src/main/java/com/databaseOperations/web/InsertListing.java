package com.databaseOperations.web;

import java.io.File;
import java.io.FileInputStream;
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.classes.Listing;
import com.databaseConnection.web.DatabaseConnection;

@WebServlet("/InsertNewListing")
public class InsertListing extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			
			String carMake = request.getParameter("make");
			String carModel = request.getParameter("model");
			String carYear = request.getParameter("year");
			int carMileage = Integer.parseInt(request.getParameter("mileage"));
			String carColor = request.getParameter("color");
			String carCondition = request.getParameter("condition");
			int carStartBid = Integer.parseInt(request.getParameter("starting_bid"));
			int carReservePrice = Integer.parseInt(request.getParameter("reserve_price"));
			String carDescription = request.getParameter("description");
			
			Listing newCar = new Listing();
			newCar.setCarMake(carMake);
			newCar.setCarModel(carModel);
			newCar.setCarColor(carColor);
			newCar.setCarCondition(carCondition);
			newCar.setCarDescription(carDescription);
			newCar.setCarMileage(carMileage);
			newCar.setCarStartBid(carStartBid);
			newCar.setCarReservePrice(carReservePrice);
			newCar.setCarYear(carYear);
			
			
			int status = DatabaseConnection.save(newCar);
			
			if(status > 0) {
//				JFrame frame = new JFrame();
//				JOptionPane.showMessageDialog(frame, "Registration Saved!");
				request.getRequestDispatcher("viewListingIn.html").include(request, response);
			} else {
				printWriter.println("Unable to save. Try Again!!");
			}
	}	
}
