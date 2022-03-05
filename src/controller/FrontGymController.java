/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GymCrud;
import entity.Gym;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;



public class FrontGymController implements Initializable {

    @FXML
    private ListView<Gym> listgym;
    ObservableList<Gym> GymList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        GymCrud g = GymCrud.getInstance();
        listgym.setItems(GymList);
        GymList.addAll(g.displayGym());
       g.displayGym();
        
        listgym.setItems(GymList);
        // TODO
        
    }    
    
}
