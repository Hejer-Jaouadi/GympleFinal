/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymple;

import entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.ConnexionSingleton;

/**
 *
 * @author Asma
 */
public class Gymple extends Application {

    /**
     * @param args the command line arguments
     */
   
   
    private Object stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
        //String css="/view/AppStyleSheet.css";
        //String ok=Gymple.class.getResource(css).toExternalForm();
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(ok);
        stage.setScene(scene);
        stage.show();
    }
     public static void main(String[] args) {
        launch(args);
    }

}
