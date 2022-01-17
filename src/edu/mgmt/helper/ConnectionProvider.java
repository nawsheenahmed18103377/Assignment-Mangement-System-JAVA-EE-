package edu.mgmt.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;

public class ConnectionProvider {

    public static Connection con;

    public static Connection getConnection(){
        try{
            if (con==null){
                //Driver Class Load
                Class.forName("com.mysql.jdbc.Driver");
                // Create connection
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment_mgmt?serverTimezone=UTC", "root", "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }



}
