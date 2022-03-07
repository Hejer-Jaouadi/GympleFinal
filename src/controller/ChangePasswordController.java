/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ProfileAdminController.infoBox;
import static controller.SignupController.infoBox;
import dao.UserDao;
import entity.Member;
import entity.Trainer;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.Control;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class ChangePasswordController implements Initializable {
    @FXML
    private Button next2;
    @FXML
    private Button cancel2;
    @FXML
    private Button back;
    @FXML
    private PasswordField pass1;
    @FXML
    private PasswordField pass2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private User u;

    @FXML
    private void next(ActionEvent event) {
        Control co=new Control();
        System.out.println(co.truePassword(pass1.getText()));
        System.out.println((pass1.getText()).equals(pass2.getText()));
        if((co.truePassword(pass1.getText()))&&((pass1.getText()).equals(pass2.getText()))){
            Scene scene2 = null;
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        u = (User) stage.getUserData();
        
        u.setPassword(pass1.getText());
        UserDao ud=UserDao.getInstance();
                ud.update(u);
                switch(u.getRole()){
                    case "admin":
                        ProfileAdminController.setUser(u);
                        break;
                        case "trainer":
                        ProfileTrainerController.setUser((Trainer)u);
                        break;
                            case "member":
                        ProfileController.setUser((Member)u);
                }
                
                returnto();
        }
        else{
           infoBox("Please Enter Correct Informations : \n Password must contain : \n at least one digit [0-9].\n" +
"at least one lowercase Latin character [a-z].\n" +
"at least one uppercase Latin character [A-Z].\n" +
"at least one special character like ! @ # & ( ).\n" +
"Password must contain a length of at least 8 characters and a maximum of 20 characters.", "Failed", null);
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
    private void cancel(ActionEvent event) {
        pass1.setText("");
        pass2.setText("");
    }

    @FXML
    private void getBack(ActionEvent event) {
        this.returnto();
    }
    private void returnto() {
        Stage stage = (Stage) cancel2.getScene().getWindow();
        User u=(User) stage.getUserData();
        Scene scene2=null;
        switch(u.getRole()){
                case "member":
        
        
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profile.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        break;
                case "trainer": HomeTrainerController.setUser((Trainer)u);
                 
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profileTrainer.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        break;
                case "admin": HomeAdminController.setUser(u);
         
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profileAdmin.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }break;
            } stage.setScene(scene2);
    
}}
