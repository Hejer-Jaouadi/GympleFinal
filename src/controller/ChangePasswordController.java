/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.stage.Stage;

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
    private TextField pass1;
    @FXML
    private TextField pass2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void next(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
        this.returnto();
    }

    @FXML
    private void getBack(ActionEvent event) {
        this.returnto();
    }
    private void returnto() {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profileAdmin.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
