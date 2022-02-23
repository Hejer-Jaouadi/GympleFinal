/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.dao;

import com.gymple.entity.Gym;
import com.gymple.entity.Room;
import com.gymple.utils.MyConnexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class RoomCrud implements IdaoR<Room>{

    private static RoomCrud instance;
    private Statement st;
    private ResultSet rs;

    private RoomCrud() {
        MyConnexion cs = MyConnexion.getInstance();
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
    public void insertRoom() {
         String req = "insert into room (roomName,roomNumber) values ('Yoga','2')";
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
     String req = "insert into room (roomName,roomNumber) values "
                + "('" + o.getRoomName()+ "','" + o.getRoomNumber() + "')";
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
         String qry = "UPDATE room SET roomName = '" + r.getRoomName()+ "', roomNumber = '" + r.getRoomNumber()+ "' WHERE idR = " + r.getIdR();

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
    public boolean modifyRoom(int id,String roomName,String roomNumber) {
        String qry = "UPDATE room SET roomName = '" + roomName + "', roomNumber = '" + roomNumber + "' WHERE idR = " + id;

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
    
    
}
