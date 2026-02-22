package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
     static String url="jdbc:mysql://localhost:3306/oto_db";
     static String user="root";
     static String pass="root";
   static Connection con=null;
    public static Connection getConnection(){
        try{
            con= DriverManager.getConnection(url,user,pass);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(){
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
