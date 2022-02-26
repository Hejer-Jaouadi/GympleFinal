/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.controller;

import com.gymple.dao.GymCrud;
import com.gymple.entity.Gym;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddGymController implements Initializable {

    @FXML
    private TextField locationFi;
    @FXML
    private TextField facilitiesFi;
    @FXML
    private Button AddGym;
    @FXML
    private Button Cancel;
    @FXML
    private Label labelLocation;
    @FXML
    private Label labelFacility;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddGym(MouseEvent event) {
        String location = locationFi.getText();
        String facilities = facilitiesFi.getText();

        /* try{
        if ((location.isEmpty()) || (facilities.isEmpty())) {
        //            /* Alert alert = new Alert(Alert.AlertType.ERROR);
        //            alert.setHeaderText(null);
        //            alert.setContentText("Fill in emty fields");
        //            alert.showAndWait();
        labelLocation.setText("Location is empty");
        labelFacility.setText("Facility is empty");
        } else {
        Gym gym = new Gym(location, facilities);
        GymCrud gc = GymCrud.getInstance();
        gc.insertGym2(gym);
        }
        }catch(RuntimeException e)
        {
        labelLocation.setText("Location is empty");
        labelFacility.setText("Facility is empty");
        }
        catch(Exception e){
        labelLocation.setText("Error");
        }*/
        if ((location.isEmpty()) || (facilities.isEmpty())) {
            if (locationFi.getText().length() == 0) {
                locationFi.setStyle("-fx-boodr-color: red ; -fx-border-width: 2px;");
                new animatefx.animation.Shake(locationFi).play();
                labelLocation.setText("Location is empty");
            } else {
                facilitiesFi.setStyle(null);
            }
            if (facilitiesFi.getText().length() == 0) {
                facilitiesFi.setStyle("-fx-boodr-color: red ; -fx-border-width: 2px;");
                new animatefx.animation.Shake(facilitiesFi).play();
                labelFacility.setText("Facility is empty");
            } else {
                facilitiesFi.setStyle(null);
            }
        } else {
            Gym gym = new Gym(location, facilities);
            GymCrud gc = GymCrud.getInstance();
            gc.insertGym2(gym);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        }

    }

    @FXML
    private void Cancel(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
