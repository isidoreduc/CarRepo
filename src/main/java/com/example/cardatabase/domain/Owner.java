package com.example.cardatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ownerId;
	private String firstname, lastname;

	public Owner() {
	}

	public Owner(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		
	}

	

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	// marking one to many rel: one owner many cars
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@JsonIgnore //helps with serialization process, avoiding an infinite 
				//	loop of serialization (a car is serialized, that has an owned, which 
				//	is serialized, but that owner has a car, which is serialized and so on)
	private List<Car> cars;

	// Getter and setter
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}