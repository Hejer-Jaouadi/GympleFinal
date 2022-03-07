/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.SignupController.infoBox;
import dao.GymCrud;
import dao.TrainerDao;
import dao.UserDao;
import entity.Gym;
import entity.Trainer;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Control;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class UpdateTrainerController implements Initializable {
    @FXML
    private TextField cost;
    @FXML
    private TextField desc;
    @FXML
    private Button add;
    @FXML
    private Button cancel2;
    @FXML
    private Button de;
    @FXML
    private Button bl;
    @FXML
    private TextField first;
    @FXML
    private TextField last;
    @FXML
    private TextField em;
    @FXML
    private TextField exp;
    private static Trainer trainer;
    private static String b;
    @FXML
    private ChoiceBox gym;
    @FXML 
    private Label rep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        de.setVisible(false);
            bl.setVisible(false);
       
        first.setText(trainer.getFirst_name());
        last.setText(trainer.getLast_name());
        em.setText(trainer.getEmail());
        cost.setText(String.valueOf(trainer.getCost_per_hour()));
        exp.setText(trainer.getExperience());
        desc.setText(trainer.getDescription());
        GymCrud gc=GymCrud.getInstance();
        gym.setItems(gc.getGyms());
        gym.setValue(trainer.getGym());
        System.out.println(trainer.getBlock());
        rep.setText(Integer.toString(trainer.getReports()));
        if(trainer.getBlock().equals("n")){
            bl.setVisible(true);
        }
        else if(trainer.getBlock().equals("y")){
            de.setVisible(true);
        }
        
        // TODO
    }   
   
    public static void setTrainer(Trainer t){
        trainer=t;
    }
    
     private void returnto() {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) cancel2.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/listTrainers.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);

    }

    @FXML
    private void next(ActionEvent event) {
        Control c=new Control();
        if((c.trueString(first.getText()))&&(c.trueString(last.getText()))&&(c.trueEmail(em.getText()))&& (!gym.getSelectionModel().isEmpty()) && (c.trueEmail(em.getText())) && (c.trueFloat(cost.getText())) && (c.trueString(desc.getText())) && (exp.getText().isEmpty()))
        {System.out.println(trainer.getId());
            trainer.setFirst_name(first.getText());
        trainer.setLast_name(last.getText());
        trainer.setEmail(em.getText());
        trainer.setDescription(desc.getText());
        trainer.setCost_per_hour(Float.parseFloat(cost.getText()));
        trainer.setExperience(exp.getText());
        Gym g=(Gym)gym.getValue();
            trainer.setGym(g);
        TrainerDao ud=TrainerDao.getInstance();
                ud.update(trainer);
        this.returnto();}
        else {
            infoBox("Please Enter Correct Informations", "Failed", null);
        }
    }
    
     public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }


    @FXML
    private void getBack(ActionEvent event) {
        bl.setVisible(false);
        de.setVisible(false);
        this.returnto();
    }

    @FXML
    private void cancel(ActionEvent event) {
        first.setText(trainer.getFirst_name());
        last.setText(trainer.getLast_name());
        em.setText(trainer.getEmail());
        cost.setText(String.valueOf(trainer.getCost_per_hour()));
        exp.setText(trainer.getExperience());
        desc.setText(trainer.getDescription());
        gym.setValue(trainer.getGym());
        
    }
       @FXML
    private void delete(ActionEvent event) {
        TrainerDao ud=TrainerDao.getInstance();
                ud.delete(trainer);
                returnto();
        
    }
       @FXML
    private void block(ActionEvent event) {
        trainer.setBlock("y");
        TrainerDao ud=TrainerDao.getInstance();
                ud.update(trainer);
                de.setVisible(true);
            bl.setVisible(false);
                

        
    }
        @FXML
    private void deblock(ActionEvent event) {
        trainer.setBlock("n");
        TrainerDao ud=TrainerDao.getInstance();
                ud.update(trainer);
                de.setVisible(false);
            bl.setVisible(true);

        
    }

    
}

