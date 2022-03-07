/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author amorl
 */
public class CrudUtils {
    
    private static PreparedStatement getPreparedStatement(String sql, Object... params) throws Exception {
        
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1, params[i]);
        }
        return pstm;
    }
    
    
    public static ResultSet executeQuery(String sql, Object... params) throws SQLException, ClassNotFoundException, Exception {        
        try {          
            return getPreparedStatement(sql, params).executeQuery();
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        }   
    }
    
    public static int executeUpdate(String sql, Object... params) throws SQLException, ClassNotFoundException, Exception {
        try {
            //Connect to DB (Establish Oracle Connection)
            return getPreparedStatement(sql, params).executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e; 
        }  
    }

    
}
    
       

