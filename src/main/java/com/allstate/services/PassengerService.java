package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.repositories.DriverRepository;
import com.allstate.repositories.PassengerRepository;
import com.allstate.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerService {
    private PassengerRepository passengerrepository;
    private DriverRepository driverRepository;

    @Autowired
    public void setPassengerrepository(PassengerRepository passengerrepository) {this.passengerrepository = passengerrepository;}

    @Autowired
    public void setDriverRepository(DriverRepository driverRepository) {this.driverRepository = driverRepository;}

    public Passenger create(Passenger passenger){return this.passengerrepository.save(passenger);}

    public Passenger findById(int id){return this.passengerrepository.findOne(id);}

    public Passenger findByName(String name){return this.passengerrepository.findByName(name);}

    public List<Driver> findListOfDrivers(int id){
        List<Trip> trips= this.passengerrepository.findOne(id).getTrips();
        List<Driver>drivers=trips.stream().map(t -> this.driverRepository.findOne(t.getDriverId())).collect(Collectors.toList());
        return drivers;
    }

}
