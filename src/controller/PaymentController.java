/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MemberDao;
import dao.MembershipDao;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class PaymentController implements Initializable {
    @FXML
    private Button sign;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/signup2.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void sign_me(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Member u = (Member) stage.getUserData();
        MembershipDao mdao=MembershipDao.getInstance();
        MemberDao memdao=MemberDao.getInstance();
        mdao.insert(u.getMembership());
        memdao.insert(u);
        Scene scene=null;
        try {
            stage.setUserData(u);
            scene = new Scene(FXMLLoader.load(getClass().getResource("/view/home.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene);
        
    }
    
}
