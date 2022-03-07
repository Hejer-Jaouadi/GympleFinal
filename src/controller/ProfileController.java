/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import static controller.ProfileAdminController.infoBox;
import dao.MemberDao;
import dao.TrainerDao;
import entity.Member;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import utils.Control;
import utils.HandleImage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class ProfileController implements Initializable {
    @FXML
    private TextField first;
    @FXML
    private TextField last;
    @FXML
    private TextField em;
    @FXML
    private Button saved;
    @FXML
    private Button back;
    @FXML
    private Button cancel2;
    @FXML
    private TextField idCard;
    @FXML
    private TextField height;
    @FXML
    private Button nextt1;
    @FXML
    private Circle c;
    @FXML
    private TextField weight;
    @FXML
    private ChoiceBox TL;
    @FXML
    private Button memb;
    private static Member user;
    private String img="";
    @FXML
    private Button saved1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        img=user.getPicture();
        first.setText(user.getFirst_name());
        last.setText(user.getLast_name());
        em.setText(user.getEmail());
        height.setText(Float.toString(user.getHeight()));
        weight.setText(Float.toString(user.getWeight()));
        TL.setItems(FXCollections.observableArrayList("Beginner", "Intermediate", "Advanced"));
       // System.out.println(user.getTraining_level());
        TL.setValue(user.getTraining_level());
        idCard.setText(Integer.toString(user.getId_card()));
        //Circle clip=new Circle();
        //clip.setRadius(100);
        
        javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(img));
       this.c.setFill(p);
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) {
        Control co=new Control();
         if((co.trueString(first.getText()))&&(co.trueString(last.getText()))&&(co.trueEmail(em.getText()))&&(co.trueFloat(height.getText()))&&(co.trueFloat(weight.getText()))&&(!TL.getSelectionModel().isEmpty())&&(co.trueInt(idCard.getText()))&&(idCard.getText().length()==8))
        {
        user.setFirst_name(first.getText());
        user.setLast_name(last.getText());
        user.setEmail(em.getText());
        user.setPicture(img);
        user.setTraining_level(TL.getValue().toString());
        user.setHeight(Float.parseFloat(height.getText()));
        user.setWeight(Float.parseFloat(weight.getText()));
        user.setId_card(Integer.parseInt(idCard.getText()));
        //user.setGym();
        
        MemberDao ud=MemberDao.getInstance();
                ud.update(user);
        this.returnto();}
        else {
            infoBox("Please Enter Correct Informations", "Failed", null);
        }
    }

    @FXML
    private void getBack(ActionEvent event) {
        this.returnto();
    }
    
    private void returnto(){
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/home.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void cancel(ActionEvent event) {
       first.setText(user.getFirst_name());
        last.setText(user.getLast_name());
        em.setText(user.getEmail());
        height.setText(Float.toString(user.getHeight()));
        weight.setText(Float.toString(user.getWeight()));
        TL.setValue(user.getMembership().getType());
        idCard.setText(Integer.toString(user.getId_card()));
         javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(user.getPicture()));
       this.c.setFill(p);
    }

    @FXML
    private void change(MouseEvent event) {
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        stageTheLabelBelongs.setUserData(user);
        Scene scene2=null;
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
    private void mem(ActionEvent event) {
        MembershipController.setUser(user);
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        stageTheLabelBelongs.setUserData(user);
        Scene scene2=null;
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/membership.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
        
    }
     public static void setUser(Member u){
        user=u;
    }
     public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
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
