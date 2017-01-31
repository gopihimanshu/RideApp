package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private CityRepository cityRepository;

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {this.cityRepository = cityRepository;}

    public City create(City city){ return this.cityRepository.save(city);}

    public City findById(int id){ return this.cityRepository.findOne(id);}

    public City findByName(String name){ return this.cityRepository.findByName(name);}
}

