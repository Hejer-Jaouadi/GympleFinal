/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Courses;
import entity.Planning;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ConnexionSingleton;

/**
 *
 * @author Adnene
 */
public class PlanningDao implements Idao<Planning> {

    private static PlanningDao instance;
    private Statement st;
    private ResultSet rs;
    

    private PlanningDao() throws ClassNotFoundException {
        ConnexionSingleton cs = ConnexionSingleton.getInstance();
        try {
            st = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PlanningDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PlanningDao getInstance() throws ClassNotFoundException {
        if (instance == null) {
            instance = new PlanningDao();
        }
        return instance;
    }

    @Override
    public void insert(Planning o) {
        Planning p = new Planning();

        try {
            String req = "insert into planning (start_date, end_date, gym) "
                    + "values (" + p.getPlanningBegin() + ", " + p.getPlanningEnd() + ", " + p.getGym() ;

            st.executeUpdate(req);
            //JOptionPane.showMessageDialog(this, "cours added successfully");
        } catch (SQLException ex) {
            Logger.getLogger(PlanningDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Planning o) {
        String req = "delete from Planning where id=" + o.getId();
        Planning p = displayById(o.getId());

        if (p != null) {
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(PlanningDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("doesen't exist");
        }
    }

    @Override
    public ObservableList<Planning> displayAll() {
        String req = "select * from planning";
        ObservableList<Planning> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Planning p = new Planning();
                p.setId(rs.getInt("id"));
                p.setPlanningBegin(rs.getDate("start_date"));
                p.setPlanningEnd(rs.getDate("end_date"));
                p.setGym(rs.getString("gym"));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlanningDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Planning> displayAllList() {
        String req = "select * from Planning";
        List<Planning> list = new ArrayList<>();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Planning p = new Planning();
                p.setId(rs.getInt("id"));
                p.setPlanningBegin(rs.getDate("start_date"));
                p.setPlanningEnd(rs.getDate("end_date"));
                p.setGym(rs.getString("gym"));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlanningDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Planning displayById(int id) {
        String req = "select * from planning where id =" + id;
        Planning p = new Planning();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            p.setId(rs.getInt("id"));
            p.setPlanningBegin(rs.getDate("start_date"));
            p.setPlanningEnd(rs.getDate("end_date"));
            p.setGym(rs.getString("gym"));

        } catch (SQLException ex) {
            Logger.getLogger(PlanningDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean update(Planning p) {
        String qry = "UPDATE planning SET start_date = '" + p.getPlanningBegin() + "', end_date = '" + p.getPlanningEnd() + "', gym = '" + p.getGym() + "' WHERE id = " + p.getId() ;

        try {
            if (st.executeUpdate(qry) > 0) {

                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(PlanningDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    private Statement prepareStatement(String insert_into_course_start_date_end_date_gym) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
