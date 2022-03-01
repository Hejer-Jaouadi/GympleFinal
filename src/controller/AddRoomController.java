/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RoomCrud;
import entity.Room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        if ((name.isEmpty())) {
            System.out.println("hejer");
            if (nameFi.getText().length() == 0) {
                nameFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(nameFi).play();
                labelname.setText("Name is empty");
            } else {
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
                numberFi.setStyle(null);
            }
        } else {
                 int number1=Integer.parseInt(numberFi.getText());
            
            
            Room room = new Room(name, number1);
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
