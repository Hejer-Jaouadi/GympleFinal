/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// gym interfaaace 


package com.gymple.dao;

import java.util.List;

public interface Idao<T> {

    public void insertGym();

    public void insertGym2(T o);

    public List<T> displayGym();

    public boolean updateGym(T os);

    public T displayByIdGym(int id);

    public void deleteGym(T o);

    public void searchByLocation(String location);
    
    public boolean modifyGym(int id,String location,String facilities);
}
