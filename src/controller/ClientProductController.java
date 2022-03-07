/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.ProductDaoImp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author juzoo
 */
public class ClientProductController implements Initializable {

    @FXML
    private TableView table;
    @FXML
    private TableColumn nameprod;
    @FXML
    private TableColumn descp;
    @FXML
    private TableColumn catp;
    @FXML
    private TableColumn pricep;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private Button returnbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ProductDaoImp pc = new ProductDaoImp();   
        nameprod.setCellValueFactory(new PropertyValueFactory<>("name"));
        descp.setCellValueFactory(new PropertyValueFactory<>("description"));  
        catp.setCellValueFactory(new PropertyValueFactory<>("category"));
        pricep.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(pc.getAllProduct());
    }    

    @FXML
    private void clickTable(MouseEvent event) {
        System.out.println("working");
    }

    @FXML
    private void SearchItem(ActionEvent event) {
          ProductDaoImp pc = new ProductDaoImp();
           table.setItems(pc.getSearchProduct(txtSearch.getText()));
    }

    @FXML
    private void back(MouseEvent event) {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) returnbtn.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/home.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
