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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger loge = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(medicationRepository repomedication,DroneRepository repodrone) {

    return args -> {
     loge.info("Preloading " + repodrone.save(new Drone("1004",100.00 ,Models.Middleweight)));
     loge.info("Preloading " + repodrone.save(new Drone("1003",100.00 ,Models.Cruiserweight)));
     loge.info("Preloading " + repodrone.save(new Drone("1005",100.00 ,Models.Heavyweight)));
     loge.info("Preloading " + repodrone.save(new Drone("1006",100.00 ,Models.Lightweight)));
     loge.info("Preloading " + repomedication.save(new medication("Enalapril",200.00,"AD_12","/images/enalapril.jpg",1)));
     loge.info("Preloading " + repomedication.save(new medication("hidroclorotazida",50.00,"AZ_18","/images/hidrocloro.jpg",1)));
     loge.info("Preloading " + repomedication.save(new medication("Paracetamol",65.00,"AB_31","/images/paracetamol.jpg",2)));
     loge.info("Preloading " + repomedication.save(new medication("Metronidazol",81.00,"HER_32","/images/paracetamol.jpg",3)));
      
      
      
    };
  }
  
  
  
}
