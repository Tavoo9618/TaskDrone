/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Drones;

import java.util.List;
import java.util.regex.*;


/**
 *
 * @author JANIER
 */
public class drone {

    public int serialnumber;
    public List<Medication> lismedication;

    /**
     *
     */
    public enum Model { Lightweiht, Middleweight,Cruiserwight,Heavyweight} 
    public Double Weightlimit;
    public Double BateryCapacity;
    public enum State { Lightweiht, Middleweight,Cruiserwight,Heavyweight}
    public List<Medication> Med;
    public String bateryState;

    public drone(int serialnumber, String Model, Double Weightlimit, Double BateryCapacity, String State) {
        this.serialnumber = serialnumber;
        this.Weightlimit = Weightlimit;
        this.BateryCapacity = BateryCapacity;
        
    
    }

    public String getBateryState() {
        return bateryState;
    }

    
    
    

    public Double getBateryCapacity() {
        return BateryCapacity;
    }

   

    public int getSerialnumber() {
        return serialnumber;
    }

    public Double getWeightlimit() {
        return Weightlimit;
    }
    
    public List<Medication> getMed() {
        return Med;
    }

    public void setBateryCapacity(Double BateryCapacity) {
        this.BateryCapacity = BateryCapacity;
    }

    

    public void setSerialnumber(int serialnumber) {
        this.serialnumber = serialnumber;
    }

   

    public void setWeightlimit(Double Weightlimit) {
        this.Weightlimit = Weightlimit;
    }

    public void setMed(List<Medication> Med) {
        this.Med = Med;
    }

    public void setBateryState(String bateryState) {
        this.bateryState = bateryState;
    }
    
    public void setLismedication(List<Medication> lismedication) {
        this.lismedication = lismedication;
    }
    
    
    
    
    
   
    
    
    
    
}
