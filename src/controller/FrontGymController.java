package controller;

import dao.GymCrud;
import entity.Gym;
import static java.awt.SystemColor.text;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class FrontGymController implements Initializable {

    @FXML
    private ListView<Gym> listgym;
    ObservableList<Gym> GymList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        GymCrud g = GymCrud.getInstance();
//        listgym.setItems(GymList);
//        GymList.addAll(g.displayGym());
//       g.displayGym();
//        
//        listgym.setItems(GymList);
        // TODO
         GymCrud gc = GymCrud.getInstance();
        List<Gym> gym = gc.displayGymwithoutid();
        ObservableList<Gym> ObservableListgym = FXCollections.observableArrayList(gym);
        listgym.setItems(ObservableListgym);}
    
      //  TextField text = new TextField();
      
    
            
    
        
    }