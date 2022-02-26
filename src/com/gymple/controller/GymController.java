/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.controller;

import com.gymple.dao.GymCrud;
import com.gymple.entity.Gym;
import com.gymple.utils.MyConnexion;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class GymController implements Initializable {

    @FXML
    private TableColumn<Gym, Integer> idG;
    @FXML
    private TableColumn<Gym, String> location;
    @FXML
    private TableColumn<Gym, String> facilities;
    @FXML
    private TableColumn<Gym, String> edit;
    @FXML
    private Button add;
    @FXML
    private Button refresh;
    @FXML
    private TableView<Gym> tableGym;
    Gym gym = null;

    ObservableList<Gym> GymList = FXCollections.observableArrayList();
    @FXML
    private Button Close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
    }

    @FXML
    private void Add(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/com/gymple/controller/AddGym.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void Refresh() {
        GymList.clear();
        // Gym g = new Gym(location,facilities);
        //  GymList.add(new Gym(location,facilities));
        GymCrud gc = GymCrud.getInstance();
        // GymList.add(gc.displayGym());
        GymList.addAll(gc.displayGym());
        gc.displayGym();
        tableGym.setItems(GymList);

    }

    private void loadDate() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // MyConnexion mc = MyConnexion.getInstance() ;
        Refresh();
        idG.setCellValueFactory(new PropertyValueFactory<>("idG"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        facilities.setCellValueFactory(new PropertyValueFactory<>("facilities"));
        
        Callback<TableColumn<Gym,String>,TableCell<Gym,String>>CellFactory=(person)->{
              
            final TableCell<Gym,String> cell = new TableCell<Gym,String>(){
            
                public void updateGym(String item, boolean empty){
                    super.updateItem(item, empty);
                    
                    if(empty){
                        setGraphic(null);
                        setText(null);
                        
                    }
                else{
                        final Button editButton=new Button("EDIT");
                        editButton.setOnAction(event-> {
                        Gym g = getTableView().getItems().get(getIndex());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  
                    alert.setContentText("You have clicked the gym with location : \n" +g.getLocation()+"with facility \n"+g.getFacilities());
                    alert.show();
                });
                        setGraphic(editButton);
                        setText(null);
                    }
                    
                }
                
        };
            
            
            
            
            
            
            return cell;
        };
         
    }

    

    @FXML
    private void CloseTab(MouseEvent event) {
        
         Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         stage.close();
    }

}
