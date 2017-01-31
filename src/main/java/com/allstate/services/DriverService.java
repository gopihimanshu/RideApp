package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    private DriverRepository driverRepository;

    @Autowired
    public void setDriverRepository(DriverRepository driverRepository) { this.driverRepository = driverRepository; }

    public Driver create(Driver driver){ return this.driverRepository.save(driver); }

    public Driver findById(int id) { return this.driverRepository.findOne(id);}

    public Driver findByName(String name){ return this.driverRepository.findByName(name);}
}
