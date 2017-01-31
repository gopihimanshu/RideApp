package com.allstate.repositories;

import com.allstate.entities.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver,Integer> {
    public Driver findByName(String name);
}
