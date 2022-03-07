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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Adnene
 */
public class Course_planController implements Initializable {

    @FXML
    private Button cancel;

    @FXML
    private Button planning_menu_btn;
    @FXML
    private Button course_menu_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loadPlan(ActionEvent event) {
        Scene scene4 = null;
        Stage stageTheLabelBelongs = (Stage) course_menu_btn.getScene().getWindow();
        try {
            scene4 = new Scene(FXMLLoader.load(getClass().getResource("/view/plan_days.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene4);

    }

    @FXML
    private void getBack(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void course_menu(ActionEvent event) {

        Scene scene3 = null;
        Stage stageTheLabelBelongs = (Stage) planning_menu_btn.getScene().getWindow();
        try {
            scene3 = new Scene(FXMLLoader.load(getClass().getResource("/view/courseMain.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene3);
    }

}
