package com.example.cardatabase.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private long id;
	private String color, brand, model, registerNumber;
	private int year, price;
		//in case we wanna use other name than field default 
		// and more in-depth column settings (nullable, length)
	@Column(name="desc", nullable=false, length=512)
	private String description;
	
	public Car() {}
	
	public Car(String color, String brand, String model, String registerNumber, int year, int price,
				String description) {
			super();
			this.color = color;
			this.brand = brand;
			this.model = model;
			this.registerNumber = registerNumber;
			this.year = year;
			this.price = price;
			this.description = description;
		}
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
