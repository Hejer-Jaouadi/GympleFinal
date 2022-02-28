/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.controller;

import com.gymple.dao.RoomCrud;
import com.gymple.entity.Room;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class RoomController implements Initializable {

    @FXML
    private TableView<Room> tableRoom;
    @FXML
    private TableColumn<Room, Integer> idR;
    @FXML
    private TableColumn<Room, String> name;
    @FXML
    private TableColumn<Room, Integer> number;
    @FXML
    private TableColumn<Room, Button> edit;
    @FXML
    private Button add;
    @FXML
    private Button refresh;
    @FXML
    private Button Close;
    @FXML
    private Button listGymbutton;
    @FXML
    private Button listRooms;
    
    ObservableList<Room> RoomList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         loadDate();
    }    

    @FXML
    private void Add(MouseEvent event) {
         try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/com/gymple/controller/AddRoom.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        Refresh();
    }

    @FXML
    private void Refresh() {
         RoomList.clear();
        RoomCrud rc = RoomCrud.getInstance();
       // RoomList.addAll(rc.displayRoom());
            RoomList.addAll(rc.displayRoom());
       rc.displayRoom();
        
        tableRoom.setItems(RoomList);

        
    }

    @FXML
    private void CloseTab(MouseEvent event) {
           Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         stage.close();
    }

    @FXML
    private void listGyms(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/com/gymple/controller/Gym.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        Refresh();
    }

    @FXML
    private void listRooms(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/com/gymple/controller/Room.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            
             // primaryStage.initStyle(StageStyle.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
              Refresh();
            
            
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
      
    }

    private void loadDate() {
        Refresh();
          idR.setCellValueFactory(new PropertyValueFactory<>("idR"));
        name.setCellValueFactory(new PropertyValueFactory<>("roomName"));
        number.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));       
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     tableRoom.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {

               
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("/com/gymple/controller/GymDisplay.fxml"));
                try{
                    Loader.load();
                }catch (IOException ex) {
                // ex.printStackTrace();
                    
                    System.out.println("error : "+ex.getMessage());;
                }
               // RoomDisplayController rdc = Loader.getController();
                //rdc.setData(tableRoom.getSelectionModel().getSelectedItem().getIdG(), tableGym.getSelectionModel().getSelectedItem().getLocation(),""+tableGym.getSelectionModel().getSelectedItem().getFacilities());
                
                
             Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
            }
            
            
        });
        
    
    
    }
    
}
