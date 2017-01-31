package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.enums.CarType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CarServiceTest {
    @Autowired
    private CarService service;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreateCar() throws Exception{
        Car car = new Car();
        car.setName("Swift");
        car.setYear(2016);
        car.setType(CarType.BASIC);
        Car afterCar=this.service.create(car);
        assertEquals(2,afterCar.getId());
    }
    @Test
    public void shouldCarFindById() throws Exception{
        Car car = this.service.findById(1);
        assertEquals("Polo",car.getName());
    }

    @Test
    public void shouldCarFindByName() throws Exception{
        Car car = this.service.findByName("Polo");
        assertEquals(1,car.getId());
    }

    @Test
    public void shouldFindDriverForACar() throws Exception {
        Driver driver = this.service.findById(1).getDriver();
        assertEquals("Rakesh",driver.getName());
    }
}