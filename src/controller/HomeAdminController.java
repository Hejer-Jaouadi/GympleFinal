/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Member;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
public class HomeAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button res;

    @FXML
    private Circle c;
    private static User user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (user.getPicture() == null) {
            user.setPicture("file:/C:/Users/Asma/Downloads/img.png");
        }

        javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(user.getPicture()));
        this.c.setFill(p);
    }

    public static void setUser(User u) {
        user = u;
        System.out.println(u.getEmail());
        // first.setText(user.getFirst_name());
        //last.setText(user.getLast_name());
        //e.setText(user.getEmail());
    }

    public static User getUser() {
        return user;
    }

    @FXML
    private void coach(MouseEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) res.getScene().getWindow();
        try {
            //scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/addTrainer.fxml")));
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/listTrainers.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    /* @FXML
    private void profile(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        //stage.setUserData(u);
        Scene scene2=null;
         try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profileAdmin.fxml")));
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
        }
        stage.setScene(scene2);
    }*/
    @FXML
    private void profile(MouseEvent event) {

        Stage stage = (Stage) res.getScene().getWindow();
        //User u=(User)stage.getUserData();
        // System.out.println(u.getId());
        ProfileAdminController.setUser(user);
        Scene scene2 = null;

        try {

            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profileAdmin.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);
    }

    @FXML
    private void getGyms(MouseEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) res.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/Menu.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void members(MouseEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) res.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/listMembers.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void weather(MouseEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) res.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/agenda.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

}
