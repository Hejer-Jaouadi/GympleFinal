/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.entity;

import java.util.Objects;
import javafx.scene.control.TableColumn;



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

    public Gym(TableColumn<Gym, String> location, TableColumn<Gym, String> facilities) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idG;
        hash = 47 * hash + Objects.hashCode(this.location);
        hash = 47 * hash + Objects.hashCode(this.facilities);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gym other = (Gym) obj;
        if (this.idG != other.idG) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.facilities, other.facilities)) {
            return false;
        }
        return true;
    }
      
      
      
}
