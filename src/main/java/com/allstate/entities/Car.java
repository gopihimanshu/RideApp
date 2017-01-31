package com.allstate.entities;

import com.allstate.enums.CarType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cars")

public class Car {
    private int id;
    private int version;
    private String name;
    private String make;
    private String model;
    private int year;
    private CarType type;
    private int additionCost;
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
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}

    @Enumerated(EnumType.STRING)
    @NotNull
    public CarType getType() {return type;}
    public void setType(CarType type) {this.type = type;}

    @Column(name = "additional_cost")
    public int getAdditionCost() {return additionCost;}
    public void setAdditionCost(int additionCost) {this.additionCost = additionCost;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}
}
