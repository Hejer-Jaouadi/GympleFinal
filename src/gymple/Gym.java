/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymple;

import dao.TipsDao;
import entity.Courses;
import entity.Tips;
import static java.time.Clock.system;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.ConnexionSingleton;
import view.Course_modifyController;

/**
 *
 * @author Adnene
 */
public class Gym extends Application {

    /**
     * @param args the command line arguments
     */
   
   
    private Object stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml"));
        //String css="/view/AppStyleSheet.css";
        //String ok=Gymple.class.getResource(css).toExternalForm();
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(ok);
        stage.setScene(scene);
        stage.show();
    }
     public static void main(String[] args) throws ClassNotFoundException {
        launch(args);
        ConnexionSingleton c=ConnexionSingleton.getInstance();
        
        
    }
     

}