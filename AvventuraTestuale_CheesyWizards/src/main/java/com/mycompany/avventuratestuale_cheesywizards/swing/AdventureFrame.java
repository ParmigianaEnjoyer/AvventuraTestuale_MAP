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
import java.nio.file.Files;
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
    private String item_scelto = "";
    private InventoryFrame inventoryFrame = new InventoryFrame();
    
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
        
        
        //carico l'immagine dell'ultima stanza in cui mi trovavo
        try {

            ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
            image_lbl.setIcon(icon);
            
        } catch (NullPointerException e){
            System.err.println("Immagine non trovata: " + e.getMessage());
        }
        
        
        //metto il frame al centro dello schermo
        setLocationRelativeTo(null);
        
        
        //lancio l'aggiornamento della lista di oggetti nella stanza corrente
        aggiornaOggettiStanza();
    }
    
    //metodo aggionamento della comboBox degli item nella stanza
    public void aggiornaOggettiStanza(){
        itemDisplayer_comboBox.removeAllItems();  //cancello item precedenti
        itemDisplayer_comboBox.addItem("Seleziona Oggetto..."); //aggiungo item "fantoccio"
        for (AdventureObject itemStanza : game_status.getCurrent_room().getObjects()){  //scorro sia le liste di item che containers nella stanza
            itemDisplayer_comboBox.addItem(itemStanza.getName());                       //e ne inserisco il nome della comboBox
        }
        for (AdventureObjectContainer containerStanza : game_status.getCurrent_room().getContainers()){
            itemDisplayer_comboBox.addItem(containerStanza.getName());
        }
        //disabilito inizialmente i bottoni di interazione
        pickUp_button.setEnabled(false);
        move_button.setEnabled(false);
        observe_button.setEnabled(false);
        open_button.setEnabled(false);
        use_button.setEnabled(false);
        backToRoom_button.setEnabled(false);
        up_button.setEnabled(true);
        down_button.setEnabled(true);
        right_button.setEnabled(true);
        left_button.setEnabled(true);
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
        observe_button = new javax.swing.JButton();
        move_button = new javax.swing.JButton();
        open_button = new javax.swing.JButton();
        use_button = new javax.swing.JButton();
        backToRoom_button = new javax.swing.JButton();

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

        observe_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Osservabile.png"))); // NOI18N

        move_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Sposta.png"))); // NOI18N

        open_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Apribile.png"))); // NOI18N

        use_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/useObject.png"))); // NOI18N
        use_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                use_buttonActionPerformed(evt);
            }
        });

        backToRoom_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/goBackToRoom.png"))); // NOI18N
        backToRoom_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToRoom_buttonActionPerformed(evt);
            }
        });

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
                        .addComponent(inventory_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backToRoom_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(open_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(observe_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CommandPanelLayout.createSequentialGroup()
                        .addComponent(pickUp_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(itemDisplayer_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(move_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(use_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(observe_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(left_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(right_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(down_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(move_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(open_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CommandPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(use_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CommandPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backToRoom_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(phone_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inventory_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
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
        inventoryFrame.setVisible(true);
    }//GEN-LAST:event_inventory_buttonActionPerformed

    
    /** metodo per controllare se vi è una stanza ad Ovest della corrente, se si imposta la nuova stanza come
        stanza corrente, prende e carica la sua immagine correlata (codice uguale per le altre 3 direzioni)**/
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
        item_scelto = String.valueOf(itemDisplayer_comboBox.getSelectedItem());
        for (AdventureObject itemStanza : game_status.getCurrent_room().getObjects()){  
            if(itemStanza.getName() == item_scelto){
                try {

                ImageIcon icon = new ImageIcon(getClass().getResource(itemStanza.getPath_image()));
                image_lbl.setIcon(icon);
            
                } catch (NullPointerException e){
                    System.err.println("Immagine non trovata: " + e.getMessage());
                }
                if(itemStanza.isOpenable() || itemStanza.isLocked()){
                    open_button.setEnabled(true);
                    pickUp_button.setEnabled(false);
                    move_button.setEnabled(false);
                    observe_button.setEnabled(false);
                    use_button.setEnabled(false);
                    backToRoom_button.setEnabled(true);
                }
                else if (itemStanza.isObservable()){
                    observe_button.setEnabled(true);
                    pickUp_button.setEnabled(false);
                    move_button.setEnabled(false);
                    open_button.setEnabled(false);
                    use_button.setEnabled(false);
                    backToRoom_button.setEnabled(true);
                }
                else if (itemStanza.isMovable()){
                    move_button.setEnabled(true);
                    pickUp_button.setEnabled(false);
                    observe_button.setEnabled(false);
                    open_button.setEnabled(false);
                    use_button.setEnabled(false);
                    backToRoom_button.setEnabled(true);
                }
                else if (itemStanza.isPickupable()){
                    pickUp_button.setEnabled(true);
                    move_button.setEnabled(false);
                    observe_button.setEnabled(false);
                    open_button.setEnabled(false);
                    use_button.setEnabled(false);
                    backToRoom_button.setEnabled(true);
                }
                up_button.setEnabled(false);
                down_button.setEnabled(false);
                right_button.setEnabled(false);
                left_button.setEnabled(false);
                return;
            }                       
        }
        for (AdventureObjectContainer containerStanza : game_status.getCurrent_room().getContainers()){
            if(containerStanza.getName() == item_scelto){
                try {

                ImageIcon icon = new ImageIcon(getClass().getResource(containerStanza.getPath_image()));
                image_lbl.setIcon(icon);
            
                } catch (NullPointerException e){
                    System.err.println("Immagine non trovata: " + e.getMessage());
                }
                if(containerStanza.isOpenable() || containerStanza.isLocked()){
                    open_button.setEnabled(true);
                    pickUp_button.setEnabled(false);
                    move_button.setEnabled(false);
                    observe_button.setEnabled(false);
                    use_button.setEnabled(false);
                    backToRoom_button.setEnabled(true);
                }
                else if (containerStanza.isObservable()){
                    observe_button.setEnabled(true);
                    pickUp_button.setEnabled(false);
                    move_button.setEnabled(false);
                    open_button.setEnabled(false);
                    use_button.setEnabled(false);
                    backToRoom_button.setEnabled(true);
                }
                else if (containerStanza.isMovable()){
                    move_button.setEnabled(true);
                    pickUp_button.setEnabled(false);
                    observe_button.setEnabled(false);
                    open_button.setEnabled(false);
                    use_button.setEnabled(false);
                    backToRoom_button.setEnabled(true);
                }
                else if (containerStanza.isPickupable()){
                    pickUp_button.setEnabled(true);
                    move_button.setEnabled(false);
                    observe_button.setEnabled(false);
                    open_button.setEnabled(false);
                    use_button.setEnabled(false);
                    backToRoom_button.setEnabled(true);
                }
                up_button.setEnabled(false);
                down_button.setEnabled(false);
                right_button.setEnabled(false);
                left_button.setEnabled(false);
            }
        }
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

    private void backToRoom_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToRoom_buttonActionPerformed
        //carico l'immagine dell'ultima stanza in cui mi trovavo
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
            image_lbl.setIcon(icon);
            
        } catch (NullPointerException e){
                System.err.println("Immagine non trovata: " + e.getMessage());
        }
        aggiornaOggettiStanza();
    }//GEN-LAST:event_backToRoom_buttonActionPerformed

    private void use_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_use_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_use_buttonActionPerformed
    
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
        ImageIcon icon = new ImageIcon(getClass().getResource("/immagini/game_lost_image.jpg"));
        image_lbl.setIcon(icon);
        
        String lost_sentence = "HAI PERSO!\nSono passati 20 minuti e non sei riuscito a fuggire in tempo.\n"
                + "La tua ragazza è tornata in casa con un'ascia in mano e ti ha ammazzato.\n\nSei morto.";
        is_game_lost = true;
        phone_button.setEnabled(false);
        pickUp_button.setEnabled(false);
        move_button.setEnabled(false);
        observe_button.setEnabled(false);
        open_button.setEnabled(false);
        use_button.setEnabled(false);
        backToRoom_button.setEnabled(false);
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
    private javax.swing.JButton backToRoom_button;
    private javax.swing.JButton down_button;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel image_lbl;
    private javax.swing.JButton inventory_button;
    private javax.swing.JComboBox<String> itemDisplayer_comboBox;
    private javax.swing.JButton left_button;
    private javax.swing.JButton move_button;
    private javax.swing.JButton observe_button;
    private javax.swing.JButton open_button;
    private javax.swing.JTextArea outTextArea;
    private javax.swing.JButton phone_button;
    private javax.swing.JButton pickUp_button;
    private javax.swing.JButton right_button;
    private javax.swing.JLabel timer_label;
    private javax.swing.JButton up_button;
    private javax.swing.JButton use_button;
    // End of variables declaration//GEN-END:variables
}
