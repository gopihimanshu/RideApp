package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "trips")
@Data
public class Trip {
    private int id;
    private int version;
    private Date start;
    private Date end;
    private int totalTime;
    private int carId ;
    private int driverId;
    private double distance;
    private double cost;
    private double tipsPer;
    private double totalCost ;
    private Date created;
    private Date modified;
    private Passenger passenger;
//    private List<Driver> drivers;
//    private List<Car> cars;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @NotNull
    @Column(name = "total_time")
    public int getTotalTime() {return totalTime;}
    public void setTotalTime(int totalTime) {this.totalTime = totalTime;}

    @NotNull
    @Column(name = "car_id")
    public int getCarId() {return carId;}
    public void setCarId(int carId) {this.carId = carId;}

    @Column(name = "tips_per")
    public double getTipsPer() {return tipsPer;}
    public void setTipsPer(double tipsPer) {this.tipsPer = tipsPer;}

    @Column(name = "total_cost")
    public double getTotalCost() {return totalCost;}
    public void setTotalCost(double totalCost) {this.totalCost = totalCost;}

    @Column(name = "driver_id")
    public int getDriverId() {return driverId;}
    public void setDriverId(int driverId) {this.driverId = driverId;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}

    @ManyToOne
    @JoinColumn(name="passenger_id")
    public Passenger getPassenger() {return passenger;}
    public void setPassenger(Passenger passenger) {this.passenger = passenger;}


//
//    @ManyToMany
//    @JoinTable(name = "trips",
//            joinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"))
//    @JsonIgnore
//    public List<Driver> getDrivers() {return drivers;}
//    public void setDrivers(List<Driver> drivers) {this.drivers = drivers;}

//    @ManyToMany
//    @JoinTable(name = "trips",
//            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
//    @JsonIgnore
//    public List<Car> getCars() {return cars;}
//    public void setCars(List<Car> cars) {this.cars = cars;}
}
