/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Gym;
import entity.Trainer;
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

/**
 *
 * @author Asma
 */
public class TrainerDao implements Idao<Trainer> {
    
    private static TrainerDao instance;
    private Statement st;
    private ResultSet rs;
    
    private TrainerDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static TrainerDao getInstance(){
        if(instance==null) 
            instance=new TrainerDao();
        return instance;
    }
    
    
    public void insert(Trainer o) {
        String req="insert into user (role,first_name,last_name,email,password,training_level,cost_per_hour,description,experience,gym,block,reports) values ('trainer','"+o.getFirst_name()+"','"+o.getLast_name()+"','"+o.getEmail()+"','"+o.getPassword()+"','"+"','"
                +o.getCost_per_hour()+"','"+o.getDescription()+"','"+o.getExperience()+"','"+o.getGym().getIdG()+"','n"+"',0"+")";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    
    public void delete(Trainer o) {
        String req="delete from user where id="+o.getId();
        Trainer p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }
    
     public void deleteAll() {
        String req="delete from user where role='trainer' ";
        
          
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ObservableList<Trainer> displayAll() {
        String req="select * from user join gym on idG=gym where role='trainer' ";
        ObservableList<Trainer> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                
                Trainer p=new Trainer();
                p.setId(rs.getInt("id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
                p.setCost_per_hour(rs.getFloat("cost_per_hour"));
                p.setDescription(rs.getString("description"));
                p.setExperience(rs.getString("experience"));
                p.setPicture(rs.getString("picture"));
                p.setBlock(rs.getString("block"));
                p.setReports(rs.getInt("reports"));
                p.setGym(new Gym(rs.getInt("idG"),rs.getString("location"),rs.getString("facilities")));
                list.add(p);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public List<Trainer> displayAllList() {
        String req="select * from user natural join gym";
        List<Trainer> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Trainer p=new Trainer();
                p.setId(rs.getInt("id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
                p.setCost_per_hour(rs.getFloat("cost_per_hour"));
                p.setDescription(rs.getString("description"));
                p.setExperience(rs.getString("experience"));
                p.setBlock(rs.getString("block"));
                p.setReports(rs.getInt("reports"));
                p.setGym(new Gym(rs.getInt("gym"),rs.getString("location"),rs.getString("facilities")));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     
    public Trainer displayById(int id) {
           String req="select * from user natural join gym where id ="+id;
           Trainer p=new Trainer();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt("id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
                p.setCost_per_hour(rs.getFloat("cost_per_hour"));
                p.setDescription(rs.getString("description"));
                p.setExperience(rs.getString("experience"));
                p.setReports(rs.getInt("reports"));
                p.setBlock(rs.getString("block"));
                p.setGym(new Gym(rs.getInt("gym"),rs.getString("location"),rs.getString("facilities")));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }
    
    
    public boolean update(Trainer p) {
        String qry = "UPDATE user SET first_name = '"+p.getFirst_name()+"', last_name = '"
                +p.getLast_name()+"', email = '"+p.getEmail()+"', password = '"+p.getPassword()
                +"', cost_per_hour = '"
                +p.getCost_per_hour()+"', description = '"+p.getDescription()+"', experience = '"
                +p.getExperience()+"', gym = '"+p.getGym().getIdG()+"', block = '"+p.getBlock()+"', reports = "+p.getReports()+" WHERE id = "+p.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void getGym(Trainer o) {
        String req="select idG,location,facilities from user natural join gym where id="+o.getId();
       Gym g=new Gym();
              try {
           
           
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                g.setIdG(rs.getInt("idG"));
                g.setFacilities(rs.getString("facilities"));
                g.setLocation(rs.getString("location"));
                o.setGym(g);
             
              } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
