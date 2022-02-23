/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.dao;

import java.util.List;


public interface IdaoE <T>{
    
     public void insertEquipment();

    public void insertEquipment2(T o);

    public List<T> displayEquipment();

    public boolean updateEquipment(T os);

    public T displayByIdEquipment(int id);

    public void deleteEquipment(T o);

    //public void searchByLocation(String location);
    
    public boolean modifyEquipment(int id,String equipmentName,String purpose,int quantity);
}
