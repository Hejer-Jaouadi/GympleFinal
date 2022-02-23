/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnexion {
    private String url="jdbc:mysql://localhost:3306/gymple";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static MyConnexion instance;

    public Connection getCnx() {
        return cnx;
    }
    
    
    private MyConnexion() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion is done successfully ! ");
        } catch (SQLException ex) {
           // Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }
    
   public static MyConnexion getInstance(){
       
       if(instance==null)
           instance=new MyConnexion();
       return instance;
   }
    
    
    
    
}
