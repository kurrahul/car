package com.car.service;

import java.util.List;
import java.util.Optional;

import com.car.dto.CarDTO;


public interface CarService {

	public List<CarDTO> getAllCars();

	public CarDTO getCarById(String id);

	public CarDTO saveCar(CarDTO carDTO);

	public void deleteCar(Long id);
}
