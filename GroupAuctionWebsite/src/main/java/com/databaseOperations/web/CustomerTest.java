package com.databaseOperations.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.classes.Customer;

class CustomerTest {
	Customer testCustomer = new Customer("John", "Smith", "Jsmith@email.com", "1234", false, 1);
	@Test
	void testGetId() {	
		assertEquals(1, testCustomer.getId());
	}

	@Test
	void testSetId() {		
		testCustomer.setId(1);
		assertEquals(1, testCustomer.getId());
	}

	@Test
	void testSetfName() {
		testCustomer.setfName("Test");
		assertEquals("Test", testCustomer.getfName());
	}

	@Test
	void testSetlName() {
		testCustomer.setlName("Test");
		assertEquals("Test", testCustomer.getlName());
	}


	@Test
	void testSetEmail() {
		testCustomer.setEmail("Test");
		assertEquals("Test", testCustomer.getEmail());
	}

	@Test
	void testSetPassword() {
		testCustomer.setPassword("Test");
		assertEquals("Test", testCustomer.getPassword());
	}

}
