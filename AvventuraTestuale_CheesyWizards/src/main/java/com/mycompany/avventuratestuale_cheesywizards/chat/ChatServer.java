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

public class ChatServer {
    private static final int PORT = 12345;

    public void waitUserToConnect(String user_I_want) {
        
        user_I_want = "Alice"; // debug
        
        System.out.println("Server avviato...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("In attesa di connessioni sulla porta " + PORT + "...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connessione in ingresso...");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientName = in.readLine();
                System.out.println("Nome client ricevuto: " + clientName);

                if (user_I_want.equals(clientName)) {
                    System.out.println("Client autorizzato!");
                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Client: " + inputLine);
                        System.out.print("Server: ");
                        String userInput = stdIn.readLine();
                        out.println(userInput);
                    }
                } else {
                    System.out.println("Client non autorizzato. Connessione chiusa.");
                    out.println("Nome utente non autorizzato.");
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
