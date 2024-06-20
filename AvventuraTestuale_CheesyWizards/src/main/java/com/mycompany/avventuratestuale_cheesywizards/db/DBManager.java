/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author nico0
 */
public class DBManager {
    
    final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS user (username VARCHAR(35), password VARCHAR(20), PRIMARY KEY (username, password))";
    
    /**
     * 
     */
    public DBManager() {
    }

    /**
     * 
     */
    public void connect_to_db(){
        
        
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            
            Statement stm = conn.createStatement();
            stm.executeUpdate(CREATE_TABLE);
            stm.close();
            System.out.println("database connesso");
            
        } catch (SQLException ex) {
            
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
        
        
    }
    
}
