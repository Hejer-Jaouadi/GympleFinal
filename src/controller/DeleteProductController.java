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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author juzoo
 */
public class DeleteProductController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private Button btndel;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void delProd(ActionEvent event) {
        String id1 = txtid.getText();
        int id = Integer.parseInt(id1);
        ProductDaoImp prod = new ProductDaoImp();
        prod.deleteProduct(id);
    }

    @FXML
    private void backbtn(ActionEvent event) {
          Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) btnback.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Manage.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
