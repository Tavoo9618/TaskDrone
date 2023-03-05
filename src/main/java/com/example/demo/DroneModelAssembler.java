/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

/**
 *
 * @author JANIER
 */
@Component
class DroneModelAssembler implements RepresentationModelAssembler<Drone,EntityModel<Drone>> {
    
  @Override
  public EntityModel<Drone> toModel(Drone drone) {

    return EntityModel.of(drone, //
        linkTo(methodOn(DistpachController.class).onedron(drone.getDroneid())).withSelfRel(),
        linkTo(methodOn(DistpachController.class).alldrones()).withRel("employees"));
  }
    
    
}
