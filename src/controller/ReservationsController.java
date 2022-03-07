/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.ReservationDAOImpl;
import entities.Reservation;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.DBConnection;

/**
 * FXML Controller class
 *
 * @author amorl
 */
public class ReservationsController implements Initializable {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TableView<Reservation> tvReservations;
    @FXML
    private TableColumn<Reservation, String> colCoach;
    @FXML
    private TableColumn<Reservation, String> colCourse;
    @FXML
    private TableColumn<Reservation, String> colType;
    @FXML
    private TableColumn<Reservation, String> colDate;
    @FXML
    private TableColumn<Reservation, String> colTime;
    @FXML
    private TableColumn<Reservation, String> colID;
    @FXML
    private TextField tfCoach;
    @FXML
    private TextField tfCourse;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfTime;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    private int count=0;
    
    private static  ReservationDAOImpl reservationDAOImpl = new ReservationDAOImpl().getInstance();
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            tvReservations.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("coachName"));
            tvReservations.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseName"));
            tvReservations.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type"));
            tvReservations.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("reserved_date"));
            tvReservations.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("reserved_time"));
            tvReservations.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("rid"));
            loadAllReservations();
            btnSubmit.setDisable(true);
            
        } catch (Exception ex) {
            Logger.getLogger(ReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void insertRes(ActionEvent event) throws Exception {
        String id = tfID.getText();
        String coachName = tfCoach.getText();
        String courseName = tfCourse.getText();
        String type = tfType.getText();
        String reserved_date = datePicker.getValue().toString();
        String reserved_time = tfTime.getText();
        Reservation reservation = new Reservation(parseInt(id), coachName, courseName, reserved_date, reserved_time, type);
        try {
            boolean isInserted = ReservationDAOImpl.getInstance().insert(reservation);
            if (isInserted) {
                tvReservations.getItems().add(reservation);
            //alert success
            //sysprint
            } else {
                // alert fail
            }
        } catch (Exception ex) {
            Logger.getLogger(ReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadAllReservations();
    }
    
    @FXML
    void clearFields(MouseEvent event) {
        clear();
    }
    public void clear(){
        tfID.setText(null);
        tfCoach.setText(null);
        tfCourse.setText(null);
        tfTime.setText(null);
        datePicker.setValue(null);
        tfType.setText(null);
    }
    
    @FXML
    void deleteRes(ActionEvent event) throws Exception {
        String id = tfID.getText();
        
        try {
            boolean isDeleted = ReservationDAOImpl.getInstance().delete(id);
            
            if(isDeleted) {
                // alert success
                clear();
            }
        } catch (Exception ex) {
            Logger.getLogger(ReservationsController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    @FXML
    void updateRes(ActionEvent event) {
        String id=tfID.getText();
        String coachName = tfCoach.getText();
        String courseName=tfCourse.getText();
        String reserved_time=tfTime.getText();
        String type=tfType.getText();
        String reserved_date=datePicker.getValue().toString();

        Reservation reservation = new Reservation (parseInt(id),coachName,courseName,type,reserved_date,reserved_time);
        try{
            boolean isUpdated=ReservationDAOImpl.getInstance().update(reservation);
            
            if(isUpdated){
                // alert success
                tvReservations.getItems().add(reservation);
            }else{
                // fail alert
            }
        }catch(Exception ex){
            Logger.getLogger(ReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }

    private void loadAllReservations() throws Exception {
        try {
        ArrayList<Reservation> allReservations = reservationDAOImpl.getInstance().getAll();
        tvReservations.setItems(FXCollections.observableArrayList());
        } catch (Exception ex) {
            Logger.getLogger(ReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> searchReservation(String rid) throws ClassNotFoundException,SQLException{
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select rid from reservations where rid='"+rid+"'");
        ArrayList<String> rids=new ArrayList<>();
        while(rst.next()){
            rids.add(rst.getString("rid"));
        }
        return rids;
    }
    
    public void start(Stage s) {
        
    }
}
