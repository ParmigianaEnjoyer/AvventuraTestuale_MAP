/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.chat;

import com.mycompany.avventuratestuale_cheesywizards.type.Users;
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
    
    /**
     * Creates new form chatFrame
     */
    public ServerFrame(Users user_info) {
        this.user = user_info;
        initComponents();
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

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        messageArea.setBackground(new java.awt.Color(102, 102, 102));
        messageArea.setColumns(20);
        messageArea.setForeground(new java.awt.Color(0, 0, 0));
        messageArea.setRows(5);
        jScrollPane1.setViewportView(messageArea);

        inputArea.setBackground(new java.awt.Color(0, 0, 0));
        inputArea.setColumns(20);
        inputArea.setForeground(new java.awt.Color(255, 255, 255));
        inputArea.setRows(5);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(send_button))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chiama_button)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chiama_button))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(send_button)
                .addContainerGap(10, Short.MAX_VALUE))
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

    private void chiama_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiama_buttonActionPerformed
        //rispondi_button.setEnabled(false);
        if (email_field.getText() != null && !email_field.getText().isBlank() && !email_field.getText().isEmpty()){
            String user_I_want = email_field.getText();
            
            System.out.println("Server avviato...");
            new Thread(() -> {
                try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                    System.out.println("In attesa di connessioni sulla porta " + PORT + "...");
                    while (true) {
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("Connessione in ingresso...");

                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        out = new PrintWriter(clientSocket.getOutputStream(), true);

                        String clientName = in.readLine();
                        System.out.println("Nome client ricevuto: " + clientName);

                        if (user_I_want.equals(clientName)) {
                            System.out.println("Client autorizzato!");
                            messageArea.append("Client autorizzato!\n");

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
                            System.out.println("Client non autorizzato. Connessione chiusa.");
                            messageArea.append("Client non autorizzato. Connessione chiusa.\n");
                            out.println("Nome utente non autorizzato.");
                            clientSocket.close();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }//GEN-LAST:event_chiama_buttonActionPerformed

    private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
        if (out != null) {
            out.println("[" + user.getUsername() + "]: " + inputArea.getText());
            messageArea.append("[" + user.getUsername() + "]: " + inputArea.getText() + "\n");
            inputArea.setText("");
        }
    }//GEN-LAST:event_send_buttonActionPerformed

    /**
     * 
     */
    public void runServerFrame() {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame(user).setVisible(true);
                System.out.println(user.getUsername());
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chiama_button;
    private javax.swing.JTextField email_field;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea messageArea;
    private javax.swing.JButton send_button;
    // End of variables declaration//GEN-END:variables
}
