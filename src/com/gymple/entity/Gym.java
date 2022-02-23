/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.entity;



public class Gym {
    
      private int idG;
      private String location;
      private String facilities;

    public Gym(int idG, String location, String facilities) {
        this.idG = idG;
        this.location = location;
        this.facilities = facilities;
    }

    public Gym(String location, String facilities) {
        this.location = location;
        this.facilities = facilities;
    }

    public Gym() {
        }

    public int getIdG() {
        return idG;
    }

    public String getLocation() {
        return location;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setIdG(int idG) {
        this.idG = idG;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "Gym{" + "idG=" + idG + ", location=" + location + ", facilities=" + facilities + '}'+"\n";
    }
      
      
      
}
