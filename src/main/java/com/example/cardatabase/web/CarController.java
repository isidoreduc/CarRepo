package com.example.cardatabase.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardatabase.domain.Car;
import com.example.cardatabase.domain.CarRepository;

/**
 * 
 * @author raspi
 * Controller only needed if you don't use the easier, much
 * more convenient Spring Data Rest functionality
 */

@RestController
public class CarController {
	private CarRepository repo;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {return repo.findAll();}
}
