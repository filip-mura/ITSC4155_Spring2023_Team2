package com.databaseOperations.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import javax.swing.JFrame;

import com.classes.Listing;
import com.databaseConnection.web.DatabaseConnection;

@WebServlet("/Listings")
public class GetListings extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter printWriter = response.getWriter();
		ArrayList<Listing> listings = new ArrayList<Listing>(); 
		String filePath = "/Users/aspears313/Desktop/Classes/CurrentClasses/Software Dev. Projects/Group Project/ITSC4155_Spring2023_Team2/GroupProject/GroupAuctionWebsite/src/main/webapp/showAllListings.html";
		String marker = "<!-- content -->";
		
		try {
			listings.addAll(DatabaseConnection.getListingsFromDatabase());
			if (!listings.isEmpty()) {
				BufferedReader bf = new BufferedReader(new FileReader(filePath));
				StringBuilder htmlContent = new StringBuilder();
				String line;
				while ((line = bf.readLine()) != null) {
					htmlContent.append(line).append("\n");
				
					if (line.contains(marker)) {
						for (Listing list : listings) {
							htmlContent.append("<div class = \"listing\" ><a href = \"individualListing.html\"><img src=\"mustang1.jpeg\" alt=\"Vehicle Image\"></a><h3>" + list.getCarYear() + 
									" " + list.getCarMake() + " " + list.getCarModel() + "</h3>" +
									"<p>Mileage: " + list.getCarMileage() + "</p>" +
									"<p>Current Bid: " + list.getCarStartBid() + "</p></div>");
						}
					}
				}
				bf.close();
				
				// Write the updated HTML back to the file
				BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
				bw.write(htmlContent.toString());
				bw.close();
				
				System.out.println("Added successfully");
				request.getRequestDispatcher("showAllListings.html").include(request, response);
				
			} else {
				printWriter.println("Currently there are no listings. Come back later.");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}	
}

