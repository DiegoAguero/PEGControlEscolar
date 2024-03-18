package com.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connect {
    public Connect(){}
    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("config/db.properties"));
            String URL = props.getProperty("jdbc:mysql://localhost/escuela");
            String DRIVER = props.getProperty("com.mysql.cj.jdbc.Driver");
            String USER = props.getProperty("ROOT");
            String PASSWORD = props.getProperty("123456");
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | IOException ex) {
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
