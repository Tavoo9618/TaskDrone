/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controllers;

import com.example.demo.Drones.Medication;
import com.example.demo.Drones.drone;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JANIER
 */
@RestController
public class demoController {
    
 @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot2!";
    }
    
    
    /* registering drone*/
    @RequestMapping("/")
     public void RegisteringaDrone ( drone d){
    
    }
    
    /* loading drone with medication items*/
    @RequestMapping("/")
    public void loadDoWMedItem(){
        double weightlimit = 500;
        
    
    }
    
    /* cheking loaaded medication items for a given drone*/
    @RequestMapping("/")
    public List<Medication> chekingLoadMed(drone d){
    
        List<Medication> M = new ArrayList<>();
        return M;
        
    }
    
    /*cheking availables drones for loading*/
    @RequestMapping("/")
    public List<drone> chekavaliDronForLoad( List<drone> dro){
        
    
        List<drone> d= new ArrayList<>();
        return d;
        
    }
    /*cheking availables drones for loading*/
    @RequestMapping("/batery")
    public String  chekDroneBatery(){
        String B;
    
        int per=(int) (Math.floor(Math.random()*(100-0+1)+0));
        
        return B=String.valueOf(per)+"%";
        }
    
}
