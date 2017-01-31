package com.allstate.repositories;

import com.allstate.entities.Driver;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQuery;
import java.util.List;

public interface DriverRepository extends CrudRepository<Driver,Integer> {
    public Driver findByName(String name);

    String sql="select * from drivers where city_id=:id";
    @Query(value = sql,nativeQuery = true)
    public List<Driver>findByCity(@Param("id") int id);

//    String sql1="select * from drivers d inner join on d.city_id=city c c.id where driver_id=:id";
//    @Query(value = sql1,nativeQuery = true)
//    public List<Driver>findListOfCity(@Param("id") int id);
}
