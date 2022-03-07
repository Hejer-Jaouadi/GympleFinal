/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Admin_appointment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.Agenda.Appointment;
import utils.ConnexionSingleton;

/**
 *
 * @author Asma
 */
public class AppointmentDao {
    private static AppointmentDao instance;
    private Statement st;
    private ResultSet rs;

    private AppointmentDao() {
        ConnexionSingleton cs = ConnexionSingleton.getInstance();
        try {
            st = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static AppointmentDao getInstance() {
        if (instance == null) {
            instance = new AppointmentDao();
        }
        return instance;
    }
     
    public void insert(Admin_appointment o) {
        System.out.println(o.getStart());
        String req = "insert into appointment (start,start_time,end_time,description,location) values ('" + o.getStart() + "'," + o.getStart_time()+"," + o.getEnd_time() + ",'" 
                + o.getDescription() + "','" + o.getLocation()+ "')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void delete(Admin_appointment o) {
        String req = "delete from appointment where description='" + o.getDescription()+"'";
       
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
         
    }
     private LocalDate parse(String s)
    {
        LocalDate localDate = LocalDate.parse(s);
        return localDate;
    }
     public boolean update(Admin_appointment p) {
        String qry = "UPDATE appointment SET start = '"+p.getStart()+"', end_time = "+p.getEnd_time()+", start_time = "+p.getStart_time()+", description = '"+p.getDescription()+"', location = '"+p.getLocation()+"' WHERE description = '"+p.getDescription()+"'";
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     
     
     public ObservableList<Admin_appointment> displayAll() {
        String req="select * from appointment";
        ObservableList<Admin_appointment> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Admin_appointment p=new Admin_appointment();
                p.setDescription(rs.getString("decription"));
                p.setStart(this.parse(rs.getString("start")));
                p.setEnd_time(rs.getInt("end_time"));
                p.setStart_time(rs.getInt("start_time"));
                p.setLocation(rs.getString("location"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Admin_appointment> displayAllList() {
        String req="select * from membership";
        List<Admin_appointment> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Admin_appointment p=new Admin_appointment();
                p.setDescription(rs.getString("decription"));
                p.setStart(this.parse(rs.getString("start")));
                p.setEnd_time(rs.getInt("end_time"));
                p.setStart_time(rs.getInt("start_time"));
                p.setLocation(rs.getString("location"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Appointment> displayAllLists() {
        String req="select * from appointment";
        List<Appointment> list=new ArrayList<>();
        int t=4;
        int tl=15;
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                t=t+2;
                tl=tl+5;
                list.add(new Agenda.AppointmentImplLocal()
     .withStartLocalDateTime(this.parse(rs.getString("start")).atTime(rs.getInt("start_time"), 00))
     .withEndLocalDateTime(this.parse(rs.getString("start")).atTime(rs.getInt("end_time"), 30))
                        .withSummary(rs.getString("description"))
             .withLocation(rs.getString("location"))
     .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group5")) 
        );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
