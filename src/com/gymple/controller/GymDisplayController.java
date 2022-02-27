/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.controller;

import com.gymple.dao.GymCrud;
import com.gymple.entity.Gym;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    private Button cancel;
    @FXML
    private TextField idG;
    @FXML
    private Button modify;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idG.setEditable(false);
    }

    /*@FXML
    private void modify(MouseEvent event) {
       
        
    }*/
    @FXML
    private void delete(MouseEvent event) {
        
         String location = gymLocation.getText();
        String facility = facilities.getText();
        String idGym = idG.getText();
        
         try{
       
             //System.out.println("hejer");
            if ((location.isEmpty()) || (facility.isEmpty())) {
            if (gymLocation.getText().length() == 0) {
                gymLocation.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(gymLocation).play();
                //labelLocation.setText("Location is empty");
            } else {
                gymLocation.setStyle(null);
                
            }
            if (facilities.getText().length() == 0) {
                facilities.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(facilities).play();
                //labelFacility.setText("Facility is empty");
            } else {
                facilities.setStyle(null);
            }
            }else{
            Gym gym = new Gym(location, facility);
            GymCrud gc = GymCrud.getInstance();
            gc.deleteGym(gc.displayByIdGym(idGym));
            
           // GymController g = new GymController();
            
        //GymController g = new GymController();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           // g.loadDate();
            stage.close();
            }
        } catch(Exception ex)
                {
                System.out.println("error : "+ex.getMessage());
                }
        
        

        
        
        
    }

    @FXML
    private void cancel(MouseEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setData(int idGym, String location, String facility) {

        gymLocation.setText("" + location);
        facilities.setText("" + facility);
        idG.setText("" + idGym);
        
        // facilities.setText("facilities : " +facilities);
    }
    
     public void getData() {

        gymLocation.getText();
        facilities.getText();
        idG.getText();
        
        // facilities.setText("facilities : " +facilities);
    }

    @FXML
    private void modify(MouseEvent event) {

        String location = gymLocation.getText();
        String facility = facilities.getText();
         String idGym = idG.getText();
        idG.setEditable(false);
        //Gym gym = new Gym(location, facility);
           
            //gc.updateGym(gym);
        if ((location.isEmpty()) || (facility.isEmpty())) {
            if (gymLocation.getText().length() == 0) {
                gymLocation.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(gymLocation).play();
                //gym.setLocation(Integer.parseInt(gymLocation.getText()));
                //  labelLocation.setText("Location is empty");
            } else {
                gymLocation.setStyle(null);
               // gymLocation.setText(""+gym.setLocation(location));
              //  gym.getLocation();
              // gc.updateGym(gym);
               
            }
            if (facilities.getText().length() == 0) {
                facilities.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(facilities).play();
                // labelFacility.setText("Facility is empty");
            } else {
                facilities.setStyle(null);
               // facilities.setText(""+gym.getFacilities());
                 // gym.getFacilities();  
              // gc.updateGym(gym);
                
                
            }
        } else {
            
            
            // GymCrud gc = GymCrud.getInstance();
           // Gym gym = new Gym();
          // 
             //GymController g = new GymController();
             Gym gym = new Gym(idGym, location, facility);
            GymCrud gc = GymCrud.getInstance();
              //gc.updateGym(new Gym());
              gc.modifyGym(idGym,location,facility);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }

    }

}
