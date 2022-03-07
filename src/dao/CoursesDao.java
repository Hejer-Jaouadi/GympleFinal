/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import entity.Courses;
import java.sql.PreparedStatement;
import java.util.Date;
import utils.ConnexionSingleton;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wiemhjiri
 */
public class CoursesDao implements Idao<Courses> {

    public static CoursesDao instance;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    TableView tv;

        
   private CoursesDao()  {
        ConnexionSingleton cs = ConnexionSingleton.getInstance();
        try {
            st = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CoursesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static CoursesDao getInstance()  {
        if (instance == null) {
            instance = new CoursesDao();
        }
        return instance;
    }

    @Override
    public void insert(Courses o) {
        
        
        String req="insert into course (date, start_time, end_time, nbr, category, planning, trainer) values ('"+o.getDate()+"','"+o.getCoursBegin()+"','"+o.getCoursEnd()+"',"+o.getPlaces()+",'"+o.getCategory()+"','"+o.getPlanning()+"','"+o.getTrainer()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CoursesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Courses o) {
        
        String req = "delete from course where id=" + o.getId();
        

        
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(CoursesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

    @Override
    public ObservableList<Courses> displayAll() {
        ObservableList<Courses> list = FXCollections.observableArrayList();
        String req = "select * from course";
        

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                
                Courses p = new Courses();
                p.setId(rs.getInt("id"));
                p.setDate(rs.getString("date"));
                p.setCoursBegin(rs.getString("start_time"));
                p.setCoursEnd(rs.getString("end_time"));
                p.setPlaces(rs.getInt("nbr"));
                p.setCategory(rs.getString("category"));
                p.setPlanning(rs.getString("planning"));
                p.setTrainer(rs.getString("trainer"));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoursesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Courses> displayAllList() {
        String req = "select * from Course";
        List<Courses> list = new ArrayList<>();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Courses p = new Courses();
                p.setId(rs.getInt("id"));
                p.setDate(rs.getString("date"));
                p.setCoursBegin(rs.getString("begin_time"));
                p.setCoursEnd(rs.getString("end_time"));
                p.setPlaces(rs.getInt("nbr"));
                p.setCategory(rs.getString("category"));
                p.setPlanning(rs.getString("planning"));
                p.setTrainer(rs.getString("trainer"));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoursesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Courses displayById(int id) {
        String req = "select * from Course where id =" + id;
        Courses p = new Courses();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            p.setId(rs.getInt("id"));
            p.setDate(rs.getString("date"));
            p.setCoursBegin(rs.getString("begin_time"));
            p.setCoursEnd(rs.getString("end_time"));
            p.setPlaces(rs.getInt("nbr"));
            p.setCategory(rs.getString("category"));
            p.setPlanning(rs.getString("planning"));
            p.setTrainer(rs.getString("trainer"));

            //}  
        } catch (SQLException ex) {
            Logger.getLogger(CoursesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean update(Courses p) {
        String qry = "UPDATE course SET date='" + p.getDate() + "', start_time = '" + p.getCoursBegin() + "', end_time = '" + p.getCoursEnd() + "', nbr = " + p.getPlaces() + ", category = '" + p.getCategory() + "', planning = '" + p.getPlanning() + "', trainer = '" + p.getTrainer() + "' WHERE id = " + p.getId();

        try {
            if (st.executeUpdate(qry) > 0) {

                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(CoursesDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    private Statement prepareStatement(String insert_into_course_date_start_time_end_time_nbr_category_planning_trainer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
