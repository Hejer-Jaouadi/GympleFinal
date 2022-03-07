/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Asma
 */
public class HandleImage {
 
    /* public void saveToFile(Image image) {
    File outputFile;
         outputFile = new File("C:\\AppImages");
    BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
    try {
      ImageIO.write(bImage, "png", outputFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
     }
     */
    
    
    
      
     
    public String selectImage(Stage primaryStage){
        FileChooser fileChooser = new FileChooser();
         File selectedFile  = fileChooser.showOpenDialog(primaryStage);
         Image image=null;
         //String s="";
         String imageUrl="";
    if (selectedFile != null) {
        
        System.out.println(selectedFile.getAbsolutePath());
        final InputStream targetStream; // Creating the InputStream
        try
        {
            targetStream = new DataInputStream(new FileInputStream(selectedFile));
            image = new Image(targetStream);
            imageUrl = selectedFile.toURI().toURL().toExternalForm();
            System.out.println(imageUrl);
           // s=image.impl_getUrl();

        } catch (FileNotFoundException fileNotFoundException)
        {
            fileNotFoundException.printStackTrace();
        }   catch (MalformedURLException ex) {
                Logger.getLogger(HandleImage.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 
    return imageUrl;
    }
    
}
