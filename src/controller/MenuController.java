/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class MenuController implements Initializable {

    @FXML
    private Button gymManagement;
    @FXML
    private Button roomManagement;
    @FXML
    private Button Close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gymManagement(MouseEvent event) {
         try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/view/Gym.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void RoomManagement(MouseEvent event) {
         try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/view/Room.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void CloseTab(MouseEvent event) {
      Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) Close.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
