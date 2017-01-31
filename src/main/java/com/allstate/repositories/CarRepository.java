package com.allstate.repositories;


import com.allstate.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Integer>{
    public Car findByName(String name);
}
