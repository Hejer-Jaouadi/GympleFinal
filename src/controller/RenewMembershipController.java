/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ProfileController.infoBox;
import dao.MemberDao;
import dao.MembershipDao;
import entity.Member;
import entity.Membership;
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
public class RenewMembershipController implements Initializable {
    @FXML
    private Button go;
    @FXML
    private Button cancel2;
    @FXML
    private ChoiceBox type;
    @FXML
    private Button back;
    @FXML
    private TextField card;
    @FXML
    private TextField pin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         type.setItems(FXCollections.observableArrayList("1 month", "3 months", "1 year")
        );
         
    }    
    @FXML
    private void pay(ActionEvent event) {
         Scene scene2 = null;
        Stage stage = (Stage) back.getScene().getWindow();
        Member m=(Member) stage.getUserData();
        Control co=new Control();
        if((!type.getSelectionModel().isEmpty())&&(co.trueInt(card.getText()))&&(co.trueInt(pin.getText()))){
        String period_of_membership = (String) type.getValue();
        LocalDate now = LocalDate.now();
            LocalDate exp;
            Period period;
            switch (period_of_membership) {
                case "1 month": {
                    period = Period.of(0, 1, 0);
                    exp = now.plus(period);
                    m.setMembership(new Membership(exp, now, period_of_membership));
                    break;
                }

                case "3 months": {
                    period = Period.of(0, 3, 0);
                    exp = now.plus(period);
                    m.setMembership(new Membership(exp, now, period_of_membership));
                    break;
                }
                case "1 year": {
                    period = Period.of(1, 0, 0);
                    exp = now.plus(period);
                    m.setMembership(new Membership(exp, now, period_of_membership));
                    break;
                }}
            MembershipDao md=MembershipDao.getInstance();
            md.update(m.getMembership());
          
        ProfileController.setUser(m);
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/profile.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);}
         else {
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
    private void getBack(ActionEvent event) {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/membership.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
