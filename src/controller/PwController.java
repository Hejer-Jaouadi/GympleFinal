/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.Signup2Controller.infoBox;
import dao.CodeDao;
import entity.Member;
import entity.User;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
public class PwController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField text_email;
    User u;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void getBack(ActionEvent event) {
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
    private void sendCode(javafx.scene.input.MouseEvent event) {
        Scene scene2 = null;
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        User u=new User();
        u.setEmail("");
        if((text_email.getText()!=null)&&(text_email.getText()!="")){
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/code.fxml")));
            int c = ThreadLocalRandom.current().nextInt(1000, 9999 + 1);
            SendEmail em=new SendEmail();
            em.SendEmail(text_email.getText(), "asma.hejaiej@esprit.tn",c);
            CodeDao co=CodeDao.getInstance();
            co.put_code(c,text_email.getText());
            u.setEmail(text_email.getText());
            stage.setUserData(u);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(scene2);}
        else{
            infoBox("Please Enter Your Email", "Failed", null);
        }
    }

    @FXML
    private void receiveData(MouseEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        User user = (User) stage.getUserData();
        System.out.println("pw" + user.getEmail());
        String e = user.getEmail();
        text_email.setText(e);

    }
    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

}
