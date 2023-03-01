/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Drones;

/**
 *
 * @author JANIER
 */
public class Medication {
  
    public String Name;
    public Double Weight;
    public int Code ;
    public String image;

    public Medication(String Name, Double Weight, int Code, String image) {
        this.Name = Name;
        this.Weight = Weight;
        this.Code = Code;
        this.image = image;
    }

    public int getCode() {
        return Code;
    }

    public String getImage() {
        return image;
    }

    public Double getWeight() {
        return Weight;
    }

    public String getName() {
        return Name;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setWeight(Double Weight) {
        this.Weight = Weight;
    }
    
    
    
    
   
    
}
