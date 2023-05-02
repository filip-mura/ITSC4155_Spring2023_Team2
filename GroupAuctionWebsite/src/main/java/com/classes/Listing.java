package com.classes;

import java.io.FileInputStream;

public class Listing {
	private String carMake;
	private String carModel;
	private String carYear;
	private int carMileage;
	private String carColor;
	private String carCondition;
	private int carStartBid;
	private int carReservePrice;
	private String carDescription;
	private int customerId;
	
	public Listing(String carMake, String carModel, String carYear, int carMileage, String carColor, String carCondition, int carStartBid, int carReservePrice, String carDescription, FileInputStream carPic, int customerId) {
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carMileage = carMileage;
		this.carColor = carColor;
		this.carCondition = carCondition;
		this.carStartBid = carStartBid;
		this.carReservePrice = carReservePrice;
		this.carDescription = carDescription;
		this.customerId = customerId;
		
	}
	
	public Listing() {
	}
	public String getCarMake() {
		return carMake;
	}
	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarYear() {
		return carYear;
	}
	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}
	public int getCarMileage() {
		return carMileage;
	}
	public void setCarMileage(int i) {
		this.carMileage = i;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarCondition() {
		return carCondition;
	}
	public void setCarCondition(String carCondition) {
		this.carCondition = carCondition;
	}
	public int getCarStartBid() {
		return carStartBid;
	}
	public void setCarStartBid(int carStartBid) {
		this.carStartBid = carStartBid;
	}
	public int getCarReservePrice() {
		return carReservePrice;
	}
	public void setCarReservePrice(int carReservePrice) {
		this.carReservePrice = carReservePrice;
	}
	public String getCarDescription() {
		return carDescription;
	}
	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerId() {
		return customerId;
	}

	
	

}
