/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.dao;

import com.gymple.entity.Equipment;
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


public class EquipmentCrud implements IdaoE<Equipment>{

    private static EquipmentCrud instance;
    private Statement st;
    private ResultSet rs;

    private EquipmentCrud() {
        MyConnexion cs = MyConnexion.getInstance();
        try {
            st = cs.getCnx().createStatement();
           // System.out.println("connexion successful");
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentCrud.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }

    public static EquipmentCrud getInstance() {
        if (instance == null) {
            instance = new EquipmentCrud();
        }
        return instance;
    }

    
    
    
    @Override
    public void insertEquipment() {
 String req = "insert into equipment (equipmentName,purpose,quantity) values ('trdmile','running','45')";
        try {
            st.executeUpdate(req);
            System.out.println("equipment added successfully");
        } catch (SQLException ex) {
            //Logger.getLogger(EquipmentCrud.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error in insert equipment");
            System.err.println(ex.getMessage());

        }

    }

    @Override
    public void insertEquipment2(Equipment o) {
 String req = "insert into equipment (equipmentName,purpose,quantity) values "
                + "('" + o.getEquipmentName()+ "','" + o.getPurpose()+ "','" + o.getQuantity()+ "')";
        try {
            st.executeUpdate(req);
            System.out.println("equipment added successfully");
        } catch (SQLException ex) {
            //Logger.getLogger(CrudRoom.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error in insert equipment 2");
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Equipment> displayEquipment() {
       String req = "select * from equipment";
        ObservableList<Equipment> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                
                Equipment e = new Equipment();
                e.setIdE(rs.getInt(1));
                e.setEquipmentName(rs.getString(2));
                e.setPurpose(rs.getString(3));
                e.setQuantity(rs.getInt(4));
                list.add(e);

            }

        } catch (SQLException ex) {
            System.out.println("error in display equipment");
            Logger.getLogger(EquipmentCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public boolean updateEquipment(Equipment e) {
          String qry = "UPDATE equipment SET equipmentName = '" + e.getEquipmentName()+ "', purpose = '" + e.getPurpose()+ "', quantity = '" + e.getQuantity()+ "' WHERE idE = " + e.getIdE();

        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("error in update equipment");
            Logger.getLogger(EquipmentCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Equipment displayByIdEquipment(int id) {
        
 String req = "select * from equipment where idE =" + id;
        Equipment e = new Equipment();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            e.setIdE(rs.getInt(1));
            e.setEquipmentName(rs.getString(2));
            e.setPurpose(rs.getString(3));
            e.setQuantity(rs.getInt(4));
            //}  
        } catch (SQLException ex) {
            System.out.println("equipment does not exist");
            System.err.println(ex.getMessage());
            // Logger.getLogger(EquipmentCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    @Override
    public void deleteEquipment(Equipment o) {
String req = "delete from equipment where idE=" + o.getIdE();

        Equipment e = displayByIdEquipment(o.getIdE());

        if (e != null) {
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                System.out.println("error in delete equipment");
                System.err.println(ex.getMessage());
                // Logger.getLogger(EquipmentCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("doesn't exist");
        }
    }

    @Override
    public boolean modifyEquipment(int id, String equipmentName, String purpose, int quantity) {
        String qry = "UPDATE equipment SET equipmentName = '" + equipmentName + "', purpose = '" + purpose + "', quantity = '" + quantity + "' WHERE idE = " + id;

        try {
              st.executeUpdate(qry);
            System.out.println("equipment modified successfully");
                return true;
            

        } catch (SQLException ex) {
            System.out.println("error in modify equipment");
            Logger.getLogger(RoomCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }    
}
    

