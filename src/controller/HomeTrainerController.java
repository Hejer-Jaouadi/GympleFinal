/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Trainer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class HomeTrainerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static Trainer trainer;
    @FXML
    private Button button;
    @FXML
    private Circle c;

    public static Trainer getTrainer() {
        return trainer;
    }

    public static void setUser(Trainer trainer) {
        HomeTrainerController.trainer = trainer;
    }
    
    public static Trainer getUser( ){
       return trainer;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       if(trainer.getPicture()==null){
            trainer.setPicture("file:/C:/Users/Asma/Downloads/img.png");
        }
        
         javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(trainer.getPicture()));
       this.c.setFill(p);
       
    }
    @FXML
    private void profile(MouseEvent event) {
         
        Stage stage = (Stage) c.getScene().getWindow();
        //User u=(User)stage.getUserData();
       // System.out.println(u.getId());
        ProfileTrainerController.setUser(trainer);
         Scene scene2 = null;
        
        try {
            
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profileTrainer.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);
    }
    
}
