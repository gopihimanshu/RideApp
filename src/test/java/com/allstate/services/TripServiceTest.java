package com.allstate.services;

import com.allstate.entities.Trip;
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

public class TripServiceTest {
    @Autowired
    private TripService service;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTripRecord() throws Exception {
        Trip trip = new Trip();
        trip.setCarId(1);
        trip.setPassengerId(1);
        trip.setDriverId(1);
        trip.setDistance(10);
        trip.setTipsPer(40);
        Trip newTrip = this.service.create(trip);
        assertEquals(10,newTrip.getDistance(),0.1);
    }
}