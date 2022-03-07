/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Member;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
public class HomeController implements Initializable {
    @FXML
    private Circle c;
    private static Member user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(user.getPicture()==null){
            user.setPicture("file:/C:/Users/Asma/Downloads/img.png");
        }
        
         javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(user.getPicture()));
       this.c.setFill(p);
    }

    @FXML
    private void profile(MouseEvent event) {
          
 Stage stage = (Stage) c.getScene().getWindow();
        //User u=(User)stage.getUserData();
       // System.out.println(u.getId());
        ProfileController.setUser(user);
         Scene scene2 = null;
        
        try {
            
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profile.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);
    }
     public static void setUser(Member u){
        user=u;
        System.out.println(u.getEmail());
       // first.setText(user.getFirst_name());
        //last.setText(user.getLast_name());
        //e.setText(user.getEmail());
    }

    @FXML
    private void showTrainers(MouseEvent event) {
                
 Stage stage = (Stage) c.getScene().getWindow();
         Scene scene2 = null;
        
        try {
            
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/showAllTrainers.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);
    }


}
