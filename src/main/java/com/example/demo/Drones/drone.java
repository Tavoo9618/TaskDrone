/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Drones;

import java.util.List;

/**
 *
 * @author JANIER
 */
public class drone {

    public int serialnumber;
    public String Model;
    public Double Weightlimit;
    public Double BateryCapacity;
    public String State;
    public List<Medication> Med;

    public drone(int serialnumber, String Model, Double Weightlimit, Double BateryCapacity, String State) {
        this.serialnumber = serialnumber;
        this.Model = Model;
        this.Weightlimit = Weightlimit;
        this.BateryCapacity = BateryCapacity;
        this.State = State;
    }

    public Double getBateryCapacity() {
        return BateryCapacity;
    }

    public String getModel() {
        return Model;
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

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setSerialnumber(int serialnumber) {
        this.serialnumber = serialnumber;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setWeightlimit(Double Weightlimit) {
        this.Weightlimit = Weightlimit;
    }

    public void setMed(List<Medication> Med) {
        this.Med = Med;
    }
    
    

    
    
    
    
   
    
    
    
    
}
