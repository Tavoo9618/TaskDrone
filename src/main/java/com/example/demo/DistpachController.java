/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.media.Media;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JANIER
 */
@RestController
public class DistpachController {
    
     private final medicationRepository medicatiorepos;
     private final DroneRepository dronerepos;

    public DistpachController(medicationRepository medicatiorepos, DroneRepository dronerepos) {
        this.medicatiorepos = medicatiorepos;
        this.dronerepos = dronerepos;
    }
      @GetMapping("/medication")
  List<medication> alla() {
    return medicatiorepos.findAll();
  }
  
  @GetMapping("/drone")
  List<Drone> allo() {
    return dronerepos.findAll();
  }
    
    
    
     /* registering drone*/
    @PostMapping("/drone/add")
     Drone RegisteringaDrone (@RequestBody Drone newDrone){
      String validation = paternvalid("[\\w]{1,100}",String.valueOf(newDrone.getSerialnumber()));
      return dronerepos.save(newDrone);
     
    }
    
    /* loading drone with medication items*/
    @PostMapping("/drone/medication/add/{id}")
    public void loadDoWMedItem(@RequestBody medication newmedication ,@PathVariable int id){
        double weightlimit = 500;
        Double totalweight=0.00;
        String validname=paternvalid("[a-zA-Z0-9_-]", newmedication.getName());
        String validcode=paternvalid("[A-Z0-9_]", newmedication.getCode());
        for(medication m: medicatiorepos.findAll() ){
        if(m.getDroneid()==id){
        totalweight+=m.getWeight();
        }
        }
         
                
        
        
        
    
    }
    
    /* cheking loaaded medication items for a given drone*/
    @GetMapping("/drone/medication/check/{id}")
    public List<medication> chekingLoadMed(@PathVariable int id){
        //validar id
        List<medication> M = new ArrayList<>();
        for(medication m: medicatiorepos.findAll()){
        if(m.getDroneid()==id) 
         M.add(m);
        }
        return M;
        
    }
    
    
     /*cheking availables drones for loading*/
    @GetMapping("/drone/forload")
    public List<Drone> chekavaliDronForLoad(){
      List<Drone> D= new ArrayList<>();   
      for(Drone d:dronerepos.findAll()){
        if(d.getStates()==States.IDLE ||d.getStates()==States.LOADING ){
        D.add(d);
        }
      }
        return D;
        
    }
    
    
    
    
    
    
    
    
    
    @GetMapping("/drone/batterystatus/{id}")
    public String  chekDroneBatery(){
        String B;
    
        int per=(int) (Math.floor(Math.random()*(100-0+1)+0));
        
        return B="batery state:"+String.valueOf(per)+"%";
        }
    
    
    
    
    
    public String paternvalid(String patern,String phrase){
        
     Pattern pat = Pattern.compile(patern);
     Matcher mat = pat.matcher(phrase);
      if (mat.matches()) {
         System.out.println("yes");
     } else {
         System.out.println("NO");                                                                                
     }
        return patern;
    }
    
}
