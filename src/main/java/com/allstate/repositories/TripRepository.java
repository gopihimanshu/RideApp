package com.allstate.repositories;

import com.allstate.entities.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip,Integer>{
}
