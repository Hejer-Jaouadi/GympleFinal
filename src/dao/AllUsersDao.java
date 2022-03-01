/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import entity.Member;
import entity.Trainer;
import entity.User;
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
 * @author wiemhjiri
 */
public class AllUsersDao {
    
    private static AllUsersDao instance;
    private Statement st;
    private ResultSet rs;
    
    public AllUsersDao() {
       
    }
    

    
    public void insert(User o) {
        String req="";
        if (o instanceof Member)
        {
            Member m=(Member)o;
            req="insert into user (role,first_name,last_name,email,password,id_card,height,weight,training_level,membership) values "
                + "('member','"+m.getFirst_name()+"','"+m.getLast_name()+"','"+m.getEmail()+"','"+m.getPassword()+"','"+m.getId_card()+"','"+m.getHeight()+"','"
                +m.getWeight()+"','"+m.getTraining_level()+"','"+m.getMembership().getIdm()+"')";
        }
        else if (o instanceof Trainer)
            
        {
            Trainer t=(Trainer)o;
            req="insert into user (role,first_name,last_name,email,password,training_level,cost_per_hour,description,experience,gym) values ('trainer','"+o.getFirst_name()+"','"+o.getLast_name()+"','"+o.getEmail()+"','"+o.getPassword()+"','"+"','"
                +t.getCost_per_hour()+"','"+t.getDescription()+"','"+t.getExperience()+"','"+t.getGym().getIdG()+"')";
        }
        else{
          req="insert into user (role,first_name,last_name,email,password) values ('admin','"+o.getFirst_name()+"','"+o.getLast_name()+"','"+o.getEmail()+"','"+o.getPassword()+"')";

        }
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    
    public void delete(User o) {
        String req="delete from user where id="+o.getId();
        User p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }
    
   
    public boolean update(User p) {
        String qry="";
        if(p instanceof Trainer)
        {
            Trainer t=(Trainer)p;
            qry = "UPDATE user SET first_name = '"+p.getFirst_name()+"', last_name = '"
                +p.getLast_name()+"', email = '"+p.getEmail()+"', password = '"+p.getPassword()
                +"', cost_per_hour = '"
                +t.getCost_per_hour()+"', description = '"+t.getDescription()+"', experience = '"
                +t.getExperience()+"', gym = '"+t.getGym().getIdG()+"' WHERE id = "+p.getId();
        }
        else if(p instanceof Member){
            Member m=(Member)p;
            qry = "UPDATE user SET first_name = '"+p.getFirst_name()+"', last_name = '"+p.getLast_name()
                +"', email = '"+p.getEmail()+"', password = '"+p.getPassword()+"', id_card = '"+m.getId_card()
                +"', height = '"+m.getHeight()+"', weight = '"+m.getWeight()+"', training_level = '"
                +m.getTraining_level()+"' WHERE id = "+p.getId();
        }
        else{
         qry = "UPDATE user SET first_name = '"+p.getFirst_name()+"', last_name = '"+p.getLast_name()+"', email = '"+p.getEmail()+"', password = '"+p.getPassword()+"' WHERE id = "+p.getId();
                }
        try {
            if (st.executeUpdate(qry) > 0) {
                
                return true;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }

    
    public User displayById(int id) {
           String req="select * from user where id ="+id;
           User p=new User();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt("id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
               
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    
    
}
