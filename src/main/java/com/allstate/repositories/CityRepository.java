package com.allstate.repositories;


import com.allstate.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City,Integer>{
    public City findByName(String name);
}
