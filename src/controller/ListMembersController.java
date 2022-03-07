/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MemberDao;
import entity.Member;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class ListMembersController implements Initializable {
    @FXML
    private Button back;
    @FXML
    private ListView tlist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MemberDao td=MemberDao.getInstance();   
ObservableList<Member> items =td.displayAll();
tlist.setItems(items);
tlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Member>() {
    
    @Override
    public void changed(ObservableValue<? extends Member> observable, Member oldValue, Member newValue) {
    Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        ShowMemberController.setUser(newValue);
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/showMember.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
});
    }    

    @FXML
    private void getBack(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }


    
}
