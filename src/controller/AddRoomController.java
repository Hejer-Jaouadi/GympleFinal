/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GymCrud;
import dao.RoomCrud;
import entity.Room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.cnst;


public class AddRoomController implements Initializable {

    @FXML
    private TextField nameFi;
    @FXML
    private Button Cancel;
    @FXML
    private Label labelname;
    @FXML
    private TextField numberFi;
    @FXML
    private Label labelnumber;
    @FXML
    private Button AddRoom;
    @FXML
    private TextField capacityFi;
    @FXML
    private Label labelcapacity;
    @FXML
    private ComboBox<Integer> idG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      GymCrud gc = GymCrud.getInstance();
      ObservableList<Integer> listID =gc.ListId();
      idG.setItems(listID);


    }    


    @FXML
    private void Cancel(MouseEvent event) {
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void AddRoom(MouseEvent event) {
        String name = nameFi.getText();
        String number = numberFi.getText();
        String capacity = capacityFi.getText();
       
          cnst eu = new cnst();
       // System.out.println("hejer");
        try{
             try {
                int number1 = Integer.parseInt(numberFi.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                numberFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(numberFi).play();
                labelnumber.setText("Number should be an integer"); 
            }
             try {
                int capacity1 = Integer.parseInt(capacityFi.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                capacityFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(capacityFi).play();
                labelcapacity.setText("capacity should be an integer"); 
            }
             
             
        if ((name.isEmpty())&&(number.isEmpty())&&(capacity.isEmpty())) {
            System.out.println("hejer");
           if(!eu.testfacility(name)){
                
             nameFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(nameFi).play();
                labelname.setText("Name must not contain numbers");
            
        }else {
                nameFi.setStyle(null);
            }
            
            if ((numberFi.getText().length() != 0)) {
                try {
                int number1 = Integer.parseInt(numberFi.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                numberFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(numberFi).play();
                labelnumber.setText("Number is wrong"); 
            }
            } else {
                numberFi.setStyle("-fx-border-color: black ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
            }
            if ((capacityFi.getText().length() != 0)) {
                try {
                int capacity1 = Integer.parseInt(capacityFi.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                capacityFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(capacityFi).play();
                labelcapacity.setText("capacity should be a number"); 
            }
            } else {
                numberFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
            }
        } else {
                 int number1=Integer.parseInt(numberFi.getText());
                 int capacity1 = Integer.parseInt(capacityFi.getText());
             int idgym1 = idG.getSelectionModel().getSelectedItem();
            
            Room room = new Room(name, number1,capacity1,idgym1);
            RoomCrud rc = RoomCrud.getInstance();
            rc.insertRoom2(room);
           // GymController g = new GymController();
            
        //GymController g = new GymController();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           // g.loadDate();
            stage.close();
        }
        } catch(Exception ex)
                {
                System.out.println("error : "+ex.getMessage());
                }
        
    }
    
}
