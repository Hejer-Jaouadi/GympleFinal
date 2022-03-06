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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
    private Button btnProfile;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //getUser data
    }    

    @FXML
    private void coach(MouseEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) res.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/addTrainer.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
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
    private void ManageProduct(MouseEvent event) {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) res.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/ProductsM.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
