/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.SignupController.infoBox;
import dao.TrainerDao;
import entity.Gym;
import entity.Trainer;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void add(ActionEvent event) {
        if ((!first.getText().isEmpty()) && (!last.getText().isEmpty()) && (!em.getText().isEmpty()) && (!cost.getText().isEmpty()) && (!desc.getText().isEmpty()) && (!exp.getText().isEmpty()) && (isNumeric(cost.getText()))) {

            Trainer t = new Trainer();
            t.setCost_per_hour(toFloat(cost.getText()));
            t.setFirst_name(first.getText());
            t.setLast_name(last.getText());
            t.setDescription(desc.getText());
            t.setExperience(exp.getText());
            t.setEmail(em.getText());
            t.setGym(new Gym(1, "ok", "ok"));
            t.setPassword(new Random().ints(10, 33, 122).collect(StringBuilder::new,
                    StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString());
            TrainerDao td = TrainerDao.getInstance();
            td.insert(t);
            SendEmail em=new SendEmail();
            em.SendEmailTrainer(t.getEmail(), "asma.hejaiej@esprit.tn",t.getPassword());
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
        this.returnto();
    }

    private void returnto() {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) add.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
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

}
