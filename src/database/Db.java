package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class Db {
    static Connection conn;
    static String driver = 
            "com.mysql.jdbc.Driver";
    static String url = 
            "jdbc:mysql://127.0.0.1/equity";
    static String uname="root";
    static String pass = "";
    
    public static Connection getConnection() throws Exception{
        if(conn==null){
            conn = DriverManager.getConnection(url, uname, pass);
        }
        return conn;
    }
}
