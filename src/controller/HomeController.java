/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Member;
import java.io.IOException;
import java.net.URL;
import java.time.temporal.ChronoUnit;
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
import static java.time.temporal.ChronoUnit.DAYS;
import javafx.scene.control.Alert;
/**
 * FXML Controller class
 *
 * @author Asma
 */
public class HomeController implements Initializable {

    @FXML
    private Circle c;
    private static Member user;

    public static Member getUser() {
        return user;
    }
    
    public static int ok=0;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        user.setPicture(null);
        if (user.getPicture() == null) {
            user.setPicture("file:/C:/Users/Yassine/Downloads/img.png");
        }

        javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(user.getPicture()));
        this.c.setFill(p);
        
        if(user.getMembership()!=null){
   
          if(ok==0) {ok=1;
              infoBox("You have "+String.valueOf(user.getMembership().getStart_date().until(user.getMembership().getExpire_date(),ChronoUnit.DAYS))+" days left until your membership expires.", "Failed", null);}
       
       }
    }
    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
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

    public static void setUser(Member u) {
        user = u;
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

    @FXML
    private void gyms(MouseEvent event) {
        Stage stage = (Stage) c.getScene().getWindow();
        Scene scene2 = null;

        try {

            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/FrontGym.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);
    }

    @FXML
    private void showProducts(MouseEvent event) {
        Stage stage = (Stage) c.getScene().getWindow();
        Scene scene2 = null;

        try {

            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/ClientProduct.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);
    }

    @FXML
    private void showReservation(MouseEvent event) {
        Stage stage = (Stage) c.getScene().getWindow();
        Scene scene2 = null;

        try {

            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/Reservations.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);
    }

}
