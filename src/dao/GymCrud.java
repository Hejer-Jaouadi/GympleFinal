/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Gym;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GymCrud implements IdaoG<Gym> {

    private static GymCrud instance;
    private Statement st;
    private ResultSet rs;

    private GymCrud() {
        ConnexionSingleton cs = ConnexionSingleton.getInstance();
        try {
            st = cs.getCnx().createStatement();
            System.out.println("connexion successful");
        } catch (SQLException ex) {
            Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }

    public static GymCrud getInstance() {
        if (instance == null) {
            instance = new GymCrud();
        }
        return instance;
    }

    @Override
    public void insertGym() {
        String req = "insert into gym (location,facilities) values ('bardo','swimpool')";
        try {
            st.executeUpdate(req);
            System.out.println("gym added successfully");
        } catch (SQLException ex) {
            //Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error in insert gym");
            System.err.println(ex.getMessage());

        }

    }

    @Override
    public void insertGym2(Gym o) {
        String req = "insert into gym (location,facilities) values "
                + "('" + o.getLocation() + "','" + o.getFacilities() + "')";
        try {
            st.executeUpdate(req);
            System.out.println("gym added successfully");
        } catch (SQLException ex) {
            //Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error in insert gym 2");
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public List<Gym> displayGym() {
        String req = "select * from gym";
        ObservableList<Gym> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {

                Gym g = new Gym();
                g.setIdG(rs.getInt(1));
                g.setLocation(rs.getString(2));
                g.setFacilities(rs.getString(3));
                list.add(g);

            }

        } catch (SQLException ex) {
            System.out.println("error in display gym");
            Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public List<Gym> displayGymwithoutid() {
        String req = "select location,facilities from gym";

        ObservableList<Gym> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {

                Gym g = new Gym(req, req);

                g.setLocation(rs.getString(1));
                g.setFacilities(rs.getString(2));

                list.add(g);

            }

        } catch (SQLException ex) {
            System.out.println("error in display gym");
            //Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return list;

    }

    @Override
    public boolean updateGym(Gym g) {

        String qry = "UPDATE gym SET location = '" + g.getLocation() + "', facilities = '" + g.getFacilities() + "' WHERE idG = " + g.getIdG();

        try {
            if (st.executeUpdate(qry) > 0) {
                System.out.println("update");
                return true;

            }

        } catch (SQLException ex) {
            System.out.println("error in update gym");
            Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Gym displayByIdGym(int id) {
        String req = "select * from gym where idG =" + id;
        Gym g = new Gym();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            g.setIdG(rs.getInt(1));
            g.setLocation(rs.getString(2));
            g.setFacilities(rs.getString(3));
            //}  
        } catch (SQLException ex) {
            System.out.println("gym does not exist");
            System.err.println(ex.getMessage());
            // Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;

    }

    @Override
    public void deleteGym(Gym o) {
        String req = "delete from gym where idG=" + o.getIdG();

        Gym g = displayByIdGym(o.getIdG());

        if (g != null) {
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                System.out.println("error in delete gym");
                System.err.println(ex.getMessage());
                // Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("doesn't exist");
        }

    }

    @Override
    public void searchByLocation(String location) {
        String req = "select * from gym where location='" + location + "'";

        try {
            rs = st.executeQuery(req);
            rs.last();
            int nbrRow = rs.getRow();
            if (nbrRow != 0) {
                System.out.println("gym found");
            } else {
                System.out.println("gym not found");
            }

        } catch (SQLException ex) {
            //Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("error searchbylocation");
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public boolean modifyGym(int id, String location, String facilities) {
        String qry = "UPDATE gym SET location = '" + location + "', facilities = '" + facilities + "' WHERE idG = " + id;

        try {
            st.executeUpdate(qry);
            System.out.println("gym modified successfully");
            return true;

        } catch (SQLException ex) {
            System.out.println("error in modify gym");
            Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public Gym displayByIdGym(String idGym) {

        String req = "select * from gym where idG =" + idGym;
        Gym g = new Gym();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            g.setIdG(rs.getInt(1));
            g.setLocation(rs.getString(2));
            g.setFacilities(rs.getString(3));
            //}  
        } catch (SQLException ex) {
            System.out.println("gym does not exist");
            System.err.println(ex.getMessage());
            // Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /*  public void modifyGym(Gym gym) {
       
String qry = "UPDATE gym SET location = '" + location + "', facilities = '" + facilities + "' WHERE idG = " + id;

        try {
              st.executeUpdate(qry);
            System.out.println("gym modified successfully");
                return true;
            

        } catch (SQLException ex) {
            System.out.println("error in modify gym");
            Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
    public boolean modifyGym(String idGym, String location, String facility) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String qry = "UPDATE gym SET location = '" + location + "', facilities = '" + facility + "' WHERE idG = " + idGym;

        try {
            st.executeUpdate(qry);
            System.out.println("gym modified successfully");
            return true;

        } catch (SQLException ex) {
            System.out.println("error in modify gym");
            Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ObservableList<Integer> ListId() {

        ObservableList<Integer> listID = FXCollections.observableArrayList();
        String req = "select idG from gym";
        try {

            rs = st.executeQuery(req);
            //  rs = st.executeUpdate(requete3);

            while (rs.next()) {
                listID.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listID;

    }

    public List<Gym> SearchGym(String recherche) {
        //  List<Gym> myList = new ArrayList();
        ObservableList<Gym> list = FXCollections.observableArrayList();
        try {
            String req = "SELECT * \n"
                    + "FROM gym AS g,gym \n"
                    + " WHERE  g.idG LIKE '%" + recherche + "%' OR\n"
                    + "         g.location LIKE '%" + recherche + "%' OR\n"
                    + "           g.facilities LIKE '%" + recherche + "%'";

            rs = st.executeQuery(req);

            Gym g = new Gym();

            rs.next();
            g.setIdG(rs.getInt(1));
            g.setLocation(rs.getString(2));
            g.setFacilities(rs.getString(3));

            list.add(g);

        } catch (SQLException ex) {
            System.err.println("search error");
            System.out.println(ex.getMessage());
        }
        return list;
    }
     public ObservableList<Gym> getGyms() {
        String req = "select * from gym";
        ObservableList<Gym> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                
                Gym g = new Gym();
                g.setIdG(rs.getInt(1));
                g.setLocation(rs.getString(2));
                g.setFacilities(rs.getString(3));
                list.add(g);

            }
             

        } catch (SQLException ex) {
            System.out.println("error in display gym");
            Logger.getLogger(GymCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

}
