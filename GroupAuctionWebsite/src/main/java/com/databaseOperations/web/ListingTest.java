package com.databaseOperations.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListingTest {
	Listing testListing = new Listing("Ford", "Focus", "2017", 65000, "Blue", "Good", 10000, 30000, "Well maintained second owner");
	@Test
	void testGetCarMake() {
		assertEquals("Ford", testListing.getCarMake());
	}

	@Test
	void testSetCarMake() {
		testListing.setCarMake("Chevy");
		assertEquals("Chevy", testListing.getCarMake());
	}

	@Test
	void testGetCarModel() {
		assertEquals("Focus", testListing.getCarModel());
	}

	@Test
	void testSetCarModel() {
		testListing.setCarModel("Terrain");
		assertEquals("Terrain", testListing.getCarModel());
	}

	@Test
	void testGetCarYear() {
		assertEquals("2017", testListing.getCarYear());
	}

	@Test
	void testSetCarYear() {
		testListing.setCarYear("2005");
		assertEquals("2005", testListing.getCarYear());
	}

	@Test
	void testGetCarMileage() {
		assertEquals(65000, testListing.getCarMileage());
	}

	@Test
	void testSetCarMileage() {
		testListing.setCarMileage(1000);
		assertEquals(1000, testListing.getCarMileage());
	}

	@Test
	void testGetCarColor() {
		assertEquals("Blue", testListing.getCarColor());
	}

	@Test
	void testSetCarColor() {
		testListing.setCarColor("White");
		assertEquals("White", testListing.getCarColor());
	}

	@Test
	void testGetCarCondition() {
		assertEquals("Good", testListing.getCarCondition());
	}

	@Test
	void testSetCarCondition() {
		testListing.setCarCondition("Bad");
		assertEquals("Bad", testListing.getCarCondition());
	}

	@Test
	void testGetCarStartBid() {
		assertEquals(10000, testListing.getCarStartBid());
	}

	@Test
	void testSetCarStartBid() {
		testListing.setCarStartBid(0);
		assertEquals(0, testListing.getCarStartBid());
	}

	@Test
	void testGetCarReservePrice() {
		assertEquals(30000, testListing.getCarReservePrice());
	}

	@Test
	void testSetCarReservePrice() {
		testListing.setCarReservePrice(5000);
		assertEquals(5000, testListing.getCarReservePrice());
	}

	@Test
	void testGetCarDescription() {
		assertEquals("Well maintained second owner" , testListing.getCarDescription());
	}

	@Test
	void testSetCarDescription() {
		testListing.setCarDescription("Test");
		assertEquals("Test" , testListing.getCarDescription());
	}

}
