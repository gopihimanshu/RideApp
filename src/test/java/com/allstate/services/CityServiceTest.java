package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
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
public class CityServiceTest {
    @Autowired
    private CityService service;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateCity() throws Exception {
        City city = new City();
        city.setName("Mysore");
        city.setState("Karnataka");
        city.setRateDay(12.5);
        city.setRateNight(32.6);
        City cityAfter = this.service.create(city);
        assertEquals(2,cityAfter.getId(),0.1);
        assertEquals(12.5,cityAfter.getRateDay(),0.1);

    }

    @Test
    public void shouldFindCityById() throws Exception {
        City city=this.service.findById(1);
        assertEquals("Bangalore",city.getName());
    }

    @Test
    public void shouldFindCityByName() throws Exception {
        City city=this.service.findByName("Bangalore");
        assertEquals(1,city.getId());
    }

    @Test
    @Transactional
    public void shouldReturnListOfPassenger() throws Exception {
        List<Passenger> passengers = this.service.findById(1).getPassengers();
        assertEquals(2,passengers.size());
    }
}