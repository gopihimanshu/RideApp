package com.allstate.repositories;


import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends CrudRepository<Car,Integer>{
    public Car findByName(String name);

//    String sql="select * from cars c inner join trips t on c.id=t.car_id where car_id=:id";
//
//    @Query(value = sql,nativeQuery = true)
//    public List<Car> findListOfCars(@Param("id") int id);
}
