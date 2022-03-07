/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import entity.Member;
import entity.Trainer;
import entity.User;
import utils.ConnexionSingleton;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.Control;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private javafx.scene.control.TextField textEmail;

    @FXML
    private PasswordField textPassword;

    Stage dialogStage = new Stage();
    Scene scene, scene2, scene3,scene4;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private Object ConnectionUtil;
    @FXML
    private Button button;
    @FXML
    private Label fgpassword;
    @FXML
    private Label label2;

    public FXMLDocumentController() {
        connection = ConnexionSingleton.getInstance().getCnx();
    }

    private void handleButtonAction(ActionEvent event) {

    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) {
        
        String email = textEmail.getText().toString();
        String password = textPassword.getText().toString();
        Control t=new Control();
        if((t.trueEmail(email))&&(!password.isEmpty())){
        UserDao ud=UserDao.getInstance();
        User u=ud.Login(email, password);
        Scene scene=null;
        if((u!=null))
        {
            Stage stage = (Stage) fgpassword.getScene().getWindow();
            Scene scene2 = null;
            String role=u.getRole();
            switch(role){
                case "member":HomeController.setUser((Member)u);
        
        
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/home.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        break;
                case "trainer":
                    if(((Trainer)u).getBlock().equals("y")){
            infoBox("You are blocked from entering this platform.", "Failed", null);
        }else{
                    HomeTrainerController.setUser((Trainer)u);
                 
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeTrainer.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }}
        break;
                case "admin": HomeAdminController.setUser(u);
         
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }break;
            } stage.setScene(scene2);
            
        }
        
        else{
            infoBox("Please Enter Correct Email and Password", "Failed", null);
        }}
        else{
            infoBox("Please Enter Correct Informations", "Failed", null);
        }
    }

    @FXML
    private void handleMe(javafx.scene.input.MouseEvent event) {
        Stage stageTheLabelBelongs = (Stage) fgpassword.getScene().getWindow();
        try {
            
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/pw.fxml")));
            stage.setScene(scene2);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void handleMe2(javafx.scene.input.MouseEvent event) {
        
        try {
            Stage stage = (Stage) fgpassword.getScene().getWindow();
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/signup.fxml")));
            stage.setScene(scene2);
            stage.show();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
