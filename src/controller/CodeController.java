/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.Signup2Controller.infoBox;
import dao.CodeDao;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class CodeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField user_code;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getBack(ActionEvent event) {
        Scene scene2=null;
        Stage stageTheLabelBelongs = (Stage) ((Button)event.getSource()).getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                stageTheLabelBelongs.setScene(scene2);
    }
    /*private void sendCode(ActionEvent event) {
        Scene scene2=null;
        Stage stageTheLabelBelongs = (Stage) ((Button)event.getSource()).getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/code.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                stageTheLabelBelongs.setScene(scene2);
    }*/

    @FXML
    private void getCode(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        User u = (User) stage.getUserData();
        CodeDao coded=CodeDao.getInstance();
        Scene scene2=null;
        if(coded.check_code(Integer.parseInt(user_code.getText()),u.getEmail()))
        {
             try {
                stage.setUserData(u);
                scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/home.fxml")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.setScene(scene2);
        } 
        else {
            infoBox("Please Enter Correct Code", "Failed", null);
        }
        
    }
     public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
    
}
