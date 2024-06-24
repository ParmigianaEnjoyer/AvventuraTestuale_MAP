/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.files;

import com.mycompany.avventuratestuale_cheesywizards.db.DBManager;
import com.mycompany.avventuratestuale_cheesywizards.type.GameStatus;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author nico0
 */
public class FileManager {
    
    /**
     * Funzione che permette di scrivere sul file saves.dat i salvataggi e di caricarli su db chiamando il metodo fatto apposta in DBManager.
     * @param username
     * @param password
     * @param saves 
     */
    public void update_savings_on_file_and_db(String username, String password, GameStatus saves){
        DBManager db = new DBManager();
        System.out.println("Creo il file");
        try {
            System.out.println("Creo il file");
            FileOutputStream outFile = new FileOutputStream("src/main/resources/files/saves.dat");
            ObjectOutputStream outStream = new ObjectOutputStream(outFile);
            outStream.writeObject(saves);

            FileInputStream inFile = new FileInputStream("src/main/resources/files/saves.dat");   
            db.update_savings_on_db(username, password, inFile);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * Funzione che prende i salvataggi da db e li scrive sul file per poi restituirne i valori.
     * @param username
     * @param password
     * @return 
     */
    public GameStatus get_saves_from_file(String username, String password){
        DBManager db = new DBManager();
        GameStatus saves = null;
        
        byte[] blobData = db.get_saves_from_db(username, password);
        
        // Deserializzazione del BLOB in un oggetto GameStatus
        try (ByteArrayInputStream bais = new ByteArrayInputStream(blobData);
             ObjectInputStream ois = new ObjectInputStream(bais)) {

            saves = (GameStatus) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try{
            FileOutputStream outFile = new FileOutputStream("src/main/resources/files/saves.dat");
            ObjectOutputStream outStream = new ObjectOutputStream(outFile);
            outStream.writeObject(saves);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return saves;
    }
    
}
