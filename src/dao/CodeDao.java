/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionSingleton;

/**
 *
 * @author Asma
 */
public class CodeDao {
    private static CodeDao instance;
    private Statement st;
    private ResultSet rs;
    
    private CodeDao() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static CodeDao getInstance(){
        if(instance==null) 
            instance=new CodeDao();
        return instance;
    }
    public Boolean check_code (int code,String email)
    {
         String req="SELECT * FROM user where code="+code+" and email='"+email+"'";
         try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            if(rs.next())
               return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MembershipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }
    
 
    public boolean put_code(int code,String email) {
        String qry = "UPDATE user set code= "+code+" where email = '"+email+"'";
        
        try {
            if (st.executeUpdate(qry) > 0) {
                
                return true;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
}
