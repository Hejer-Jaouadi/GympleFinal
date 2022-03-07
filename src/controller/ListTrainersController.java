/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TrainerDao;
import entity.Trainer;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class ListTrainersController implements Initializable {
    @FXML
    private Button back;
    @FXML
    private Button add;
    @FXML
    private ListView<Trainer> tlist;
    @FXML
    private Button deleteall;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TrainerDao td=TrainerDao.getInstance();   
ObservableList<Trainer> items =td.displayAll();
tlist.setItems(items);
tlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Trainer>() {
    
    @Override
    public void changed(ObservableValue<? extends Trainer> observable, Trainer oldValue, Trainer newValue) {
        Stage stage = (Stage) (add).getScene().getWindow();
       
        UpdateTrainerController.setTrainer(newValue);
        UpdateTrainerController dialogController = 
    new UpdateTrainerController();
        

FXMLLoader loader = new FXMLLoader(
    getClass().getResource(
        "/view/updateTrainer.fxml"
    )
);
loader.setController(dialogController);

        try {
            Pane mainPane = loader.load();
             Scene sceneDef = new Scene(mainPane);

    stage.setTitle("Update Trainer");
    stage.setScene(sceneDef);
    stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListTrainersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
});
    }    

    @FXML
    private void addTrainer(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/addTrainer.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void getBack(ActionEvent event) {
         returnto();
    }
    
    private void returnto() {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void deleteAll(ActionEvent event) {
        TrainerDao td=TrainerDao.getInstance();
        td.deleteAll();;
    }
    
}
