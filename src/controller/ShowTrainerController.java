/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TrainerDao;
import entity.Trainer;
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
public class ShowTrainerController implements Initializable {
    @FXML
    private Button back;
    @FXML
    private Circle c;
    @FXML
    private Label fullname;
    @FXML
    private Label em;
    @FXML
    private Label desc;
    @FXML
    private Label exp;
    @FXML
    private Label cost;
    @FXML
    private Label gym;
    private static Trainer t;
    private String img="";
    @FXML
    private Button rep;
    @FXML
    private Button res;
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        img=t.getPicture();
        fullname.setText(t.getFirst_name()+" "+t.getLast_name());
        em.setText(t.getEmail());
        exp.setText(t.getExperience());
        desc.setText(t.getDescription());
        cost.setText(Float.toString(t.getCost_per_hour()));
        gym.setText(t.getGym().getLocation());
        javafx.scene.paint.ImagePattern p;
        p = new javafx.scene.paint.ImagePattern(new Image(img));
       this.c.setFill(p);
        System.out.println(t.getPicture());
    }    
 public static void setUser(Trainer trainer) {
        ShowTrainerController.t = trainer;
    }

    @FXML
    private void getBack(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/showAllTrainers.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void report(ActionEvent event) {
        t.setReports(t.getReports()+1);
        TrainerDao ud=TrainerDao.getInstance();
                ud.update(t);
                rep.setVisible(false);
                
    }

    @FXML
    private void reserve(ActionEvent event) {
    }


    
}
