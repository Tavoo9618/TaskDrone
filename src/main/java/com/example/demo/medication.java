/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

/**
 *
 * @author JANIER
 */
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class medication {
    private @Id @GeneratedValue Long id;  
    private int Droneid;
    private String Name;
    private Double Weight;
    private String Code ;
    private String image;
    
    medication() {}

    public medication(String Name, Double Weight, String Code, String image, int Droneid) {
        this.Name = Name;
        this.Weight = Weight;
        this.Code = Code;
        this.image = image;
        this.Droneid = Droneid;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getDroneid() {
        return Droneid;
    }

    public Double getWeight() {
        return Weight;
    }

    public String getImage() {
        return image;
    }
    
    public String getCode() {
        return Code;
    }
    
    

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setDroneid(int Droneid) {
        this.Droneid = Droneid;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
         if (this == o)
      return true;
    if (!(o instanceof medication))
      return false;
    medication medic = (medication) o;
    return Objects.equals(this.id, medic.id) && Objects.equals(this.Name, medic.Name)
            && Objects.equals(this.Weight, medic.Weight) && Objects.equals(this.Code, medic.Code)
            && Objects.equals(this.image, medic.image) && Objects.equals(this.Droneid, medic.Droneid);
    }

    @Override
    public int hashCode() {
       return Objects.hash(this.id, this.Name, this.Code,this.image,this.Weight ,this.Droneid);
    }

    @Override
    public String toString() {
        return "medication{" + "id=" + this.id + ", Name='" + this.Name + '\'' + ",Weight='" + this.Weight + '\'' + '}'; 
    }
    
        
    
    
    
}
