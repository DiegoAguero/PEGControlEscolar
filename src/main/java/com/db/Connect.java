package com.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connect {
    public Connect(){}
    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            String URL ="jdbc:mysql://localhost/escuela?autoReconnect=true&useSSL=false";
            String DRIVER ="com.mysql.cj.jdbc.Driver";
            String USER = "root";
            String PASSWORD = "123456";
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    public Connection setConnection(String url, String user, String password) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

}
