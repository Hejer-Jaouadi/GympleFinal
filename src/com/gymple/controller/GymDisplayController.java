/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.controller;

import com.gymple.entity.Gym;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class GymDisplayController implements Initializable {

    @FXML
    private TextField gymLocation;
    @FXML
    private TextField facilities;
    @FXML
    private ImageView cancel;
    @FXML
    private TextField idG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modify(MouseEvent event) {
        
        String location = gymLocation.getText();
        String facilitiy = facilities.getText();
        
        
    }

    @FXML
    private void delete(MouseEvent event) {
    }

    @FXML
    private void cancel(MouseEvent event) {
        
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    public void setData(int idGym,String location, String facility){
        
        gymLocation.setText("" +location);
        facilities.setText("" +facility);
        idG.setText(""+idGym);
        
       // facilities.setText("facilities : " +facilities);
        
    }

}
