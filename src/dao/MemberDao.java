/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Member;
import entity.Membership;
import utils.ConnexionSingleton;
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

/**
 *
 * @author Asma
 */
public class MemberDao extends AllUsersDao implements Idao<Member>  {
    
    private static MemberDao instance;
    private Statement st;
    private ResultSet rs;
    
    private MemberDao() {
        super();
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MemberDao getInstance(){
        if(instance==null) 
            instance=new MemberDao();
        return instance;
    }
    
    
    public void insert(Member o) {
        String req="insert into user (role,first_name,last_name,email,password,id_card,height,weight,training_level,membership,block) values "
                + "('member','"+o.getFirst_name()+"','"+o.getLast_name()+"','"+o.getEmail()+"','"+o.getPassword()+"','"+o.getId_card()+"','"+o.getHeight()+"','"
                +o.getWeight()+"','"+o.getTraining_level()+"','"+o.getMembership().getIdm()+"','n"+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    
    public void delete(Member o) {
        String req="delete from user where id="+o.getId();
        Member p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }
    
    
    public ObservableList<Member> displayAll() {
        String req="select * from user join membership on membership=idm where role='member'";
        ObservableList<Member> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Member p=new Member();
                p.setId(rs.getInt("id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
                p.setId_card(rs.getInt("id_card"));
                p.setHeight(rs.getFloat("height"));
                p.setWeight(rs.getFloat("weight"));
                p.setBlock(rs.getString("block"));
                p.setPicture(rs.getString("picture"));
                p.setTraining_level(rs.getString("training_level"));
                p.setMembership(new Membership(rs.getInt("idm"),this.parse(rs.getString("expire_date")),this.parse(rs.getString("start_date")),rs.getString("type")));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Member> displayAllList() {
        String req="select * from user join membership on membership=idm where user.role='member'";
        List<Member> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Member p=new Member();
                p.setId(rs.getInt("id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
                p.setId_card(rs.getInt("id_card"));
                p.setHeight(rs.getFloat("height"));
                p.setWeight(rs.getFloat("weight"));
                p.setBlock(rs.getString("block"));
                p.setTraining_level(rs.getString("training_level"));
                p.setMembership(new Membership(rs.getInt("idm"),this.parse(rs.getString("expire_date")),this.parse(rs.getString("start_date")),rs.getString("type")));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public Member displayById(int id) {
           String req="select * from user natural join membership where id ="+id;
           Member p=new Member();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt("id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));
                p.setId_card(rs.getInt("id_card"));
                p.setHeight(rs.getFloat("height"));
                p.setWeight(rs.getFloat("weight"));
                p.setBlock(rs.getString("block"));
                p.setTraining_level(rs.getString("training_level"));
                p.setMembership(new Membership(rs.getInt("idm"),this.parse(rs.getString("expire_date")),this.parse(rs.getString("start_date")),rs.getString("type")));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }
    
    
    public boolean update(Member p) {
        String qry = "UPDATE user SET first_name = '"+p.getFirst_name()+"', last_name = '"+p.getLast_name()
                +"', email = '"+p.getEmail()+"', password = '"+p.getPassword()+"', id_card = '"+p.getId_card()
                +"', height = '"+p.getHeight()+"', weight = '"+p.getWeight()+"', training_level = '"
                +p.getTraining_level()+"', block = '"
                +p.getBlock()+"' WHERE id = "+p.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     private LocalDate parse(String s)
    {
        LocalDate localDate = LocalDate.parse(s);
        return localDate;
    }
}
