/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosdev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hannah
 */
public class DB {
    
    public static Connection con = DB.getCon("root", "0987");
    
    private static Connection getCon(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/prosdev";

        System.out.println("Connecting database...");
        
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            return con;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    
}
