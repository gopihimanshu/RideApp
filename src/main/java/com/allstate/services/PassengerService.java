package com.allstate.services;

import com.allstate.entities.Passenger;
import com.allstate.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    private PassengerRepository passengerrepository;

    @Autowired
    public void setPassengerrepository(PassengerRepository passengerrepository) {this.passengerrepository = passengerrepository;}

    public Passenger create(Passenger passenger){return this.passengerrepository.save(passenger);}

    public Passenger findById(int id){return this.passengerrepository.findOne(id);}

    public Passenger findByName(String name){return this.passengerrepository.findByName(name);}
}
