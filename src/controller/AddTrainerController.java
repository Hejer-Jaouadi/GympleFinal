/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.SignupController.infoBox;
import dao.GymCrud;
import dao.TrainerDao;
import entity.Gym;
import entity.Trainer;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
import utils.SendEmail;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class AddTrainerController implements Initializable {

    @FXML
    private TextField cost;
    @FXML
    private TextField desc;
    @FXML
    private Button add;
    @FXML
    private Button cancel2;
    @FXML
    private TextField first;
    @FXML
    private TextField last;
    @FXML
    private TextField em;
    @FXML
    private TextField exp;
    @FXML
    private Button back;
    @FXML
    private ChoiceBox gym;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GymCrud gc=GymCrud.getInstance();
        gym.setItems(gc.getGyms());
    }

    @FXML
    private void add(ActionEvent event) {
        Control c=new Control();
        if ((c.trueString(first.getText())) && (c.trueString(last.getText()))&& (!gym.getSelectionModel().isEmpty())  && (c.trueEmail(em.getText())) && (c.trueFloat(cost.getText())) && (c.trueString(desc.getText())) && (!exp.getText().isEmpty())) {

            Trainer t = new Trainer();
            t.setCost_per_hour(toFloat(cost.getText()));
            t.setFirst_name(first.getText());
            t.setLast_name(last.getText());
            t.setDescription(desc.getText());
            t.setExperience(exp.getText());
            t.setEmail(em.getText());
            t.setPicture(null);
            Gym g=(Gym)gym.getValue();
            t.setGym(g);
            String pass=c.passwordGenerator();
            t.setPassword(pass);
             SendEmail em=new SendEmail();
            em.SendEmailTrainer(t.getEmail(), "asma.hejaiej@esprit.tn",t.getPassword());
            t.setPassword(c.getHashPassword(pass));
            TrainerDao td = TrainerDao.getInstance();
            td.insert(t);
            this.returnto();
        } else {
            infoBox("Please Enter Correct Informations", "Failed", null);
        }
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    @FXML
    private void cancel(ActionEvent event) {
        first.setText("");
        last.setText("");
        em.setText("");
        cost.setText("");
        exp.setText("");
        desc.setText("");
    }

    private void returnto() {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) add.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/listTrainers.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    public boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public float toFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @FXML
    private void getBack(ActionEvent event) {
        returnto();
    }

}
