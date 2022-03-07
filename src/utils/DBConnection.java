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
 * @author amorl
 */
public class DBConnection {
    private static final String url="jdbc:mysql://localhost:3306/gymple_db";
    private static final String login="root";
    private static final String pwd="";
    private static Connection conn;
    private static DBConnection dbConnection;

    public Connection getConnection() throws ClassNotFoundException{
        return conn;
    }
    
    
    public static void dbConnect() throws SQLException {
        try {
            conn = DriverManager.getConnection(url, login, pwd);
            System.out.println("++++++++++++++++++++++ Connection established successfully ! ++++++++++++++++++++++");
        } catch (SQLException e) {
            System.out.println("++++++++++++++++++++++ Connection Failed! Check output console ++++++++++++++++++++" + e);
            throw e;
        }
    }
    
    //Close Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e){
           throw e;
        }
    }
    
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return  dbConnection;
    }
}
