/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Adnene
 */
public class TipsController implements Initializable {

    @FXML
    private TextField tip_caption;
    @FXML
    private TextArea tip_text;
    @FXML
    private ChoiceBox<?> tip_category;
    @FXML
    private Button cancel;
    @FXML
    private Button add_tips;
    @FXML
    private TableView<?> tips_view;
    @FXML
    private Button modify_tips;
    @FXML
    private Button delete_tips;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void getBack(ActionEvent event) {
        Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
}
