/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.db;

import com.mycompany.avventuratestuale_cheesywizards.type.GameStatus;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nico0
 */
public class DBManager {
    
    final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS adventure_user (email VARCHAR(50), username VARCHAR(35), password VARCHAR(20), savings BLOB, PRIMARY KEY (email))";
    
    /**
     * 
     */
    public DBManager() {
        try{
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");

            Statement stm = conn.createStatement();
            stm.executeUpdate(CREATE_TABLE);
            stm.close();
            conn.close();
        } catch(SQLException ex){
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
    }
    
    /**
     * Restituisce true se l'utente esiste, false altrimenti
     * @param username
     * @param password
     * @return 
     */
    public boolean is_user_existent(String username){
        boolean answer = false;
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM adventure_user "
                    + "WHERE username=?");
            pstm.setString(1, username);
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
    
    /**
     * Funzione che aggiorna il campo 'savings' del database
     * @param username
     * @param password
     * @param saves 
     */
    public void update_savings_on_db(String username, String password, FileInputStream file_to_save) {
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            
            PreparedStatement pstm = conn.prepareStatement("UPDATE adventure_user SET savings=? WHERE username=? AND password=?");
            pstm.setBinaryStream(1, file_to_save);
            pstm.setString(2, username);
            pstm.setString(3, password);
            int rowsAffected = pstm.executeUpdate();
            pstm.close();
            conn.close();
            System.out.println("db aggiornato, righe aggiornate: " + rowsAffected);
            
        }catch(SQLException ex){
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }
    
    /**
     * Funzione che interroga il db in modo da ottenere i salvataggi di un determinato utente in una variabile di tipo byte[].
     * @param username
     * @param password
     * @return 
     */
    public InputStream get_saves_from_db(String username, String password){
        
        InputStream input = null;
        GameStatus saves = new GameStatus();
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM adventure_user "
                    + "WHERE username=? AND password=?");
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()){
                //saves = (GameStatus) rs.getObject("savings");
                input = rs.getBinaryStream("savings");
            }
            
            pstm.close();
            conn.close();
        } catch(SQLException ex){
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
        return input;
    }
    
    /**
     * Funzione che aggiunge nel db un nuovo utente.
     * @param username
     * @param Password 
     */
    public void add_new_user(String email, String username, String password){
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO adventure_user (email, username, password, savings) VALUES (?, ?, ?, NULL)");
            pstm.setString(1, email);
            pstm.setString(2, username);
            pstm.setString(3, password);
            
            
            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nuovo utente inserito con successo!");
            }
            pstm.close();
            conn.close();
            
        } catch(SQLException ex){
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }
    
    /**
     * Funzione che restituisce true se l'username è già presente nel db, false altrimenti.
     * @param username_to_check
     * @return 
     */
    public boolean username_already_exists(String username_to_check){
        boolean answer = false;
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM adventure_user "
                    + "WHERE username=?");
            pstm.setString(1, username_to_check);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                if (username_to_check.compareTo(rs.getString("username"))==0)
                    answer = true;
            }
            pstm.close();
            conn.close();

        }catch(SQLException ex){
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
        return answer;
    }
    
    /**
     * Funzione che restituisce true se l'email è già presente nel db, false altrimenti.
     * @param email_to_check
     * @return 
     */
    public boolean email_already_exists(String email_to_check){
        boolean answer = false;
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM adventure_user "
                    + "WHERE email=?");
            pstm.setString(1, email_to_check);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                if (email_to_check.compareTo(rs.getString("email"))==0)
                    answer = true;
            }
            pstm.close();
            conn.close();

        }catch(SQLException ex){
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
        
        return answer;
    }
    
    /**
     * 
     * @param username
     * @param password
     * @return 
     */
    public boolean is_password_correct(String username, String password){
            boolean answer = false;
        
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM adventure_user "
                    + "WHERE username=?");
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()){
                if (password.compareTo(rs.getString("password"))==0)
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
