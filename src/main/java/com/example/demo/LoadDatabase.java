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
     // loge.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
     // loge.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
     loge.info("Preloading " + repodrone.save(new Drone(1004,500.00,100.00 ,Models.Middleweight)));
     loge.info("Preloading " + repodrone.save(new Drone(1003,500.00,100.00 ,Models.Cruiserweight)));
     loge.info("Preloading " + repodrone.save(new Drone(1005,500.00,100.00 ,Models.Heavyweight)));
     loge.info("Preloading " + repodrone.save(new Drone(1006,500.00,100.00 ,Models.Lightweight)));
      loge.info("Preloading " + repomedication.save(new medication("Frodo Baggins",200.00,"AD_12","blues",1)));
      loge.info("Preloading " + repomedication.save(new medication("Frodo Baggins",50.00,"AZ_18","blues",1)));
      loge.info("Preloading " + repomedication.save(new medication("Frodo Baggins",65.00,"AB_31","blues",1)));
      loge.info("Preloading " + repomedication.save(new medication("Frodo Baggins",81.00,"HER_32","blues",1)));
      
      
      
    };
  }
  
}
