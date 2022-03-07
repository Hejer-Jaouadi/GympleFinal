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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.ConnexionSingleton;

/**
 * FXML Controller class
 *
 * @author Adnene
 */
public class Course_modifyController implements Initializable {

    @FXML
    private TextField course_modify_begin;
    @FXML
    private TextField course_modify_end;
    @FXML
    private TextField course_modify_spots;
    @FXML
    private ChoiceBox<String> course_modify_category;
    @FXML
    private ChoiceBox<String> course_modify_planning;
    @FXML
    private ChoiceBox<String> course_modify_trainer;
    @FXML
    private Button apply;
    
    @FXML
    private Button modify;
    @FXML
    private Button delete;
    @FXML
    private Button cancel;
    @FXML
    private TextField course_modify_begin1;
    
    @FXML
    private DatePicker course_modify_date;
    
    private TextField course_modify_id;
    
    
    public static CoursesDao instance;
    private Statement st;
    private ResultSet rs;
    int id;
    @FXML
    private ListView courseList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ConnexionSingleton c=ConnexionSingleton.getInstance();
             st = c.getCnx().createStatement();
             
             //course_modify_category.setItems(gc.getGyms());
        } catch (SQLException ex) {
            Logger.getLogger(Course_modifyController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        showCourses();
        course_modify_category.getItems().addAll(category1);
        course_modify_planning.getItems().addAll(planning1);
        course_modify_trainer.getItems().addAll(trainer1);
        
        course_modify_category.setOnAction(this::getCat);
        course_modify_planning.setOnAction(this::getPlan);
        course_modify_trainer.setOnAction(this::getTrain);
    }
    
    public void getCat(ActionEvent event){
        String cat = course_modify_category.getValue();
        
        
        
    }
    public void getPlan(ActionEvent event){
        String plan = course_modify_planning.getValue();
        
        
    }
    public void getTrain(ActionEvent event){
        String train = course_modify_trainer.getValue();
        
        
    }
    private String[] category1 = {"zumba","cardio","workout"};
    private String[] planning1 = {"nasr","menzah","marsa"};
    private String[] trainer1 = {"ad","hs","ai"};

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
public static final LocalDate LOCAL_DATE (String dateString){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
}
    public void showCourses() {
        CoursesDao td=CoursesDao.getInstance();   
ObservableList<Courses> items =td.displayAll();
courseList.setItems(items);
courseList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Courses>() {
            @Override
            public void changed(ObservableValue<? extends Courses> observable, Courses oldValue, Courses newValue) {
                id=newValue.getId();
                course_modify_date.setValue(LOCAL_DATE(newValue.getDate()));
                course_modify_begin.setText(newValue.getCoursBegin());
                course_modify_end.setText(newValue.getCoursEnd());
                course_modify_spots.setText(Integer.toString(newValue.getPlaces()));
                course_modify_category.setValue(newValue.getCategory());
                course_modify_planning.setValue(newValue.getPlanning());
                course_modify_trainer.setValue(newValue.getTrainer());
            }
    
    });
       
    }

    

    

    //private void insert() throws SQLException{
       // String req = "INSERT INTO course (date, start_time, end_time, nbr, category, plan, trainer) "
       //         + "VALUES ('" + course_modify_date.getText() + "',"+ course_modify_begin1.getText() + "',"+ course_modify_end.getText() + "',"+ course_modify_spots.getAnchor() + "',"+ course_modify_category.getValue() + "',"+ course_modify_planning.getValue() + "'," + course_modify_trainer.getValue() + "')";
       // st.executeUpdate(req);
        
    //}
    @FXML
    private void update(ActionEvent event) throws ClassNotFoundException {
        
        //String date = String.valueOf(course_modify_date.getValue());
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
String date = String.valueOf(course_modify_date.getValue());
        //String date = course_modify_date.getValue().toString();         
        String coursBegin = course_modify_begin.getText();
        String coursEnd = course_modify_end.getText();
        int nbr = Integer.parseInt(course_modify_spots.getText());
        String category = course_modify_category.getValue();
        String planning = course_modify_planning.getValue();
        String trainer = course_modify_trainer.getValue();
        
        Courses c = new Courses(id, date, coursBegin, coursEnd, nbr, category, planning, trainer);
        CoursesDao cour = CoursesDao.getInstance();
        cour.update(c);        
        
        
    }

    @FXML
    private void del(ActionEvent event) throws ClassNotFoundException {
        Courses c = new Courses();
        c.setId(id);
        CoursesDao cour = CoursesDao.getInstance();
              
        cour.delete(c);
        
    }
    

}
