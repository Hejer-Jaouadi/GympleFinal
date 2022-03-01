/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asma
 */
public class ConnexionSingleton {
    private String url="jdbc:mysql://localhost:3306/gym_db";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static ConnexionSingleton instance;

    public Connection getCnx() {
        return cnx;
    }
    
    
    private ConnexionSingleton() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("ok");
        } catch (SQLException ex) {
            //Logger.getLogger(ConnexSingleton.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
   public static ConnexionSingleton getInstance(){
       
       if(instance==null)
           instance=new ConnexionSingleton();
       return instance;
   }
}
