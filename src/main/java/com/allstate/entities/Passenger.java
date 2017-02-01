package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "passengers")
@Data
public class Passenger {

    private int id;
    private int version;
    private String name;
    private Gender gender;
    private int age;
    private double amount;
    private Date created;
    private Date modified;
    private City city;
    private List<Trip> trips;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    @NotNull
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @NotNull
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Enumerated(EnumType.STRING)
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = gender;}

    @NotNull
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}

    @ManyToOne
    @JoinColumn(name="city_id")
    public City getCity() {return city;}
    public void setCity(City city) {this.city = city;}

    @OneToMany(mappedBy = "passenger")
    @JsonIgnore
    public List<Trip> getTrips() {return trips;}
    public void setTrips(List<Trip> trips) {this.trips = trips;}

}
