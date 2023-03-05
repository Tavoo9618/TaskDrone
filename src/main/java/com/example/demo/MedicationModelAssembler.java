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
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class MedicationModelAssembler implements RepresentationModelAssembler<medication, EntityModel<medication>>{
  
  @Override
  public EntityModel<medication> toModel(medication medic) {

    return EntityModel.of(medic, //
        linkTo(methodOn(DistpachController.class).onedron(medic.getDroneid())).withSelfRel(),
        linkTo(methodOn(DistpachController.class).alldrones()).withRel("medication"));
  }
}
