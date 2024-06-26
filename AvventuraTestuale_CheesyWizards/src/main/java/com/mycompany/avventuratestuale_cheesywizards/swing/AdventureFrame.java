/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.avventuratestuale_cheesywizards.chat.PhoneFrame;
import com.mycompany.avventuratestuale_cheesywizards.db.DBManager;
import com.mycompany.avventuratestuale_cheesywizards.files.FileManager;
import com.mycompany.avventuratestuale_cheesywizards.type.GameStatus;
import com.mycompany.avventuratestuale_cheesywizards.type.Users;
import com.mycompany.avventuratestuale_cheesywizards.timer.*;
import com.mycompany.avventuratestuale_cheesywizards.type.AdventureObject;
import com.mycompany.avventuratestuale_cheesywizards.type.AdventureObjectContainer;
import java.awt.Color;
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
    private boolean is_game_lost = false;
    
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

            ImageIcon icon = new ImageIcon(getClass().getResource("/immagini/stanza1.png"));
            image_lbl.setIcon(icon);
            
        } catch (NullPointerException e){
            System.err.println("Immagine non trovata: " + e.getMessage());
        }
        
        
        //metto il frame al centro dello schermo
        setLocationRelativeTo(null);
        aggiornaOggettiStanza();
    }
    
    public void aggiornaOggettiStanza(){
        itemDisplayer_comboBox.removeAllItems();
        for (AdventureObject obj : game_status.getCurrent_room().getObjects()){
            itemDisplayer_comboBox.addItem(obj.getName());
        }
        for (AdventureObjectContainer obj : game_status.getCurrent_room().getContainers()){
            itemDisplayer_comboBox.addItem(obj.getName());
        }
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

        MainPanel = new javax.swing.JPanel();
        image_lbl = new javax.swing.JLabel();
        timer_label = new javax.swing.JLabel();
        exit_button = new javax.swing.JButton();
        TextPanel = new javax.swing.JPanel();
        outTextArea = new javax.swing.JTextArea();
        CommandPanel = new javax.swing.JPanel();
        up_button = new javax.swing.JButton();
        down_button = new javax.swing.JButton();
        right_button = new javax.swing.JButton();
        left_button = new javax.swing.JButton();
        pickUp_button = new javax.swing.JButton();
        itemDisplayer_comboBox = new javax.swing.JComboBox<>();
        inventory_button = new javax.swing.JButton();
        phone_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("La mia ragazza è una pazza!!!");

        MainPanel.setBackground(new java.awt.Color(51, 51, 51));

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

        outTextArea.setEditable(false);
        outTextArea.setBackground(new java.awt.Color(0, 0, 0));
        outTextArea.setColumns(20);
        outTextArea.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        outTextArea.setForeground(new java.awt.Color(255, 255, 255));
        outTextArea.setRows(5);

        javax.swing.GroupLayout TextPanelLayout = new javax.swing.GroupLayout(TextPanel);
        TextPanel.setLayout(TextPanelLayout);
        TextPanelLayout.setHorizontalGroup(
            TextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        TextPanelLayout.setVerticalGroup(
            TextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        up_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/su.png"))); // NOI18N
        up_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_buttonActionPerformed(evt);
            }
        });

        down_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/giu.png"))); // NOI18N
        down_button.setToolTipText("");
        down_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                down_buttonActionPerformed(evt);
            }
        });

        right_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/destra.png"))); // NOI18N
        right_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                right_buttonActionPerformed(evt);
            }
        });

        left_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/sinistra.png"))); // NOI18N
        left_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                left_buttonActionPerformed(evt);
            }
        });

        pickUp_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/PickUp.png"))); // NOI18N
        pickUp_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickUp_buttonActionPerformed(evt);
            }
        });

        itemDisplayer_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemDisplayer_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDisplayer_comboBoxActionPerformed(evt);
            }
        });

        inventory_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/inventory.png"))); // NOI18N
        inventory_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventory_buttonActionPerformed(evt);
            }
        });

        phone_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/phone_icon.png"))); // NOI18N
        phone_button.setMaximumSize(new java.awt.Dimension(48, 48));
        phone_button.setMinimumSize(new java.awt.Dimension(48, 48));
        phone_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_buttonActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Osservabile.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Sposta.png"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Apribile.png"))); // NOI18N

        javax.swing.GroupLayout CommandPanelLayout = new javax.swing.GroupLayout(CommandPanel);
        CommandPanel.setLayout(CommandPanelLayout);
        CommandPanelLayout.setHorizontalGroup(
            CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CommandPanelLayout.createSequentialGroup()
                .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CommandPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(up_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CommandPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(left_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(right_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CommandPanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(down_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CommandPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(phone_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inventory_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CommandPanelLayout.createSequentialGroup()
                        .addComponent(pickUp_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(itemDisplayer_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        CommandPanelLayout.setVerticalGroup(
            CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommandPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CommandPanelLayout.createSequentialGroup()
                        .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(up_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pickUp_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemDisplayer_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(left_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(right_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(down_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phone_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventory_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(image_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CommandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(467, 467, 467)
                        .addComponent(timer_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit_button)))
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timer_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(TextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CommandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        
        if (!is_game_lost){
            //Viene effettuato un salvataggio e aperta la pagina di login
            FileManager fm = new FileManager();
            fm.update_savings_on_file_and_db(user.getUsername(), user.getPassword(), game_status);
            System.out.println("Salvataggio effettuato.");
            dispose();
        } else {
            destroySavings();
        }
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_exit_buttonActionPerformed

    private void inventory_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventory_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inventory_buttonActionPerformed

    private void left_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_left_buttonActionPerformed
        if (game_status.getCurrent_room().getWest() != null){
            game_status.setCurrent_room(game_status.getCurrent_room().getWest());
            try {

            ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
            image_lbl.setIcon(icon);
            aggiornaOggettiStanza();
            } catch (NullPointerException e){
            System.err.println("Immagine non trovata: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_left_buttonActionPerformed

    private void itemDisplayer_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDisplayer_comboBoxActionPerformed
        
    }//GEN-LAST:event_itemDisplayer_comboBoxActionPerformed

    private void down_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_down_buttonActionPerformed
        if (game_status.getCurrent_room().getSouth() != null){
            game_status.setCurrent_room(game_status.getCurrent_room().getSouth());
            try {

            ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
            image_lbl.setIcon(icon);
            aggiornaOggettiStanza();
            } catch (NullPointerException e){
            System.err.println("Immagine non trovata: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_down_buttonActionPerformed

    private void right_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_right_buttonActionPerformed
        if (game_status.getCurrent_room().getEast() != null){
            game_status.setCurrent_room(game_status.getCurrent_room().getEast());
            try {

            ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
            image_lbl.setIcon(icon);
            aggiornaOggettiStanza();
            } catch (NullPointerException e){
            System.err.println("Immagine non trovata: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_right_buttonActionPerformed

    private void pickUp_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickUp_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pickUp_buttonActionPerformed

    private void up_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_buttonActionPerformed
        if (game_status.getCurrent_room().getNorth() != null){
            game_status.setCurrent_room(game_status.getCurrent_room().getNorth());
            try {

            ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
            image_lbl.setIcon(icon);
            aggiornaOggettiStanza();
            } catch (NullPointerException e){
            System.err.println("Immagine non trovata: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_up_buttonActionPerformed
    
    /**
     * Metodo che riporta alla schermata di login e distrugge i salvataggi per l'utente connesso.
     */
    private void destroySavings(){
        //Viene effettuato un salvataggio e aperta la pagina di login
        FileManager fm = new FileManager();
        fm.update_savings_on_file_and_db(user.getUsername(), user.getPassword(), game_status);
        
        DBManager db = new DBManager();
        db.destroy_savings(user.getUsername());
        System.out.println("Salvataggio per "+user.getUsername()+" eliminato.");
        dispose();
    }
    
    public void game_lost(){
        timer_label.setForeground(Color.red);
        ImageIcon icon = new ImageIcon(getClass().getResource("/immagini/game_lost_image.png"));
        image_lbl.setIcon(icon);
        
        String lost_sentence = "HAI PERSO!\nSono passati 20 minuti e non sei riuscito a fuggire in tempo.\n"
                + "La tua ragazza è tornata in casa con un'ascia in mano e ti ha ammazzato.\n\nSei morto.";
        is_game_lost = true;
        phone_button.setEnabled(false);
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
    private javax.swing.JPanel CommandPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel TextPanel;
    private javax.swing.JButton down_button;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel image_lbl;
    private javax.swing.JButton inventory_button;
    private javax.swing.JComboBox<String> itemDisplayer_comboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton left_button;
    private javax.swing.JTextArea outTextArea;
    private javax.swing.JButton phone_button;
    private javax.swing.JButton pickUp_button;
    private javax.swing.JButton right_button;
    private javax.swing.JLabel timer_label;
    private javax.swing.JButton up_button;
    // End of variables declaration//GEN-END:variables
}
