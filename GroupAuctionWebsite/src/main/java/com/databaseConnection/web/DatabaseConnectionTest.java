package com.databaseConnection.web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import com.databaseOperations.web.Customer;
import com.databaseOperations.web.Listing;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

class DatabaseConnectionTest extends DatabaseConnection {
	


	@Test
	void testGetConnect() {
		Connection myConnection = null;
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/auctions";
	        String user = "root";
	        String password = "Aholme13!";
	        myConnection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
			boolean testConnection = true;
	        if(myConnection == null) {
	        	testConnection = false;
	        }
	        else {
	        	testConnection = true;
	        }
	        assertEquals(true, testConnection);
	}

	@Test
	void testSaveCustomer() {
		Customer c = new Customer();
		int status = 0;
		String test;
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
		
	}

}
