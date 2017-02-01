package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.enums.Gender;
import com.allstate.exceptions.TransactionMoney;
import com.allstate.repositories.TripRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TripServiceTest {
    @Autowired
    private TripService service;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreateTrip() throws Exception {

        Passenger passenger = new Passenger();
        passenger.setName("Raj");
        passenger.setGender(Gender.MALE);
        passenger.setAge(40);
        passenger.setAmount(50);
        passenger.setAmount(3800);

        Trip trip = new Trip();
        trip.setCreated(new Date());
        trip.setCarId(3);
        trip.setPassenger(passenger);
        trip.setDriverId(2);
        trip.setDistance(15);
        trip.setTipsPer(20);
        Trip newTrip = this.service.create(trip);
        assertEquals(15,newTrip.getDistance(),0.1);
        assertEquals(753,newTrip.getCost(),0.1);
        assertEquals(903.6,newTrip.getTotalCost(),0.2);
    }

    @Test(expected = TransactionMoney.class)
    public void shouldNotCreateTripRecord() throws Exception {

        Passenger passenger = new Passenger();
        passenger.setName("Raj");
        passenger.setGender(Gender.MALE);
        passenger.setAge(40);
        passenger.setAmount(3800);
        Trip trip = new Trip();
        trip.setCreated(new Date());
        trip.setCarId(1);
        trip.setPassenger(passenger);
        trip.setDriverId(1);
        trip.setDistance(10);
        trip.setTipsPer(40);
        Trip newTrip = this.service.create(trip);
        assertEquals(10,newTrip.getDistance(),0.1);
        assertEquals(502.0,newTrip.getCost(),0.2);
        assertEquals(702.8,newTrip.getTotalCost(),0.2);
    }

    @Test
    public void shouldGiveDriverDetails() throws Exception {
        Driver driver=this.service.findDriverBasedOnTrip(1);
        assertEquals(2,driver.getId());
        assertEquals("Himanshu",driver.getName());
    }

    @Test
    public void shouldGiveCarDetails() throws Exception {
        Car car = this.service.findCarBasedOnTrip(1);
        assertEquals(1,car.getId());
        assertEquals("Polo",car.getName());
    }

    @Test
    public void shouldGivePassengerDetails() throws Exception {
        Passenger passenger = this.service.findPassengerBasedOnTrip(2);
        assertEquals(2,passenger.getId());
        assertEquals("Lakshman",passenger.getName());

    }
}