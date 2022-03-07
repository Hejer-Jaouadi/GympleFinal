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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class HomeController implements Initializable {

    @FXML
    private ImageView gyms;
    @FXML
    private Button prods;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void getGyms(MouseEvent event) {
         try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/view/FrontGym.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void ClientProduct(MouseEvent event) {
          try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/view/ClientProduct.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
    }

    
}
