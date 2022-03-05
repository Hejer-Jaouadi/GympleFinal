/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author juzoo
 */
public class ManageController implements Initializable {
    

    @FXML
    private Button btnadd;
    @FXML
    private Button upbtn;
    @FXML
    private Button delbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Addbtin(ActionEvent event) {
          Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) btnadd.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void updatebtn(ActionEvent event) {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) upbtn.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/UpdateProduct.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void deletebtn(ActionEvent event) {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) delbtn.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/DeleteProduct.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
