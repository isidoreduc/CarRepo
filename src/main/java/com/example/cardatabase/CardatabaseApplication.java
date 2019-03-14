package com.example.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.CarRepository;
import com.example.cardatabase.domain.Owner;
import com.example.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication {
	// edit the level of logging in resources>application.properties file
	public static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	// inject the CarRepository to be able to use it's CRUD methods
	@Autowired
	public CarRepository repo;
	@Autowired
	public OwnerRepository orepo;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("App just started - log it");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			// Add owner objects and save these to db
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			orepo.save(owner1);
			orepo.save(owner2);

			// Add car object with link to owners and save these to db.
			Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			repo.save(car);
			car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			repo.save(car);
			car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			repo.save(car);
			repo.save(new Car( "Ferrari", "Testarossa", "red", "ADF-9288", 2011, 100000, owner1));
			repo.save(new Car( "Jaguar", "Frontano", "blue", "ADF-92008", 2015, 100000, owner1));
			repo.save(new Car( "Mercedes", "CLK", "white", "ADF-973288", 2010, 100000, owner1));
			repo.save(new Car( "Dacia", "Duster", "kaki", "ADF-9788", 2019, 100000, owner2));

		};
	};

}
