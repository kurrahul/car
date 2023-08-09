package com.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.car.assembler.CarAssembler;
import com.car.dto.CarDTO;
import com.car.entity.Car;
import com.car.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarAssembler assembler;

	public CarServiceImpl() {
	        super();
	    }

	public List<CarDTO> getAllCars() {
		//return null;
		List<Car> cars = carRepository.findAll();
		return assembler.toVOs(cars);
	}

	public CarDTO getCarById(String id) {
		//return null;
//		Car car = new Car();
//		car.setId("001");
//		car.setModel("Corolla");
//		car.setYear("2022");
//		return Optional.of(car);
	        
		return assembler.toVO(carRepository.findById(id).get());    
	        
		//return carRepository.findById(id);
	}

	public CarDTO saveCar(CarDTO carDTO) {
		Car car = carRepository.save(assembler.toEntity(carDTO));
		return assembler.toVO(car);
		//return carRepository.save(car);
	}

	public void deleteCar(Long id) {
		//carRepository.deleteById(id);
	}
}
