/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.SignupController.infoBox;
import entity.Member;
import entity.Membership;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Control;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class Signup2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    // @FXML
    //Button cancel2,next2;
    @FXML
    private javafx.scene.control.TextField height;
    @FXML
    private javafx.scene.control.TextField weight;
    @FXML
    private ChoiceBox TL;
    @FXML
    private ChoiceBox type;
    @FXML
    private Button cancel2;
    @FXML
    private Button back;
    @FXML
    private Button next2;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        type.setItems(FXCollections.observableArrayList("1 month", "3 months", "1 year")
        );
        TL.setItems(FXCollections.observableArrayList("Beginner", "Intermediate", "Advanced")
        );
    }

    @FXML
    private void next(ActionEvent event) {
        float h, w;
        String period_of_membership, training_level;
        
        Scene scene2 = null;
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Control co=new Control();
        if ((co.trueFloat(height.getText())) && (co.trueFloat(weight.getText())) && (!type.getSelectionModel().isEmpty()) && (!TL.getSelectionModel().isEmpty())) {
        period_of_membership = (String) type.getValue();
        training_level = (String) TL.getValue();    
        h = Float.parseFloat(height.getText());
            w = Float.parseFloat(weight.getText());
            Member u = (Member) stage.getUserData();
            System.out.println(u.getEmail());
            u.setHeight(h);
            u.setWeight(w);
            u.setTraining_level(training_level);
            LocalDate now = LocalDate.now();
            LocalDate exp;
            Period period;
            System.out.println(period_of_membership);
            System.out.println(training_level);
            switch (period_of_membership) {
                case "1 month": {
                    period = Period.of(0, 1, 0);
                    exp = now.plus(period);
                    u.setMembership(new Membership(exp, now, period_of_membership));
                    System.out.println(u.getMembership().getExpire_date().toString());
                    break;
                }

                case "3 months": {
                    period = Period.of(0, 3, 0);
                    exp = now.plus(period);
                    u.setMembership(new Membership(exp, now, period_of_membership));
                    System.out.println(u.getMembership().getExpire_date().toString());
                    break;
                }
                case "1 year": {
                    period = Period.of(1, 0, 0);
                    exp = now.plus(period);
                    u.setMembership(new Membership(exp, now, period_of_membership));
                    System.out.println(u.getMembership().getExpire_date().toString());
                    break;
                }
            }
            try {
                u.setPicture("file:/C:/Users/Asma/Downloads/img.png");
                stage.setUserData(u);
                scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/payment.fxml")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.setScene(scene2);
        } else {
            infoBox("Please Enter Correct Informations", "Failed", null);
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void getBack(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/signup.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

   
    

}
