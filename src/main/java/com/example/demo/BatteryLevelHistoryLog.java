/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author JANIER
 */
@Component @EnableScheduling
public class BatteryLevelHistoryLog {
    
    
private static final Logger loge = LoggerFactory.getLogger(BatteryLevelHistoryLog.class); 
   DroneRepository dro;
    public BatteryLevelHistoryLog(DroneRepository dro) {
        this.dro=dro;
    }
 

    
    @Scheduled(fixedRate = 3000, initialDelay = 10000)   
    public void tarea2() {
        for(Drone d: dro.findAll()){
      d.setBateryState((int) (Math.floor(Math.random()*(100-0+1)+0)));
      dro.save(d);
      loge.info(d.toString()); 
        }
        
        
     
    }
   
     
     
     
      
      
      
 
    
}
