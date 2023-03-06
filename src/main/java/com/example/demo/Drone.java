/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author JANIER
 */
@Entity
public class Drone {
    
    private @Id @GeneratedValue Long Droneid;
    private String serialnumber;
    private Models model;
    private final Double Weightlimit = 500.00;
    private Double BateryCapacity;
    private States states ;
    
    private int bateryState;
    
    Drone() {}

    public Drone(String serialnumber , Double BateryCapacity ,Models model ) {
        this.model=model;
        this.serialnumber = serialnumber;
        this.BateryCapacity = BateryCapacity;
        this.states = States.IDLE;
        this.bateryState=100;
        
    
    }

    public void setStates(States states) {
        this.states = states;
    }

    public void setModel(Models model) {
        this.model = model;
    }
    
    

    public void setDroneid(long Droneid) {
        this.Droneid = Droneid;
    }

    public void setBateryState(int bateryState) {
        this.bateryState = bateryState;
    }
    
    
 
    public void setBateryCapacity(Double BateryCapacity) {
        this.BateryCapacity = BateryCapacity;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

   

    public Long getDroneid() {
        return Droneid;
    }

    public Double getBateryCapacity() {
        return BateryCapacity;
    }

    public int getBateryState() {
        return bateryState;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public Double getWeightlimit() {
        return Weightlimit;
    }

    public String getModel() {
        return model.toString();
    }

    public States getStates() {
        return states;
    }
    
    
     
    

    @Override
    public boolean equals(Object o) {
          if (this == o)
      return true;
    if (!(o instanceof Drone))
      return false;
    Drone drone = (Drone) o;
    return Objects.equals(this.Droneid, drone.Droneid) && Objects.equals(this.serialnumber,drone.serialnumber)
    && Objects.equals(this.states,drone.states)&& Objects.equals(this.BateryCapacity,drone.BateryCapacity)
    && Objects.equals(this.Weightlimit,drone.Weightlimit)&& Objects.equals(this.model,drone.model); 
    
    }

    @Override
    public int hashCode() {
       return Objects.hash(this.Droneid,this.serialnumber,this.model,this.Weightlimit,this.states,this.BateryCapacity,this.bateryState);
    }

    @Override
    public String toString() {
         return "Drone{"+" id:'" + this.Droneid+ '\'' + ", serialnumber :'" + this.serialnumber + '\'' + ",BateryLevel='" +this.bateryState+"%" + '\'' + '}'; 
    }
    
    
      
    
    
}
