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
public class DroneNotFoundException extends RuntimeException{
    
    DroneNotFoundException(Long id) {
    super("Could not find drone " + id);
  }
    
}
