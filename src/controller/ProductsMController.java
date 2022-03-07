/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.ProductDaoImp;
import entity.Product;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author juzoo
 */
public class ProductsMController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField qte;
    @FXML
    private TextField desc;
    @FXML
    private Button btnadd;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField cat;
    @FXML
    private TextField price;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtSearch;
    @FXML
    private TableView table;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn descp;
    @FXML
    private TableColumn qtep;
    @FXML
    private TableColumn catp;
    @FXML
    private TableColumn pricep;
    @FXML
    private TableColumn nameprod;
    
 
    
    
      ProductDaoImp pc = new ProductDaoImp();
    @FXML
    private Button btnex;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProductDaoImp pc = new ProductDaoImp();
         id.setCellValueFactory(new PropertyValueFactory<>("idP"));
        nameprod.setCellValueFactory(new PropertyValueFactory<>("name"));
        descp.setCellValueFactory(new PropertyValueFactory<>("description"));
        qtep.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        catp.setCellValueFactory(new PropertyValueFactory<>("category"));
        pricep.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(pc.getAllProduct());
       
        // TODO
    }    

    @FXML
    private void addProduct(ActionEvent event) {
        
        if (name.getText().length() == 0) {
                name.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(name).play();}
                 if (desc.getText().length()==0){
                        desc.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(desc).play();}
                  if (qte.getText().length()==0){
                        qte.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(qte).play();}
                   if (cat.getText().length()==0){
                        cat.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(cat).play();}
                    if (price.getText().length()==0){
                        price.setStyle("-fx-border-color: red ; -fx-border-width: 2px;-fx-border-radius: 15px;-fx-background-radius: 15px;");
                new animatefx.animation.Shake(price).play();}
                
            
               
                
              
        
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
        
        table.setItems(prod.getAllProduct());
        
       
     
        
       
    }
         
    

    @FXML
    private void updateProd(ActionEvent event) {
             Product prod = new Product();
              Product prods =  (Product) table.getSelectionModel().getSelectedItem();
        int id = prods.getIdP();
         
          prod.setName(name.getText());
          prod.setDescription(desc.getText());
          prod.setPrice(Float.parseFloat(price.getText()));
          prod.setCategory(cat.getText());
          prod.setQuantity(Integer.parseInt(qte.getText()));
          prod.setIdP(id);
         
          
          pc.updateProduct(prod);
          
          name.setText("");
          desc.setText("");
          price.setText("");
          qte.setText("");
          cat.setText("");
          
          table.setItems(pc.getAllProduct());
    }

    @FXML
    private void delProd(ActionEvent event) {
        Product prods =  (Product) table.getSelectionModel().getSelectedItem();
        int id = prods.getIdP();
        
        ProductDaoImp prod = new ProductDaoImp();
        prod.deleteProduct(id);
        table.setItems(prod.getAllProduct());
         
          name.setText("");
          desc.setText("");
          price.setText("");
          qte.setText("");
          cat.setText("");
        
    }

    @FXML
    private void Back(ActionEvent event) {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) btnBack.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void Search(MouseEvent event) {
        
    }



    @FXML
    private void clickTable(MouseEvent event) {
         Product prod =  (Product) table.getSelectionModel().getSelectedItem();
           name.setText(prod.getName());
           desc.setText(prod.getDescription());
           qte.setText(prod.getQuantity()+"");
           cat.setText(prod.getCategory());
           price.setText(prod.getPrice()+"");
           
           
    }

    @FXML
    private void SearchItem(ActionEvent event) {
          ProductDaoImp pc = new ProductDaoImp();
           table.setItems(pc.getSearchProduct(txtSearch.getText()));
    }

    @FXML
    private void extractexcel(ActionEvent event) {
        ProductDaoImp prods = new ProductDaoImp();
        prods.writetoExcel();
    }

    @FXML
    private void notifadd(MouseEvent event) throws Exception {
           Notifications notif = Notifications.create()
           .title("Success").text("Product added successfully").graphic(null).position(Pos.TOP_RIGHT);
            
            notif.showConfirm();


    }

    @FXML
    private void notifup(MouseEvent event) {
         Notifications notif = Notifications.create()
           .title("Success").text("Product updated successfully").graphic(null).position(Pos.TOP_RIGHT);
           
            notif.showConfirm();
    }

    @FXML
    private void notifdel(MouseEvent event) {
        Notifications notif = Notifications.create()
           .title("Success").text("Product deleted successfully").graphic(null).position(Pos.TOP_RIGHT);
         
            notif.showConfirm();
    }

    @FXML
    private void notifex(MouseEvent event) {
        Notifications notif = Notifications.create()
           .title("Success").text("File generated successfully").graphic(null).position(Pos.TOP_RIGHT);
            
            notif.showConfirm();
    }

    
    
}
