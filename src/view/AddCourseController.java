/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CoursesDao;
import entity.Courses;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.ConnexionSingleton;

/**
 * FXML Controller class
 *
 * @author Adnene
 */
public class AddCourseController implements Initializable {

    @FXML
    private DatePicker course_date;
    @FXML
    private ChoiceBox<String> course_category;
    @FXML
    private ChoiceBox<String> course_planning;
    @FXML
    private ChoiceBox<String> course_trainer;
    @FXML
    private Button add_course_btn;
    @FXML
    private Button back;
    @FXML
    private TextField course_begin;
    @FXML
    private TextField course_end;
    @FXML
    private TextField course_spots;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ConnexionSingleton c=ConnexionSingleton.getInstance();
        course_category.getItems().addAll(category1);
        course_planning.getItems().addAll(planning1);
        course_trainer.getItems().addAll(trainer1);

        course_category.setOnAction(this::getCat);
        course_planning.setOnAction(this::getPlan);
        course_trainer.setOnAction(this::getTrain);
    }
    public void getCat(ActionEvent event) {
        String cat = course_category.getValue();

    }

    public void getPlan(ActionEvent event) {
        String plan = course_planning.getValue();

    }

    public void getTrain(ActionEvent event) {
        String train = course_trainer.getValue();

    }
    private String[] category1 = {"zumba", "cardio", "workout"};
    private String[] planning1 = {"nasr", "menzah", "marsa"};
    private String[] trainer1 = {"ad", "hs", "ai"};

    @FXML
    private void getBack(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/courseMain.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }

    @FXML
    private void add(ActionEvent event) throws ClassNotFoundException {
        String date = String.valueOf(course_date.getValue());
        String coursBegin = course_begin.getText();
        String coursEnd = course_end.getText();
        int nbr = Integer.parseInt(course_spots.getText());
        String category = course_category.getValue();
        String planning = course_planning.getValue();
        String trainer = course_trainer.getValue();
        
        System.out.println(date +" ,"+coursBegin +" ,"+coursEnd +" ,"+nbr +" ,"+category +" ,"+planning +" ,"+trainer );
        if(date.isEmpty() ||coursBegin.isEmpty() ||coursEnd.isEmpty() ||category.isEmpty() ||planning.isEmpty() ||trainer.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("please fill all data!!");
            alert.showAndWait();
        }
        else{
            
            Courses c = new Courses(String.valueOf(course_date.getValue()), course_begin.getText(), course_end.getText(), Integer.parseInt(course_spots.getText()) , course_category.getValue(), course_planning.getValue(), course_trainer.getValue());
            CoursesDao cour = CoursesDao.getInstance();
            cour.insert(c);
            
            
            course_date.requestFocus();
            
        }
        
        
        
    }

}
