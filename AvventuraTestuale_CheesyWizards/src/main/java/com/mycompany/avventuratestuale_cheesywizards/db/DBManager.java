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
    
    final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS adventure_user (username VARCHAR(35), password VARCHAR(20), savings BLOB, PRIMARY KEY (username, password))";
    
    /**
     * 
     */
    public DBManager() {
    }
    
    /**
     * Restituisce true se l'utente esiste, false altrimenti
     * @param username
     * @param password
     * @return 
     */
    public boolean is_user_existent(String username, String password){
        boolean answer = false;
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            Statement stm = conn.createStatement();
            stm.executeUpdate(CREATE_TABLE);
            stm.close();
            
            /*stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO adventure_user VALUES ('pippo','1234',NULL)");
            stm.close();*/
            
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM adventure_user "
                    + "WHERE username=? AND password=?");
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                answer = true;
            }
            pstm.close();
            conn.close();
            
        } catch(SQLException ex){
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
        return answer;
    }
    
    /**
     * Restituisce true se l'utente ha dei salvataggi, false altrimenti
     * @param username
     * @param password
     * @return 
     */
    public boolean user_has_savings(String username, String password){
        boolean answer = false;
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM adventure_user "
                    + "WHERE username=? AND password=?");
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                if (rs.getObject("savings") != null)
                    answer = true;
            }
            pstm.close();
            conn.close();

        }catch(SQLException ex){
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
        return answer;
    }
}
