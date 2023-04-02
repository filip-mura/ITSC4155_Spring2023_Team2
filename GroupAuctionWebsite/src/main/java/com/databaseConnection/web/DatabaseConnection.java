package com.databaseConnection.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.ResultSet;

import com.insertRegistration.web.Customer;

public class DatabaseConnection {
	
    public static Connection getConnect() {
    	Connection myConnection = null;
    	try {
	        Class.forName("com.mysql.jdbc.Driver");
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
    
    public static boolean login(String email, String password) {
    	boolean isSuccess = false;
    	
    	try {
    		Connection myConnection = DatabaseConnection.getConnect();
    		PreparedStatement statement = myConnection.prepareStatement(
    				"Select * from Registrations where eAddress = ? and password = ? ");
    		
    		statement.setString(1, email);
    		statement.setString(2, password);
    		
    		ResultSet resultSet = statement.executeQuery();
    		isSuccess = resultSet.next();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return isSuccess;
    }
    
    
    
}

    
    // public static void main (String[] args) throws Exception {
        
    //  //Accessing driver from the JAR file
        
        
        
    //  try {
    //      Connection myConn = DriverManager.getConnection(url,user,password);
    //      PreparedStatement statement = myConn.prepareStatement("select * from Registration");
    //      ResultSet result = statement.executeQuery();
    //      while(result.next()) {
    //          System.out.println(result.getString(2) + " " + result.getString(3));
    //      }
    //  } catch (SQLException e) {
    //      e.printStackTrace();
    //  }
    // }

