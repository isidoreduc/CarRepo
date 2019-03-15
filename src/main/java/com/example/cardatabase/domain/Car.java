package com.example.cardatabase.domain;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private long id;
	private String color, brand, model, registerNumber;
	private int year, price;
//		//in case we wanna use other name than field default 
//		// and more in-depth column settings (nullable, length)
//	@Column(name="desc", nullable=false, length=512)
//	private String description;
	
	public Car() {}
	
	public Car(String brand, String model, String color, String registerNumber, int year, int price,
				Owner owner) {
			this.brand = brand;
			this.model = model;
			this.color = color;
			this.registerNumber = registerNumber;
			this.year = year;
			this.price = price;
			this.owner = owner;
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
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
	
	// marking many-one rel: many cars one owner
	@ManyToOne(fetch = FetchType.EAGER) //can also fetch EAGER
    @JoinColumn(name = "owner")
    private Owner owner;

    //Getter and setter
    public Owner getOwner() {
      return owner;
    }

    public void setOwner(Owner owner) {
      this.owner = owner;
    }

}
