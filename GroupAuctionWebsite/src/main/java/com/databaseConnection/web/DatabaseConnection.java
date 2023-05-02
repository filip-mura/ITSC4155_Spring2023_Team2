package com.databaseConnection.web;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classes.Customer;
import com.classes.Listing;

public class DatabaseConnection {
	
	static Customer customer;
	
    public static Connection getConnect() {
    	Connection myConnection = null;
    	try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/auctions";
	        String user = "root";
	        String password = "password";
//	        String url = "jdbc:mysql://groupauctiondatabase.c28o0ulgtspp.us-east-2.rds.amazonaws.com:3306/auctions";
//	        String user = "admin";
//	        String password = "razno1-pckfy";
	        myConnection = DriverManager.getConnection(url, user, password);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return myConnection;
    }
    
    public static int save(Customer c) {
    	int status = 0;
    	
    	try {
    		Connection myConnection = DatabaseConnection.getConnect();
    		PreparedStatement statement = myConnection.prepareStatement(
    				"INSERT INTO Registrations(fName,lName,eAddress,password) values (?,?,?,?)");
    		
    		
    		statement.setString(1, c.getfName());
    		statement.setString(2, c.getlName());
    		statement.setString(3, c.getEmail());
    		statement.setString(4, c.getPassword());
    		
    		status = statement.executeUpdate();
    		
    		statement.close();
    		myConnection.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return status;
    }
    
    public static int save(Listing list) {
    	int status = 0;
    	
    	try {
    		Connection myConnection = DatabaseConnection.getConnect();
    		PreparedStatement statement = myConnection.prepareStatement(
    				"INSERT INTO Listings(carMake,carModel, carYear, carMileage, carColor, carConditon, carStartBid, carReservePrice, carDescription, carPhoto, userIdFK) values (?,?,?,?,?,?,?,?,?,?,?)"); 
    		
    		statement.setString(1, list.getCarMake());
    		statement.setString(2, list.getCarModel());
    		statement.setString(3, list.getCarYear());
    		statement.setInt(4, list.getCarMileage());
    		statement.setString(5, list.getCarColor());
    		statement.setString(6, list.getCarCondition());
    		statement.setInt(7, list.getCarStartBid());
    		statement.setInt(8, list.getCarReservePrice());
    		statement.setString(9, list.getCarDescription());
    		statement.setInt(10, customer.getId());
    		
    		status = statement.executeUpdate();
    		
    		statement.close();
    		myConnection.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return status;
    }
    
    public static Customer login(String email, String password) {
    	boolean isSuccess = false;
    	customer = new Customer();
    	
    	try {
    		Connection myConnection = DatabaseConnection.getConnect();
    		PreparedStatement statement = myConnection.prepareStatement(
    				"Select * from Registrations where eAddress = ? and password = ? ");
    		
    		statement.setString(1, email);
    		statement.setString(2, password);
    		
    		ResultSet resultSet = statement.executeQuery();
    		isSuccess = resultSet.next();
    		
    		if (isSuccess) {
    			// get customer
    			customer.setId(Integer.parseInt(resultSet.getString("id")));
    			customer.setEmail(email);
    			customer.setIsLoggedIn(true);
    			customer.setfName(resultSet.getString("fName"));
    			customer.setlName(resultSet.getString("lName"));
    			return customer;
    		} else {
    			return customer;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		return customer;
    	}
    }
    
    public static ArrayList<Listing> getListingsFromDatabase() {
    	
    	ArrayList<Listing> listings = new ArrayList<Listing>();
    	
    	try {
    		Connection myConnection = DatabaseConnection.getConnect();
    		PreparedStatement statement = myConnection.prepareStatement(
    				"Select * from Listings");
    		ResultSet resultSet = statement.executeQuery();
    		int i = 0;
    		int totalRows = resultSet.getFetchSize();
    		
    		while (resultSet.next()) {
    			Listing listing = new Listing();
    			listing.setCarMake(resultSet.getString("carMake"));
    			listing.setCarModel(resultSet.getString("carModel"));
    			listing.setCarYear(resultSet.getString("carYear"));
    			listing.setCarMileage(Integer.parseInt(resultSet.getString("carMileage")));
    			listing.setCarColor(resultSet.getString("carColor"));
    			listing.setCarCondition(resultSet.getString("carConditon"));
    			listing.setCarStartBid(Integer.parseInt(resultSet.getString("carStartBid")));
    			listing.setCarReservePrice(Integer.parseInt(resultSet.getString("carReservePrice")));
    			listing.setCarDescription(resultSet.getString("carDescription"));
    			listing.setCustomerId(Integer.parseInt(resultSet.getString("userIdFK")));
    			listings.add(listing);
    		}
    		
    	} catch (SQLException ex) {
    		System.out.println(ex.getMessage());
    		//Should handle incase nothing is returned
    		return null;
    	}
    	//Should handle incase nothing is returned
		return listings;
    }
}
