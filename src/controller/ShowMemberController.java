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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class ShowMemberController implements Initializable {
    @FXML
    private Button back;
    @FXML
    private Circle c;
    @FXML
    private Label fullname;
    @FXML
    private Label em;
    @FXML
    private Label ID;
    @FXML
    private Label height;
    @FXML
    private Label weight;
    @FXML
    private Button del;
    @FXML
    private Label TL;
    private static Member member;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fullname.setText(member.getFirst_name()+" "+member.getLast_name());
        ID.setText(Integer.toString(member.getId_card()));
        height.setText(Float.toString(member.getHeight()));
        weight.setText(Float.toString(member.getWeight()));
        TL.setText(member.getTraining_level());
        String img=member.getPicture();
         javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(img));
       this.c.setFill(p);
    }    

    @FXML
    private void getBack(ActionEvent event) {
          Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/listMembers.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void delete(ActionEvent event) {
         MemberDao ud=MemberDao.getInstance();
                ud.delete(member);
                 Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/listMembers.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
     public static void setUser(Member m) {
        ShowMemberController.member= m;
    }
    
}
