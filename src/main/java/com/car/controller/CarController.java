package com.car.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.dto.CarDTO;
import com.car.service.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {

	@Autowired
	private CarService carService;
    
	    public CarController() {
		super();
	}

		@GetMapping
	    public ResponseEntity<List<CarDTO>> getAllCars() {
	        List<CarDTO> cars = carService.getAllCars();
	    	
//	        CarDTO car = new CarDTO();
//	        car.setId("001");
//	        car.setModel("model01");
//	        car.setYear("2023");
//	        List<CarDTO> cars = new ArrayList<>();
//	        cars.add(car);
	        
	        return new ResponseEntity<>(cars, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CarDTO> getCarById(@PathVariable String id) {
	    	CarDTO carDTO = carService.getCarById(id);
	    	return new ResponseEntity<>(carDTO, HttpStatus.OK); 
//	        return carService.getCarById(id)
//	                .map(car -> new ResponseEntity<>(car, HttpStatus.OK))
//	                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PostMapping
	    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO car) {
	        CarDTO savedCar = carService.saveCar(car);
	        
//	        CarDTO savedCar = new CarDTO();
//	        savedCar.setId("001");
//	        savedCar.setModel("Corolla");
//	        savedCar.setYear("2022");
	        
	        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<CarDTO> updateCar(@PathVariable String id, @RequestBody CarDTO car) {
	        car.setId(id);
	        CarDTO updatedCar = carService.saveCar(car);
	        
//	        CarDTO updatedCar = new CarDTO();
//	        updatedCar.setId("001");
//	        updatedCar.setModel("Corolla");
//	        updatedCar.setYear("2022");
	        
	        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
	        carService.deleteCar(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
