package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private CarRepository carRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository) {this.carRepository = carRepository;}

    public Car create(Car car){return this.carRepository.save(car);}

    public Car findById(int id){return this.carRepository.findOne(id);}

    public Car findByName(String name){return this.carRepository.findByName(name);}
}
