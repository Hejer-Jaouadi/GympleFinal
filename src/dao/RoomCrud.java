/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Room;
import utils.ConnexionSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.VBox;

public class RoomCrud implements IdaoR<Room> {

    private static RoomCrud instance;
    private Statement st;
    private ResultSet rs;

    private RoomCrud() {
        ConnexionSingleton cs = ConnexionSingleton.getInstance();
        try {
            st = cs.getCnx().createStatement();
            // System.out.println("connexion successful");
        } catch (SQLException ex) {
            Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }

    public static RoomCrud getInstance() {
        if (instance == null) {
            instance = new RoomCrud();
        }
        return instance;
    }

    @Override
    public void insertRoom(String roomName, String roomNumber, String idgym) {
        String req = "insert into room (roomName,roomNumber,idgym) values (roomName,roomNumber,idgym)";
        try {
            st.executeUpdate(req);
            System.out.println("room added successfully");
        } catch (SQLException ex) {
            //Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error in insert room");
            System.err.println(ex.getMessage());

        }

    }

    @Override
    public void insertRoom2(Room o) {
        String req = "insert into room (roomName,roomNumber,idgym) values "
                + "('" + o.getRoomName() + "','" + o.getRoomNumber() + "','" + o.getIdgym() + "')";
        try {
            st.executeUpdate(req);
            System.out.println("room added successfully");
        } catch (SQLException ex) {
            //Logger.getLogger(CrudRoom.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error in insert room 2");
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Room> displayRoom() {
        String req = "select * from room";
        ObservableList<Room> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {

                Room r = new Room();
                r.setIdR(rs.getInt(1));
                r.setRoomName(rs.getString(2));
                r.setRoomNumber(rs.getInt(3));
                r.setMax_nbr(rs.getInt(4));
                r.setIdgym(rs.getInt(5));
                list.add(r);

            }

        } catch (SQLException ex) {
            System.out.println("error in display room");
            Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public boolean updateRoom(Room r) {
        String qry = "UPDATE room SET roomName = '" + r.getRoomName() + "', roomNumber = '" + r.getRoomNumber() + "', max_nbr = '" + r.getMax_nbr() + "' WHERE idR = " + r.getIdR();

        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("error in update room");
            Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Room displayByIdRoom(int id) {
        String req = "select * from room where idR =" + id;
        Room r = new Room();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            r.setIdR(rs.getInt(1));
            r.setRoomName(rs.getString(2));
            r.setRoomNumber(rs.getInt(3));
            r.setMax_nbr(rs.getInt(4));
            r.setIdgym(rs.getInt(5));
            //}  
        } catch (SQLException ex) {
            System.out.println("room does not exist");
            System.err.println(ex.getMessage());
            // Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public void deleteRoom(Room o) {
        String req = "delete from room where idR=" + o.getIdR();

        Room r = displayByIdRoom(o.getIdR());

        if (r != null) {
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                System.out.println("error in delete room");
                System.err.println(ex.getMessage());
                // Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("doesn't exist");
        }

    }

    @Override
    public boolean modifyRoom(int id, String roomName, String roomNumber, String idgym) {
        String qry = "UPDATE room SET roomName = '" + roomName + "', roomNumber = '" + roomNumber + "', idgym = '" + idgym + "' WHERE idR = " + id;

        try {
            st.executeUpdate(qry);
            System.out.println("room modified successfully");
            return true;

        } catch (SQLException ex) {
            System.out.println("error in modify room");
            Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public void searchByName(String name) {
        String req = "select * from room where roomName='" + name + "'";

        try {
            rs = st.executeQuery(req);
            rs.last();
            int nbrRow = rs.getRow();
            if (nbrRow != 0) {
                System.out.println("room found");
            } else {
                System.out.println("room not found");
            }

        } catch (SQLException ex) {
            //Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("error searchbylocation");
            System.err.println(ex.getMessage());
        }

    }

    public void insertRoom2(String name, String number, String idgym) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String req = "insert into room (roomName,roomNumber,idgym) values (name,number,idgym)";
        try {
            st.executeUpdate(req);
            System.out.println("room added successfully");
        } catch (SQLException ex) {
            //Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error in insert room");
            System.err.println(ex.getMessage());

        }
    }

    public boolean modifyRoom(String idRoom, String name, int number1, int capacity1, int idgym1) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String qry = "UPDATE room SET roomName = '" + name + "', roomNumber = '" + number1 + "', max_nbr = '" + capacity1 + "', idgym = '" + idgym1 + "' WHERE idR = " + idRoom;

        try {
            st.executeUpdate(qry);
            System.out.println("room modified successfully");
            return true;

        } catch (SQLException ex) {
            System.out.println("error in modify room");
            Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public Room displayByIdRoom(String idRoom) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String req = "select * from room where idR =" + idRoom;
        Room r = new Room();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            r.setIdR(rs.getInt(1));
            r.setRoomName(rs.getString(2));
            r.setRoomNumber(rs.getInt(3));
            r.setMax_nbr(rs.getInt(4));
            r.setIdgym(rs.getInt(5));
            //}  
        } catch (SQLException ex) {
            System.out.println("room does not exist");
            System.err.println(ex.getMessage());
            // Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;

    }

    public ObservableList<XYChart.Series<String, Double>> statistique(){
      ObservableList<XYChart.Series<String, Double>> stats = FXCollections.observableArrayList();

     try { 
         
        String requete="select count(*) , g.location from room r join gym g where r.idgym = g.idG  group by g.location";

            rs = st.executeQuery(requete);
             while (rs.next()){
                 Series<String, Double> serie = new Series<>();
                 serie.setName(rs.getString("location"));
                 serie.getData().add(new XYChart.Data(rs.getString("location"),rs.getInt("count(*)")));
                  stats.addAll(serie);
                 
             }     
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      return stats;
}

   
    @Override
    public List<Room> Sort() {
        String req = "select * from room ORDER BY roomName DESC";
        ObservableList<Room> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {

                Room r = new Room();
                r.setIdR(rs.getInt(1));
                r.setRoomName(rs.getString(2));
                r.setRoomNumber(rs.getInt(3));
                r.setMax_nbr(rs.getInt(4));
                r.setIdgym(rs.getInt(5));
                list.add(r);

            }

        } catch (SQLException ex) {
            System.out.println("error in sort room");
            Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    @Override
    public List<Room> Sortnumber() {
        String req = "select * from room ORDER BY roomNumber ASC";
        ObservableList<Room> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {

                Room r = new Room();
                r.setIdR(rs.getInt(1));
                r.setRoomName(rs.getString(2));
                r.setRoomNumber(rs.getInt(3));
                r.setMax_nbr(rs.getInt(4));
                r.setIdgym(rs.getInt(5));
                list.add(r);

            }

        } catch (SQLException ex) {
            System.out.println("error in sort1 room");
            Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    @Override
    public List<Room> Sortcapacity() {
        String req = "select * from room ORDER BY max_nbr DESC";
        ObservableList<Room> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {

                Room r = new Room();
                r.setIdR(rs.getInt(1));
                r.setRoomName(rs.getString(2));
                r.setRoomNumber(rs.getInt(3));
                r.setMax_nbr(rs.getInt(4));
                r.setIdgym(rs.getInt(5));
                list.add(r);

            }

        } catch (SQLException ex) {
            System.out.println("error in sort2 room");
            Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }


}
