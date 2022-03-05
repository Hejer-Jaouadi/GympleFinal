/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.ProductDaoImp;
import entity.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author juzoo
 */
public class AddProductController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField desc;
    @FXML
    private TextField qte;
    @FXML
    private TextField cat;
    @FXML
    private Button btnadd;
    @FXML
    private Button btnback;
    @FXML
    private TextField price;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void addProduct(ActionEvent event) {
        
       
        
        
        
        String namep = name.getText();
        String description = desc.getText();
        String quantity1 = qte.getText();
        int quantity = Integer.parseInt(quantity1);
        String category = cat.getText();
        String price1 = price.getText();
        float price = Float.parseFloat(price1);
        Product p = new Product(11,namep,quantity,description,category,price);
        ProductDaoImp prod = new ProductDaoImp();
        prod.addProduct(p);
        
        try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DisplayProducts.fxml"));
        
        
            Parent root = loader.load();
            DisplayProductsController dp = loader.getController();
            dp.setTxtdisplay(prod.getProduct().toString());
            name.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void backbtn(ActionEvent event) {
          Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) btnback.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/Manage.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
