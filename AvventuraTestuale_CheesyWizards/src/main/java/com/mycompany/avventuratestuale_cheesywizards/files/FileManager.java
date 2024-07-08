/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.files;

import com.mycompany.avventuratestuale_cheesywizards.db.DBManager;
import com.mycompany.avventuratestuale_cheesywizards.type.GameStatus;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            System.out.println("Creo il file");
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/files/saves.dat");
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(saves);

            FileInputStream fileIn = new FileInputStream("src/main/resources/files/saves.dat");   
            db.update_savings_on_db(username, password, fileIn);
            
            fileOut.close();
            outStream.close();
            fileIn.close();
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
        if(Files.notExists(Paths.get("src/main/resources/files/saves.dat"))){
            try {
                Files.createFile(Paths.get("src/main/resources/files/saves.dat"));
                System.out.println("File creato con successo");
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //prendo il file dal db
        db.get_saves_from_db(username, password);
        
        //deserializzo il file
        try (FileInputStream fileIn = new FileInputStream("src/main/resources/files/saves.dat");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            // Deserializzazione dell'oggetto GameStatus
            saves = (GameStatus) objectIn.readObject();
            // Stampa dell'oggetto deserializzato
            System.out.println("Oggetto GameStatus deserializzato: " + saves);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Stampa dell'oggetto deserializzato
        System.out.println("Oggetto GameStatus deserializzato: " + saves);
        
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
