/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GymCrud;
import entity.Gym;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
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
    private Button add;
    @FXML
    private Button refresh;
    @FXML
    private TableView<Gym> tableGym;
    Gym gym = null;

    ObservableList<Gym> GymList = FXCollections.observableArrayList();
    @FXML
    private Button Close;
    @FXML
    private Button listGymbutton;
    @FXML
    private Button listRooms;
    @FXML
    private TextField searchFi;
    @FXML
    private Button search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initTable();
        loadDate();
        
        
       
      
        
    }

    @FXML
    private void Add(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/view/AddGym.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        Refresh();
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

    public void loadDate() {
       
        
        Refresh();
        idG.setCellValueFactory(new PropertyValueFactory<>("idG"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        facilities.setCellValueFactory(new PropertyValueFactory<>("facilities"));
        
        tableGym.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {

               
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("/view/GymDisplay.fxml"));
                try{
                    Loader.load();
                }catch (IOException ex) {
                // ex.printStackTrace();
                    
                    System.out.println("error : "+ex.getMessage());;
                }
                GymDisplayController gdc = Loader.getController();
                gdc.setData(tableGym.getSelectionModel().getSelectedItem().getIdG(), tableGym.getSelectionModel().getSelectedItem().getLocation(),""+tableGym.getSelectionModel().getSelectedItem().getFacilities());
                
                
             Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
            }
            
            
        });
        
    
            
           
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
            root = FXMLLoader.load(getClass().getResource("/view/Gym.fxml"));
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
            root = FXMLLoader.load(getClass().getResource("/view/Room.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage() ;
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
       
    }

    @FXML
    private void search(MouseEvent event) {
        
         String searchGym = searchFi.getText();
         GymCrud gc = GymCrud.getInstance();
         
         GymList.clear();
        // Gym g = new Gym(location,facilities);
        //  GymList.add(new Gym(location,facilities));
        
        // GymList.add(gc.displayGym());
        GymList.addAll(gc.SearchGym(searchGym));
        //gc.SearchGym(searchGym);
        
        tableGym.setItems(GymList);
        
        
    }
    
    

}
