/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.Gym;
import entity.Member;
import entity.Membership;
import entity.Trainer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ConnexionSingleton;

/**
 *
 * @author wiemhjiri
 */
public class MembershipDao implements Idao<Membership>{
    
    private static MembershipDao instance;
    private Statement st;
    private ResultSet rs;
    
    private MembershipDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MembershipDao getInstance(){
        if(instance==null) 
            instance=new MembershipDao();
        return instance;
    }

    @Override
    public void insert(Membership o) {
       
        String req="insert into membership (expire_date,start_date,type) values ('"+o.getExpire_date()+"','"+o.getStart_date()+"','"+o.getType()+"') ";
        try {
            st.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         o.setIdm(this.getIdMembership());
    } 
    
    public int getIdMembership()
    {
         String req="SELECT * FROM membership ORDER BY idm DESC LIMIT 1";
         int id=0;
         try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
               id=rs.getInt("idm");
            
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return id;
    }

    @Override
    public void delete(Membership o) {
        String req="delete from membership where idm="+o.getIdm();
        Membership p=displayById(o.getIdm());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }

    @Override
    public ObservableList<Membership> displayAll() {
        String req="select * from membership";
        ObservableList<Membership> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Membership p=new Membership();
                p.setIdm(rs.getInt("id"));
                p.setStart_date(this.parse(rs.getString("start_date")));
                p.setExpire_date(this.parse(rs.getString("expire_date")));
                p.setType(rs.getString("type"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Membership> displayAllList() {
        String req="select * from membership";
        List<Membership> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Membership p=new Membership();
                p.setIdm(rs.getInt("idm"));
                p.setStart_date(this.parse(rs.getString("start_date")));
                p.setExpire_date(this.parse(rs.getString("expire_date")));
                p.setType(rs.getString("type"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public Membership displayById(int id) {
           String req="select * from membership where idm ="+id;
           Membership p=new Membership();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setIdm(rs.getInt("idm"));
                p.setStart_date(this.parse(rs.getString("start_date")));
                p.setExpire_date(this.parse(rs.getString("expire_date")));
                p.setType(rs.getString("type"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    @Override
    public boolean update(Membership p) {
        String qry = "UPDATE membership SET expire_date = '"+p.getExpire_date()+"', start_date = '"+p.getStart_date()+"', type = '"+p.getType()+"' WHERE idm = "+p.getIdm();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    private LocalDate parse(String s)
    {
        LocalDate localDate = LocalDate.parse(s);
        return localDate;
    }
     public void getMembership(Member o) {
        String req="select idm,expire_date,start_date,type from user natural join membership where id="+o.getId();
       Membership m=new Membership();
              try {
           
           
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
               
                m.setIdm(rs.getInt("idm"));
                m.setStart_date(this.parse(rs.getString("start_date")));
                m.setExpire_date(this.parse(rs.getString("expire_date")));
                m.setType(rs.getString("type"));
                o.setMembership(m);
              } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
