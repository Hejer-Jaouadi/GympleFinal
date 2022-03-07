/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Member;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class MembershipController implements Initializable {
    @FXML
    private Button rnew;
    @FXML
    private Button back;
    @FXML
    private Label start_d;
    @FXML
    private Label exp_d;
    @FXML
    private Label type;
    private static Member member;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.setText(member.getMembership().getType());
        exp_d.setText(member.getMembership().getExpire_date().toString());
        start_d.setText(member.getMembership().getStart_date().toString());
        // TODO
    }    

    @FXML
    private void renew(ActionEvent event) {
         Scene scene2 = null;
        Stage stage = (Stage) back.getScene().getWindow();
        stage.setUserData(member);
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/renewMembership.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);
    }

    @FXML
    private void getBack(ActionEvent event) {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        ProfileController.setUser(member);
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profile.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    public static void setUser(Member u){
        member=u;
    }
    
}
