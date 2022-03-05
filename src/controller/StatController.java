/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RoomCrud;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utils.ConnexionSingleton;


public class StatController implements Initializable {

    @FXML
    private BarChart<String, Double> barchart;
    private ConnexionSingleton connexion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        RoomCrud rc = RoomCrud.getInstance();
       barchart.setData(rc.statistique());
       barchart.setAnimated(true);
      // barchart.setCreateSymbols(false);
        barchart.setTitle("Chart");
    }

}