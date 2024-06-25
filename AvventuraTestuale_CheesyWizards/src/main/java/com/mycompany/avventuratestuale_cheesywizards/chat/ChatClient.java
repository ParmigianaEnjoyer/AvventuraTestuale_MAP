/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.chat;

/**
 *
 * @author nico0
 */
import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "127.0.0.1"; // Indirizzo del server
    private static final int SERVER_PORT = 12345;

    public void tryToConnect(String user_I_am) {
        
        user_I_am = "Pino";
        
        try {
            System.out.println("Tentativo di connessione al server " + SERVER_ADDRESS + " sulla porta " + SERVER_PORT + "...");
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connesso al server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            // Invio del nome del client al server
            out.println(user_I_am);

            String serverResponse;
            if ((serverResponse = in.readLine()) != null) {
                System.out.println("Server: " + serverResponse);
                if (serverResponse.equals("Nome utente non autorizzato.")) {
                    System.out.println("Connessione chiusa dal server.");
                    socket.close();
                    return;
                }
            }

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                serverResponse = in.readLine();
                System.out.println("Server: " + serverResponse);
                System.out.print("Client: ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
