/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controllers;


import com.example.demo.Drone;
import com.example.demo.medication;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author JANIER
 */
//@RestController
public class demoController {
 
    
 
 
    
 @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    
    /* registering drone*/
    @RequestMapping("/a")
     public void RegisteringaDrone (String Serialnumber){
      String validation = paternvalid("[\\w]{1,100}", Serialnumber);
     
    }
    
    /* loading drone with medication items*/
    @RequestMapping("/b")
    public void loadDoWMedItem(String name, String code){
        String validname=paternvalid("[\\w]{1,100}", name);
        String validcode=paternvalid("[\\w]{1,100}", code);
        double weightlimit = 500;
        
    
    }
    
    /* cheking loaaded medication items for a given drone*/
    @RequestMapping("/c")
    public List<medication> chekingLoadMed(Drone d){
    
        List<medication> M = new ArrayList<>();
        return M;
        
    }
    
    /*cheking availables drones for loading*/
    @RequestMapping("/d")
    public List<Drone> chekavaliDronForLoad( List<Drone> dro){
        
    
        List<Drone> d= new ArrayList<>();
        return d;
        
    }
    /*cheking availables drones for loading*/
    @RequestMapping("/batery")
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
