package com.parking_spot_finder_app.parking_spot_finder_app;
import java.sql.*;
public class DATABASE_ORACLE {
    // Establish the database connection
    static String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // replace 'yourDB' with your actual database name
    static String user = "system"; // replace with your database username
    static String password = "Oracle_1"; // replace with your database password
    public static Connection connection(){
try {
            Connection con = DriverManager.getConnection(dbUrl, user, password);
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}