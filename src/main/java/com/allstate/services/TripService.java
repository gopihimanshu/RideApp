package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
import com.allstate.repositories.CarRepository;
import com.allstate.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TripService {
    private TripRepository tripRepository;

    private CarRepository carRepository;

    @Autowired
    public void setTripRepository(TripRepository tripRepository) {this.tripRepository = tripRepository;}

    @Autowired
    public void setCarRepository(CarRepository carRepository) {this.carRepository = carRepository;}

    public Trip create(Trip trip){
      Driver driver = this.carRepository.findOne(trip.getCarId()).getDriver();
      City city = driver.getCity();
      int additionalCost=this.carRepository.findOne(trip.getCarId()).getAdditionCost();
      double cost =(additionalCost==0)?
                        trip.getDistance()*city.getRateDay():
                        trip.getDistance()*city.getRateDay()+(additionalCost/100);
      trip.setCost(cost);
      double totalCost= (trip.getTipsPer()==0)?cost:cost+(trip.getTipsPer()/100);
      trip.setTotalCost(totalCost);
      return this.tripRepository.save(trip);
    }
}
