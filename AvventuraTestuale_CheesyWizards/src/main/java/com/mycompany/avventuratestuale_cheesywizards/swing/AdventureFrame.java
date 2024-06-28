/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.swing;

import com.mycompany.avventuratestuale_cheesywizards.chat.PhoneFrame;
import com.mycompany.avventuratestuale_cheesywizards.db.DBManager;
import com.mycompany.avventuratestuale_cheesywizards.files.FileManager;
import com.mycompany.avventuratestuale_cheesywizards.type.GameStatus;
import com.mycompany.avventuratestuale_cheesywizards.type.Users;
import com.mycompany.avventuratestuale_cheesywizards.timer.*;
import javax.swing.ImageIcon;

/**
 *
 * @author nico0
 */
public class AdventureFrame extends javax.swing.JFrame {

    private GameStatus game_status = null;
    private Users user = null;
    private TimerManager timerManager = null;
    private Thread timerThread;
    
    /**
     * Creates new form AdventureFrame
     */
    public AdventureFrame(Users user_info, GameStatus saves) {
        this.setVisible(true);
        this.user = user_info;
        this.game_status = saves;
        timerManager = new TimerManager(game_status.getTimer_partita(), this);
        initComponents();
        timer_label.setText("--:--");
        
        try {

            ImageIcon icon = new ImageIcon(getClass().getResource("/immagini/stanza1.jpg"));
            image_lbl.setIcon(icon);
            
        } catch (NullPointerException e){
            System.err.println("Immagine non trovata: " + e.getMessage());
        }
        
        
        //metto il frame al centro dello schermo
        setLocationRelativeTo(null);
    }
    
    /**
     * 
     * @param message 
     */
    public void updateOutTextArea(String message) {
        outTextArea.setText(message + "\n");
    }
    
    /**
     * 
     * @param timer_string 
     */
    public void setTimerLabel(String timer_string){
       timer_label.setText(timer_string); 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        image_lbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        outTextArea = new javax.swing.JTextArea();
        phone_button = new javax.swing.JButton();
        timer_label = new javax.swing.JLabel();
        exit_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("La mia ragazza è una pazza!!!");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        inTextArea.setBackground(new java.awt.Color(0, 0, 0));
        inTextArea.setColumns(20);
        inTextArea.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        inTextArea.setForeground(new java.awt.Color(255, 255, 255));
        inTextArea.setRows(5);
        jScrollPane2.setViewportView(inTextArea);

        outTextArea.setEditable(false);
        outTextArea.setBackground(new java.awt.Color(0, 0, 0));
        outTextArea.setColumns(20);
        outTextArea.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        outTextArea.setForeground(new java.awt.Color(255, 255, 255));
        outTextArea.setRows(5);
        jScrollPane3.setViewportView(outTextArea);

        phone_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/phone_icon.png"))); // NOI18N
        phone_button.setMaximumSize(new java.awt.Dimension(48, 48));
        phone_button.setMinimumSize(new java.awt.Dimension(48, 48));
        phone_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_buttonActionPerformed(evt);
            }
        });

        timer_label.setBackground(new java.awt.Color(0, 0, 0));
        timer_label.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        timer_label.setForeground(new java.awt.Color(255, 255, 255));
        timer_label.setText("17:38");

        exit_button.setBackground(new java.awt.Color(204, 0, 0));
        exit_button.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        exit_button.setForeground(new java.awt.Color(255, 255, 255));
        exit_button.setText("ESCI");
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phone_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(601, 601, 601)
                        .addComponent(timer_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit_button)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timer_label, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(exit_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(image_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(phone_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo che permette di fa apparire il frame per "chiamare"
     * @param evt 
     */
    private void phone_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_buttonActionPerformed
        System.out.println("AdventureFrame " + user.getUsername());
        new PhoneFrame(user).runPhoneFrame();
    }//GEN-LAST:event_phone_buttonActionPerformed

    /**
     * Metodo che permette di uscire dall'avventura e salvare la partita
     * @param evt 
     */
    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        new LoginFrame().setVisible(true);
        
        //Viene effettuato un salvataggio e aperta la pagina di login
        FileManager fm = new FileManager();
        fm.update_savings_on_file_and_db(user.getUsername(), user.getPassword(), game_status);
        System.out.println("Salvataggio effettuato.");
        dispose();
    }//GEN-LAST:event_exit_buttonActionPerformed
    
    private void destroySavings(){
        //Viene effettuato un salvataggio e aperta la pagina di login
        FileManager fm = new FileManager();
        fm.update_savings_on_file_and_db(user.getUsername(), user.getPassword(), game_status);
        System.out.println("Salvataggio effettuato.");
        
        DBManager db = new DBManager();
        db.destroy_savings(user.getEmail());
        System.out.println("Salvataggio per "+user.getEmail()+" eliminato.");
        dispose();
    }
    
    /**
     * @param args the command line arguments
     */
    public void run_adventure_frame() {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Faccio partire il timer.
                timerThread = new Thread(timerManager);
                timerThread.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel image_lbl;
    private javax.swing.JTextArea inTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea outTextArea;
    private javax.swing.JButton phone_button;
    private javax.swing.JLabel timer_label;
    // End of variables declaration//GEN-END:variables
}
