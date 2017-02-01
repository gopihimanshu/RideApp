package com.allstate.services;

import com.allstate.entities.*;
import com.allstate.exceptions.TransactionMoney;
import com.allstate.repositories.CarRepository;
import com.allstate.repositories.DriverRepository;
import com.allstate.repositories.PassengerRepository;
import com.allstate.repositories.TripRepository;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class TripService {
    private TripRepository tripRepository;

    private DriverRepository driverRepository;

    private CarRepository carRepository;

    private PassengerRepository passengerRepository;

    @Autowired
    public void setTripRepository(TripRepository tripRepository) {this.tripRepository = tripRepository;}

    @Autowired
    public void setDriverRepository(DriverRepository driverRepository) {this.driverRepository = driverRepository;}

    @Autowired
    public void setCarRepository(CarRepository carRepository) {this.carRepository = carRepository;}

    @Autowired
    public void setPassengerRepository(PassengerRepository passengerRepository) {this.passengerRepository = passengerRepository;}

    public Trip create(Trip trip) throws TransactionMoney {
        Passenger passenger=this.passengerRepository.findOne(trip.getPassenger().getId());
        City city = this.driverRepository.findOne(trip.getDriverId()).getCity();
        List<Car> cars=this.driverRepository.findOne(trip.getDriverId()).getCars();
        int additionalCost=this.carRepository.findOne(trip.getCarId()).getAdditionCost();
        double ratePerKm=0;

        SimpleDateFormat sfdate = new SimpleDateFormat("a");
        if((sfdate.format(trip.getCreated())).equals("AM"))
            ratePerKm=city.getRateDay();
        else
            ratePerKm=city.getRateNight();

        double cost =(additionalCost==0)?
                        trip.getDistance()*ratePerKm:
                        trip.getDistance()*ratePerKm+(additionalCost/100);
        if(passenger.getAmount()>=cost) {
            trip.setCost(cost);
            double totalCost = (trip.getTipsPer() == 0) ? cost : cost + (cost * (trip.getTipsPer() / 100));
            trip.setTotalCost(totalCost);
            double amoutDetucted=passenger.getAmount()-totalCost;
            passenger.setAmount(amoutDetucted);
            this.passengerRepository.save(passenger);
            return this.tripRepository.save(trip);
        }
        else{
            throw new TransactionMoney("In-sufficient Fund cannot continue ur ride booking");
        }
    }

    public Driver findDriverBasedOnTrip(int id){return this.driverRepository.findOne(this.tripRepository.findOne(id).getDriverId()); }

    public Car findCarBasedOnTrip(int id){ return this.carRepository.findOne(this.tripRepository.findOne(id).getCarId());}

    public Passenger findPassengerBasedOnTrip(int id){ return this.passengerRepository.findOne(this.tripRepository.findOne(id).getPassenger().getId());}
}
