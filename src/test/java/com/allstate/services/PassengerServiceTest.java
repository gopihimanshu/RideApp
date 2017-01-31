package com.allstate.services;

import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
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
public class PassengerServiceTest {

    @Autowired
    private PassengerService service;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreatePassenger() throws Exception {
        Passenger passenger = new Passenger();
        passenger.setName("ABC");
        passenger.setAge(25);
        passenger.setGender(Gender.MALE);
        Passenger passengerAfter = this.service.create(passenger);
        assertEquals(2,passengerAfter.getId());
    }

    @Test
    public void shouldFindCityById() throws Exception {
        Passenger passenger=this.service.findById(1);
        assertEquals("Ram",passenger.getName());
    }

    @Test
    public void shouldFindCityByName() throws Exception {
        Passenger passenger=this.service.findByName("Ram");
        assertEquals(1,passenger.getId());
    }
}