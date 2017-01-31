package com.allstate.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cities")
@Data
public class City {
    private int id;
    private int version;
    private String name;
    private String state;
    private double rateDay;
    private double rateNight;
    private int driverId;//Need to implement the relation
    private Date created;
    private Date modified;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @NotNull
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @NotNull
    public String getState() {return state;}
    public void setState(String state) {this.state = state;}

    @NotNull
    public double getRateDay() {return rateDay;}
    public void setRateDay(double rateDay) {this.rateDay = rateDay;}

    @NotNull
    public double getRateNight() {return rateNight;}
    public void setRateNight(double rateNight) {this.rateNight = rateNight;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}
}
