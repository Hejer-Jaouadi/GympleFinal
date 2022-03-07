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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Adnene
 */
public class HomeAdminController implements Initializable {

    @FXML
    private Button res;
    @FXML
    private Button btnProfile;
    @FXML
    private AnchorPane tip;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void coach(MouseEvent event) {
    }

    @FXML
    private void profile(ActionEvent event) {
    }

    @FXML
    private void Tips(MouseEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) res.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/Tips.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);

    }

    @FXML
    private void courseMain(MouseEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) res.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/course_plan.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

}
