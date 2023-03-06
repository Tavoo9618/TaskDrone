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
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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
     private final DroneModelAssembler assembler;
     private final MedicationModelAssembler assemblerm;

    public DistpachController(medicationRepository medicatiorepos, DroneRepository dronerepos,DroneModelAssembler assembler,MedicationModelAssembler assemblerm) {
        this.medicatiorepos = medicatiorepos;
        this.dronerepos = dronerepos;
        this.assembler = assembler;
        this.assemblerm = assemblerm;
    }
   @GetMapping("/medication")
  List<medication> allmedications() {
    return medicatiorepos.findAll();
  }
  
  @GetMapping("/medication/{id}")
  EntityModel<medication> onemedication(@PathVariable long id) {
  medication medic = medicatiorepos.findById(id).orElseThrow(()-> new MedicNotFoundException(id));
  return assemblerm.toModel(medic);
  }
  
  @GetMapping("/drone")
  List<Drone> alldrones() {
    return dronerepos.findAll();
  }
    
  @GetMapping("/drone/{id}")
    EntityModel<Drone> onedron(@PathVariable long id) {
    Drone drone  =  dronerepos.findById(id).orElseThrow(()-> new DroneNotFoundException(id));
    return assembler.toModel(drone);
  } 
    
     /* registering drone*/
    @PostMapping("/drone/add")
     ResponseEntity<?> RegisteringaDrone (@RequestBody Drone newDrone){
      boolean validation = paternvalid("[\\w]{1,100}",String.valueOf(newDrone.getSerialnumber()));
      if(validation){
      EntityModel<Drone> entitymodel = assembler.toModel( dronerepos.save(newDrone));
       
      return ResponseEntity //
      .created(entitymodel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
      .body(entitymodel);
      }else{
      return
              ResponseEntity //
      .status(HttpStatus.METHOD_NOT_ALLOWED) //
      .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
      .body(Problem.create() //
          .withTitle("Method not allowed") //
          .withDetail("serial number 100 charateres max"));
}
      
    }
    
    /* loading drone with medication items*/
    @PostMapping("/drone/medication/add/{id}")
    ResponseEntity<?> loadDoWMedItem(@RequestBody medication newmedication ,@PathVariable long id){
        Drone drone= dronerepos.findById(id).orElseThrow(()-> new DroneNotFoundException(id));
        Double totalweight=0.00;
        Boolean validname=paternvalid("[a-zA-Z0-9_-]", newmedication.getName());
        Boolean validcode=paternvalid("[A-Z0-9_]", newmedication.getCode());
        if((validname && validcode)&&(drone.getStates()==States.IDLE || drone.getStates()==States.LOADING)&& drone.getBateryState()>25){
        for(medication m: medicatiorepos.findAll() ){
        if(m.getDroneid()==id){
        totalweight+=m.getWeight();
        }
        }
        if(totalweight-drone.getWeightlimit()<=0){
         return
       ResponseEntity //
      .status(HttpStatus.METHOD_NOT_ALLOWED) //
      .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
      .body(Problem.create().withTitle("Method not allowed").withDetail("enter one item of lesser weight"));
        }else{
            EntityModel<medication> entitymodel = assemblerm.toModel(medicatiorepos.save(newmedication));
            drone.setStates(States.LOADING);
            dronerepos.save(drone);
        return 
         ResponseEntity //
      .created(entitymodel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
      .body(entitymodel);       
        }
        }
        else{
     return   ResponseEntity //
      .status(HttpStatus.METHOD_NOT_ALLOWED) //
      .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
      .body(Problem.create().withTitle("Method not allowed").withDetail("name or code invalid"));
        } 
          
           
    
    }
    
    /* cheking loaaded medication items for a given drone*/
    @GetMapping("/drone/medication/check/{id}")
    public List<medication> chekingLoadMed(@PathVariable long id){
        Drone drone= dronerepos.findById(id).orElseThrow(()-> new DroneNotFoundException(id));
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
        if((d.getStates()==States.IDLE && d.getBateryState()>25) || (d.getStates()==States.LOADING && d.getBateryState()>25 )){
        D.add(d);
        }
      }
        return D;
        
    }
    
    
    
    
    
    
    
    
     /*check  drone battery level for a given drone*/
    @GetMapping("/drone/batterystatus/{id}")
    public String  chekDroneBatery(@PathVariable long id){
       Drone drone= dronerepos.findById(id).orElseThrow(()-> new DroneNotFoundException(id));
       return String.valueOf(drone.getBateryState()+"%");
        }
    
    
    
    
    
    public Boolean paternvalid(String patern,String phrase){
        
     Pattern pat = Pattern.compile(patern);
     Matcher mat = pat.matcher(phrase);
     return mat.matches();
        
    }
    
}
