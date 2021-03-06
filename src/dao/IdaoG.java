/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// gym interfaaace 


package dao;

import entity.Gym;
import java.util.List;
import javafx.collections.ObservableList;

public interface IdaoG<T> {

    public void insertGym();

    public void insertGym2(T o);

    public List<T> displayGym();
public List<T> displayGymwithoutid();
    public boolean updateGym(T os);

    public T displayByIdGym(int id);

    public void deleteGym(T o);

    public void searchByLocation(String location);
    
    public boolean modifyGym(int id,String location,String facilities);
    
    public ObservableList<Integer> ListId();
}
