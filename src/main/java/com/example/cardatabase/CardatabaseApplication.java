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

@SpringBootApplication
public class CardatabaseApplication {
	// edit the level of logging in resources>application.properties file
	public static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	// inject the CarRepository to be able to use it's CRUD methods
	@Autowired
	public CarRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("App just started - log it");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			repo.save(
					new Car("red", "Ferrari", "Testarossa", "ADF-9288", 2011, 100000, "An incredible force of nature"));
			repo.save(
					new Car("blue", "Jaguar", "Frontano", "ADF-92008", 2015, 100000, "An absolute force of nature"));
			repo.save(
					new Car("white", "Mercedes", "CLK", "ADF-973288", 2010, 100000, "An incredible stylish car for your business"));

		};

	}
}
