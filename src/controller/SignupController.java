/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.FXMLDocumentController.infoBox;
import entity.Member;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Control;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class SignupController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button nextt;
    private Scene scene;
    @FXML
    private javafx.scene.control.TextField first;
    @FXML
    private javafx.scene.control.TextField last;
    @FXML
    private javafx.scene.control.TextField e;
    @FXML
    private javafx.scene.control.TextField card;
    @FXML
    private javafx.scene.control.PasswordField pass1;
    @FXML
    private javafx.scene.control.PasswordField pass2;
    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void next(ActionEvent event) {
        String first_name,last_name,email,password,password2;
        int id_card;
        Control co=new Control();
        if((co.trueString(first.getText()))&&(co.trueString(last.getText()))&&(co.trueEmail(e.getText()))&&(co.truePassword(pass1.getText()))&&(co.trueInt(card.getText()))&&(card.getText().length()==8)&&(pass1.getText().equals(pass2.getText())))
        {
        
        first_name=first.getText();
        last_name=last.getText();
        email=e.getText();
        password=pass1.getText();
        password2=pass2.getText();
           
        id_card=Integer.parseInt(card.getText().toString());
         
        Member u=new Member();
        u.setEmail(email);
        u.setFirst_name(first_name);
        u.setLast_name(last_name);
        u.setPassword(password);
        u.setId_card(id_card);
        
        Scene scene2 = null;
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setUserData(u);
        
         //stage.setUserData(u);
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/signup2.fxml")));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stage.setScene(scene2);}
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
    private void getBack(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
