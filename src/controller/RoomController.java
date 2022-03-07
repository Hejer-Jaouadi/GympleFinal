/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.RoomCrud;
import entity.Room;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.text.View;

public class RoomController implements Initializable {

    @FXML
    private TableView<Room> tableRoom;
    @FXML
    private TableColumn<Room, Integer> idR;
    @FXML
    private TableColumn<Room, String> name;
    @FXML
    private TableColumn<Room, Integer> number;
    @FXML
    private Button add;
    @FXML
    private Button refresh;
    @FXML
    private Button Close;
    @FXML
    private Button listGymbutton;
    @FXML
    private Button listRooms;

    ObservableList<Room> RoomList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Room, Integer> capacity;
    @FXML
    private Button stat;
    @FXML
    private Button pdf;
    @FXML
    private TableColumn<Room, Integer> gym;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDate();

    }

    @FXML
    private void Add(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/view/AddRoom.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        Refresh();
    }

    @FXML
    private void Refresh() {
        RoomList.clear();
        RoomCrud rc = RoomCrud.getInstance();
        // RoomList.addAll(rc.displayRoom());
        RoomList.addAll(rc.displayRoom());
        rc.displayRoom();

        tableRoom.setItems(RoomList);

    }

    @FXML
    private void CloseTab(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void listGyms(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/view/Gym.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        Refresh();
    }

    @FXML
    private void listRooms(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/view/Room.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);

            // primaryStage.initStyle(StageStyle.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            Refresh();

        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }

    }

    private void loadDate() {
        Refresh();
        idR.setCellValueFactory(new PropertyValueFactory<>("idR"));
        name.setCellValueFactory(new PropertyValueFactory<>("roomName"));
        number.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("max_nbr"));
        gym.setCellValueFactory(new PropertyValueFactory<>("idgym"));
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        tableRoom.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("/view/RoomDisplay.fxml"));
                try {
                    Loader.load();
                } catch (IOException ex) {
                    // ex.printStackTrace();

                    System.out.println("error : " + ex.getMessage());;
                }
                RoomDisplayController rdc = Loader.getController();
                rdc.setData(tableRoom.getSelectionModel().getSelectedItem().getIdR(), "" + tableRoom.getSelectionModel().getSelectedItem().getRoomName(), tableRoom.getSelectionModel().getSelectedItem().getRoomNumber(), tableRoom.getSelectionModel().getSelectedItem().getMax_nbr(), tableRoom.getSelectionModel().getSelectedItem().getIdgym());

                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
            }

        });

    }

    @FXML
    private void stat(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/view/stat.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);

            // primaryStage.initStyle(StageStyle.TRANSPARENT);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            Refresh();

        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }

    }

    @FXML
    private void pdf(MouseEvent event) throws FileNotFoundException, DocumentException {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("roomPdf2"));
        document.open();
        document.add(new Paragraph("The list of rooms : "));
        document.add(new Paragraph("---------------------------------"));

        PdfPTable table = new PdfPTable(3);
        table.addCell("room Name");
        // table.addCell();
        table.addCell("room Number");
        table.addCell("room capacity");

        document.add(table);
        document.close();

    }

    private PdfPCell getCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    
}
