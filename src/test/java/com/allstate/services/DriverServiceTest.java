package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class DriverServiceTest {

    @Autowired
    private DriverService service;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreateDriver() throws Exception {
        Driver driver = new Driver();
        driver.setName("Himanshu");
        driver.setAge(25);
        driver.setGender(Gender.MALE);
        Driver driverAfter = this.service.create(driver);
        assertEquals(3,driverAfter.getId());
    }

    @Test
    public void shouldFindCityById() throws Exception {
        Driver driver=this.service.findById(1);
        assertEquals("Rakesh",driver.getName());
    }

    @Test
    public void shouldFindCityByName() throws Exception {
        List<Driver> drivers=this.service.findByCity(1);
        assertEquals(2,drivers.size());
    }

    @Test
    @Transactional
    public void shouldFindCarOwnedByDriver() throws Exception {
        List<Car> cars = this.service.findById(1).getCars();
        assertEquals(2,cars.size());
    }
//    @Test
//    @Transactional
//    public void shouldGetAllTheTripsRelatedToCar() throws Exception {
//        List<Trip> trip = this.service.findById(1).getTrips();
//        assertEquals(1,trip.size());
//    }

}