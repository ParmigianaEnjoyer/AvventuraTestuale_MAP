/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.chat;

import com.mycompany.avventuratestuale_cheesywizards.db.DBManager;
import com.mycompany.avventuratestuale_cheesywizards.type.Users;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nico0
 */
public class ServerFrame extends javax.swing.JFrame {

    private PrintWriter out;
    private static final int PORT = 12345; // Porta del server
    private Users user = null;
    private Socket clientSocket;
    private ServerSocket serverSocket;
    
    /**
     * Creates new form chatFrame
     */
    public ServerFrame(Users user_info) {
        this.user = user_info;
        initComponents();
        setLocationRelativeTo(null);
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();
        email_field = new javax.swing.JTextField();
        send_button = new javax.swing.JButton();
        chiama_button = new javax.swing.JButton();
        closeConn_button = new javax.swing.JButton();
        label_messaggio = new javax.swing.JLabel();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        messageArea.setEditable(false);
        messageArea.setBackground(new java.awt.Color(0, 0, 0));
        messageArea.setColumns(20);
        messageArea.setForeground(new java.awt.Color(255, 255, 255));
        messageArea.setRows(5);
        jScrollPane1.setViewportView(messageArea);

        inputArea.setBackground(new java.awt.Color(102, 102, 102));
        inputArea.setColumns(20);
        inputArea.setForeground(new java.awt.Color(0, 0, 0));
        inputArea.setRows(5);
        inputArea.setText("...");
        jScrollPane3.setViewportView(inputArea);

        send_button.setText("INVIA");
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_buttonActionPerformed(evt);
            }
        });

        chiama_button.setBackground(new java.awt.Color(0, 102, 0));
        chiama_button.setText("CHIAMA");
        chiama_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiama_buttonActionPerformed(evt);
            }
        });

        closeConn_button.setBackground(new java.awt.Color(204, 0, 0));
        closeConn_button.setText("CHIUDI");
        closeConn_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConn_buttonActionPerformed(evt);
            }
        });

        label_messaggio.setForeground(new java.awt.Color(255, 255, 255));
        label_messaggio.setText("Inserisci l'username dell'utente che vuoi chiamare.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(send_button))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chiama_button))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label_messaggio, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeConn_button)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(closeConn_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(chiama_button))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label_messaggio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Funzione che chiude la connessione
     */
    private void closeConnection() {
        try {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            dispose();
            System.out.println("Connessione chiusa e applicazione terminata.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @param evt 
     */
    private void chiama_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiama_buttonActionPerformed
        //rispondi_button.setEnabled(false);
        if (email_field.getText() != null && !email_field.getText().isBlank() && !email_field.getText().isEmpty()){
            String user_I_want = email_field.getText();
            
            DBManager db = new DBManager();
            
            if (db.is_user_existent(user_I_want)){
                if (!user.getUsername().equals(user_I_want)){
                    System.out.println("Server avviato...");
                    label_messaggio.setForeground(Color.green);
                    label_messaggio.setText("Chiamata avviata verso " + user_I_want + ", in attesa di risposta...");
                    new Thread(() -> {
                        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                            System.out.println("In attesa di connessioni sulla porta " + PORT + "...");
                            while (true) {
                                clientSocket = serverSocket.accept();

                                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                out = new PrintWriter(clientSocket.getOutputStream(), true);

                                String clientName = in.readLine();
                                System.out.println("Nome client ricevuto: " + clientName);

                                if (user_I_want.equals(clientName)) {
                                    label_messaggio.setForeground(Color.green);
                                    label_messaggio.setText("Utente connesso alla chiamata! Parla col tuo amico.\n");
                                    
                                    inputArea.setEnabled(true);
                                    send_button.setEnabled(true);

                                    Thread readerThread = new Thread(() -> {
                                        try {
                                            String inputLine;
                                            while ((inputLine = in.readLine()) != null) {
                                                messageArea.append(inputLine + "\n");
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    });
                                    readerThread.start();
                                } else {
                                    messageArea.append("Client non autorizzato. Connessione chiusa.\n");
                                    out.println("Nome utente non autorizzato.");
                                    clientSocket.close();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();    
                } else {
                    label_messaggio.setForeground(Color.red);
                    label_messaggio.setText("Chiamare se stessi è troppo triste,\nnon posso lasciartelo fare...");    
                }
            } else {
                label_messaggio.setForeground(Color.red);
                label_messaggio.setText("Non esiste nessun utente con questo username!!");    
            }
        } else {
            label_messaggio.setForeground(Color.red);
            label_messaggio.setText("Compilare il campo richiesto!!");
        }
    }//GEN-LAST:event_chiama_buttonActionPerformed

    /**
     * 
     * @param evt 
     */
    private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
        if (!inputArea.getText().isBlank() && !inputArea.getText().isEmpty()){
            if (out != null) {
                out.println("[" + user.getUsername() + "]: " + inputArea.getText());
                messageArea.append("[" + user.getUsername() + "]: " + inputArea.getText() + "\n");
                inputArea.setText("");
            }    
        }        
    }//GEN-LAST:event_send_buttonActionPerformed

    /**
     * 
     * @param evt 
     */
    private void closeConn_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConn_buttonActionPerformed
        closeConnection();
    }//GEN-LAST:event_closeConn_buttonActionPerformed

    /**
     * 
     */
    public void runServerFrame() {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame(user).setVisible(true);
                System.out.println(user.getUsername());
                inputArea.setEnabled(false);
                send_button.setEnabled(false);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chiama_button;
    private javax.swing.JButton closeConn_button;
    private javax.swing.JTextField email_field;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel label_messaggio;
    private javax.swing.JTextArea messageArea;
    private javax.swing.JButton send_button;
    // End of variables declaration//GEN-END:variables
}
