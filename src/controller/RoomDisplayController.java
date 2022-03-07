/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.RoomCrud;
import entity.Room;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class RoomDisplayController implements Initializable {

    @FXML
    private Button modify;
    @FXML
    private Button delete;
    @FXML
    private Button cancel;
    @FXML
    private TextField idR;
    @FXML
    private TextField nameFi;
    @FXML
    private TextField numberFi;
    @FXML
    private TextField capacityFi;
    @FXML
    private Button pdf;
    @FXML
    private TextField gym;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idR.setEditable(false);
    }

    @FXML
    private void modify(MouseEvent event) {

        String idRoom = idR.getText();
        String name = nameFi.getText();
        String number = numberFi.getText();
        String capacity = capacityFi.getText();
        String idG = gym.getText();
        // System.out.println("hejer");
        try {
            try {
                int number1 = Integer.parseInt(numberFi.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                numberFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(numberFi).play();
                // labelnumber.setText("Number should be an integer"); 
            }
            try {
                int capacity1 = Integer.parseInt(capacityFi.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                capacityFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(capacityFi).play();
                // labelnumber.setText("Number should be an integer"); 
            }
            try {
                int idgym1 = Integer.parseInt(gym.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                gym.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(gym).play();
                // labelnumber.setText("Number should be an integer"); 
            }
            if ((name.isEmpty())) {
                System.out.println("hejer");
                if (nameFi.getText().length() == 0) {
                    nameFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                    new animatefx.animation.Shake(nameFi).play();
                    //labelname.setText("Name is empty");
                } else {
                    nameFi.setStyle(null);
                }

                if ((numberFi.getText().length() != 0)) {
                    try {
                        int number1 = Integer.parseInt(numberFi.getText());
                        numberFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");

                    } catch (RuntimeException e) {
                        //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                        numberFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                        new animatefx.animation.Shake(numberFi).play();
                        // labelnumber.setText("Number is wrong"); 
                    }
                } else {
                    numberFi.setStyle(null);
                }
            } else {
                int number1 = Integer.parseInt(numberFi.getText());
                int capacity1 = Integer.parseInt(capacityFi.getText());
                int idgym1 = Integer.parseInt(gym.getText());
                Room room = new Room(idRoom, name, number1, capacity1, idgym1);
                RoomCrud rc = RoomCrud.getInstance();
                //gc.updateGym(new Gym());
                rc.modifyRoom(idRoom, name, number1, capacity1, idgym1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        } catch (Exception ex) {
            System.out.println("error : " + ex.getMessage());
        }

    }

    @FXML
    private void delete(MouseEvent event) {

        String idRoom = idR.getText();
        String name = nameFi.getText();
        String number = numberFi.getText();
        String capacity = capacityFi.getText();

        // System.out.println("hejer");
        try {
            try {
                int number1 = Integer.parseInt(numberFi.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                numberFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(numberFi).play();

            }
            try {
                int capacity1 = Integer.parseInt(capacityFi.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                capacityFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(capacityFi).play();

            }
            try {
                int idgym1 = Integer.parseInt(gym.getText());
            } catch (RuntimeException e) {
                //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                gym.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(gym).play();
                // labelnumber.setText("Number should be an integer"); 
            }
            if ((name.isEmpty())) {
                System.out.println("hejer");
                if (nameFi.getText().length() == 0) {
                    nameFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                    new animatefx.animation.Shake(nameFi).play();
                    //labelname.setText("Name is empty");
                } else {
                    nameFi.setStyle(null);
                }

                if ((numberFi.getText().length() != 0)) {
                    try {
                        int number1 = Integer.parseInt(numberFi.getText());
                        numberFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");

                    } catch (RuntimeException e) {
                        //JOptionPane.showMessageDialog(null, "Prix et quantite doient étre des nombres!", "Input error ", JOptionPane.ERROR_MESSAGE);
                        numberFi.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                        new animatefx.animation.Shake(numberFi).play();
                        // labelnumber.setText("Number is wrong"); 
                    }
                } else {
                    numberFi.setStyle(null);
                }
            } else {
                int number1 = Integer.parseInt(numberFi.getText());
                int idgym1 = Integer.parseInt(gym.getText());
                Room room = new Room(name, number, capacity,idgym1);
                RoomCrud gc = RoomCrud.getInstance();
                gc.deleteRoom(gc.displayByIdRoom(idRoom));

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        } catch (Exception ex) {
            System.out.println("error : " + ex.getMessage());
        }

    }

    @FXML
    private void cancel(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setData(int idRoom, String Name, int Number, int capacity,int idgym) {

        nameFi.setText("" + Name);
        numberFi.setText("" + Number);
        idR.setText("" + idRoom);
        capacityFi.setText("" + capacity);
        gym.setText("" + idgym);

    }

    @FXML
    private void pdf(MouseEvent event) throws FileNotFoundException, DocumentException {

        String name = nameFi.getText();
        String number = numberFi.getText();
        String capacity = capacityFi.getText();
//        int number1 = Integer.parseInt(numberFi.getText());
//         int capacity1 = Integer.parseInt(capacityFi.getText());
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("roomDisplay1"));
        document.open();
        document.add(new Paragraph("Room information display : "));
        document.add(new Paragraph("---------------------------------"));

        PdfPTable table = new PdfPTable(3);
        table.addCell("room Name");
        table.addCell(name);
        // table.addCell();

        table.addCell("room Number");
        table.addCell(number);
        table.addCell("room Capacity");
        table.addCell(capacity);
       

        System.out.println("pdf done");

        document.add(table);
        document.close();
    }

}
