/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.files;

import com.mycompany.avventuratestuale_cheesywizards.db.DBManager;
import com.mycompany.avventuratestuale_cheesywizards.type.GameStatus;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        try {
            InputStream input = db.get_saves_from_db(username, password);
            File file = new File("src/main/resources/files/saves.dat");
            FileOutputStream fos = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            while (input.read(buffer) > 0) {
                fos.write(buffer);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        //deserializzazione
        try (FileInputStream fileIn = new FileInputStream("src/main/resources/files/saves.dat");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            // Deserializzazione dell'oggetto GameStatus
            saves = (GameStatus) objectIn.readObject();

            // Stampa dell'oggetto deserializzato
            System.out.println("Oggetto GameStatus deserializzato: " + saves);

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
