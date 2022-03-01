/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class ProfileAdminController implements Initializable {
    @FXML
    private TextField first;
    @FXML
    private TextField last;
    @FXML
    private TextField e;
    @FXML
    private Button nextt;
    @FXML
    private TextField card;
    @FXML
    private Button back;
    @FXML
    private Button cancel2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Stage s=(Stage)(card.getScene().getWindow());
        //User u=(User) s.getUserData();
        // TODO
    }    
    
     private void returnto() {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void next(ActionEvent event) {
    }

    @FXML
    private void getBack(ActionEvent event) {
        this.returnto();
    }

    @FXML
    private void cancel(ActionEvent event) {
        this.returnto();
    }

    @FXML
    private void change(MouseEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/changePassword.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
        
    }
    
}
