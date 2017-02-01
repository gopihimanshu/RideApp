package com.allstate.repositories;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PassengerRepository extends CrudRepository<Passenger,Integer>{
    public Passenger findByName(String name);

}
