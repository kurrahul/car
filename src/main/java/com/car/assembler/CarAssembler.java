package com.car.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.car.dto.CarDTO;
import com.car.entity.Car;

@Component
public class CarAssembler {

	public Car toEntity(CarDTO dto) {
		Car car = new Car();
		if(Objects.nonNull(dto)) {
			BeanUtils.copyProperties(dto, car);
		}
		return car;
	}
	
	public CarDTO toVO(Car car) {
		CarDTO carDTO = new CarDTO();
		if(Objects.nonNull(carDTO)) {
			BeanUtils.copyProperties(car, carDTO);
		}
		return carDTO;
	}
	
	public List<CarDTO> toVOs(List<Car> entities) {
		List<CarDTO> carDTOs = new ArrayList<CarDTO>();
		if(!entities.isEmpty()) {
			for(Car car: entities) {
				carDTOs.add(toVO(car));
			}			
		}
		return carDTOs;
	}
	
}
