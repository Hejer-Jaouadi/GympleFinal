/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.entity;

/**
 *
 * @author Yassine
 */
public class Equipment {
    
   private int idE;
   private String equipmentName;
   private String purpose;
   private int quantity;

    public Equipment(int idE, String equipmentName, String purpose, int quantity) {
        this.idE = idE;
        this.equipmentName = equipmentName;
        this.purpose = purpose;
        this.quantity = quantity;
    }

    public Equipment(String equipmentName, String purpose, int quantity) {
        this.equipmentName = equipmentName;
        this.purpose = purpose;
        this.quantity = quantity;
    }

    public Equipment() {
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Equipment{" + "idE=" + idE + ", equipmentName=" + equipmentName + ", purpose=" + purpose + ", quantity=" + quantity + '}'+"\n";
    }
   
   
    
}
