/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.SignupController.infoBox;
import dao.UserDao;
import entity.User;
import java.awt.Paint;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import utils.Control;
import utils.HandleImage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class ProfileAdminController implements Initializable {
    @FXML
    private TextField first;
    @FXML
    private TextField last;
    @FXML
    private TextField e;
    @FXML
    private Button nextt;
    @FXML
    private TextField card;
    @FXML
    private Button back;
    @FXML
    private Button cancel2;
  
    @FXML
    private Pane my_pane;
    @FXML
    private Circle c;
    private static User user;
    private String img="";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       img=user.getPicture();
        first.setText(user.getFirst_name());
        last.setText(user.getLast_name());
        e.setText(user.getEmail());
        //Circle clip=new Circle();
        //clip.setRadius(100);
        
        javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(img));
       this.c.setFill(p);
        System.out.println(user.getPicture());
        
        
        // TODO
    }   
   
    public static void setUser(User u){
        user=u;

    }
    
     private void returnto() {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void next(ActionEvent event) {
        Control co=new Control();
        if((co.trueString(first.getText()))&&(co.trueString(last.getText()))&&(co.trueEmail(e.getText())))
        {user.setFirst_name(first.getText());
        user.setLast_name(last.getText());
        user.setEmail(e.getText());
        user.setPicture(img);
        UserDao ud=UserDao.getInstance();
                ud.update(user);
        this.returnto();}
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
        this.returnto();
    }

    @FXML
    private void cancel(ActionEvent event) {
        first.setText(user.getFirst_name());
        last.setText(user.getLast_name());
        e.setText(user.getEmail());
        javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(user.getPicture()));
       this.c.setFill(p);
        
        
    }

    @FXML
    private void change(MouseEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        stageTheLabelBelongs.setUserData(user);
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/changePassword.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
        
    }
    @FXML
    private void upload(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        HandleImage hi=new HandleImage();
        img=hi.selectImage(stageTheLabelBelongs);
        if(img.contains(".png")||img.contains(".jpg")||img.contains(".jpeg"))
        {javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(img));
       this.c.setFill(p);}
        else {
            infoBox("Please select a picture.", "Failed", null);
        }
        
    }
    @FXML
    private void logout(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
