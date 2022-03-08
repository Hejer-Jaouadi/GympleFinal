/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.ProductDaoImp;
import entity.Product;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
    @FXML
    private Button orderbtn;

    
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

   @FXML
    private void order(ActionEvent event) {
        
//        Product prod =  (Product) table.getSelectionModel().getSelectedItem();
//          
//           String name = prod.getName();
//           String desc = prod.getDescription();
//           String cat = prod.getCategory();
//           Float price = prod.getPrice();
//           
//            
//            
//            Properties prop = new Properties();
//            prop.put("mail.smtp.auth","true");
//            prop.put("mail.smtp.starttls.enable","true");
//          
//            prop.put("mail.smtp.host","smtp.gmail.com");
//            prop.put("mail.smtp.port","587");
//            prop.put("mail.smtp.ssl.trust", "*");
//            prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//         
//            
//            
//            String myAcc = "taha.romdhane@esprit.tn";
//            String password = "213JMT1068";
//            Session session = Session.getInstance(prop,new Authenticator(){
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication(){
//                    return new PasswordAuthentication(myAcc, password);
//                }
//                
//            });
//       String recepient = "taha.romdhane@esprit.tn";
//            
//           Message message = prepareMessage(session,myAcc,recepient);
//        try {
//            Transport.send(message);
//             Notifications notif = Notifications.create()
//           .title("Success").text("Order succeeded check your mail").graphic(null).position(Pos.TOP_RIGHT);
//         
//            notif.showConfirm();
//        } catch (MessagingException ex) {
//            Logger.getLogger(ClientProductController.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//    
//            
//    }
//    private static Message prepareMessage(Session session, String myAcc,String recepient){
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(myAcc));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//            message.setSubject("Order email");
//            message.setText("Your order was a success ! ");
//            return message;
//            
//            
//        } catch (AddressException ex) {
//            Logger.getLogger(ClientProductController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MessagingException ex) {
//            Logger.getLogger(ClientProductController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;

    }
    
}
