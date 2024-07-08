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
import com.mycompany.avventuratestuale_cheesywizards.type.AdventureObject;
import com.mycompany.avventuratestuale_cheesywizards.type.AdventureObjectContainer;
import java.awt.Color;
import java.util.Iterator;
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
    private Boolean is_game_won = false;
    private String item_scelto = "";
    private Boolean haiChiave1 = false;
    private Boolean haiChiave2 = false;
    private Boolean haiChiaveGiardino = false;
    private Boolean haiAscia = false;
    private Boolean haiOsso = false;
    private Boolean isContainer = false;
    
    /**
     * Creates new form AdventureFrame
     * @param user_info
     * @param saves
     * Carico i salvaltaggi (se esistenti) delle partite precedenti e istanzio il timer
     */
    public AdventureFrame(Users user_info, GameStatus saves) {
        this.setVisible(true);
        this.user = user_info;
        this.game_status = saves;
        timerManager = new TimerManager(game_status.getTimer_partita(), this);
        initComponents();
        timer_label.setText("--:--");
        
        if(game_status.getTimer_partita().getCurrent_value() == game_status.getTimer_partita().getTIMER_VALUE()){
            outTextArea.setText("\n\nC..Cavolo, sono a casa della mia ragazza!\n\n"
                    + "Quella pazza mi ha drogato e chiuso dentro casa sua dopo che le ho detto che volevo lasciarla...\n\n"
                    + "Devo scappare prima che quella pazza torni e mi ammazzi!!");
        } else {
            outTextArea.setText("\n\nTi trovi in: " + game_status.getCurrent_room().getName());
        }
        
        outTextArea.setLineWrap(true);
        outTextArea.setWrapStyleWord(true);
        
        itemDescriptionArea.setLineWrap(true);
        itemDescriptionArea.setWrapStyleWord(true);
        
        //carico l'immagine dell'ultima stanza in cui mi trovavo
        try {

            ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
            image_lbl.setIcon(icon);
            
        } catch (NullPointerException e){
            System.err.println("Immagine non trovata: " + e.getMessage());
        }
        
        
        //metto il frame al centro dello schermo
        setLocationRelativeTo(null);
        
        //Cambio nome alle tab
        tabGameInventory.setTitleAt(0, "Gioco");
        tabGameInventory.setTitleAt(1, "Inventario");
        
        //lancio l'aggiornamento della lista di oggetti nella stanza corrente e nell'inventario
        aggiornaOggettiStanza();
        aggiornaOggettiInventario();
    }
    
    //Metodo aggionamento della comboBox degli item nella stanza numbers.forEach( (n) -> { System.out.println(n); } );
    public void aggiornaOggettiStanza(){
        itemDisplayer_comboBox.removeAllItems();  //cancello item precedenti
        itemDisplayer_comboBox.addItem("Seleziona Oggetto..."); //aggiungo item "fantoccio"
        game_status.getCurrent_room().getObjects().forEach((itemStanza) -> { //scorro sia le liste di item che containers nella stanza
            if(!"Pezzo di chiave #2".equals(itemStanza.getName())){
                itemDisplayer_comboBox.addItem(itemStanza.getName());                       //e ne inserisco il nome della comboBox
            }
        });
        game_status.getCurrent_room().getContainers().forEach((containerStanza) -> {
            itemDisplayer_comboBox.addItem(containerStanza.getName());
        });
        
        //disabilito inizialmente i bottoni di interazione
        pickUp_button.setEnabled(false);
        move_button.setEnabled(false);
        observe_button.setEnabled(false);
        open_button.setEnabled(false);
        interaction_button.setEnabled(false);
        backToRoom_button.setEnabled(false);
        up_button.setEnabled(true);
        down_button.setEnabled(true);
        right_button.setEnabled(true);
        left_button.setEnabled(true);
    }
    
    //Metodo come il precedente, visualizza nella comboBox della stanza gli item di un contenitore selezionato
    public void aggiornaOggettiContainer(AdventureObjectContainer containerOggetti){
        itemDisplayer_comboBox.removeAllItems();  //cancello item precedenti
        itemDisplayer_comboBox.addItem("Seleziona Oggetto..."); //aggiungo item "fantoccio"
        containerOggetti.getList().forEach((itemContainer) -> { //scorro la lista degli item del container
            itemDisplayer_comboBox.addItem(itemContainer.getName());     
        });
    }
    
    //Metodo come il precedente, visualizza nella comboBox dell'inventario gli item che possiede il giocatore
    public void aggiornaOggettiInventario(){
        itemComboBox.removeAllItems();  //cancello item precedenti
        itemComboBox.addItem("Seleziona Oggetto..."); //aggiungo item "fantoccio"
        game_status.getInventario().getList().forEach((itemInventario) -> { //scorro la lista degli item del'iventario
            itemComboBox.addItem(itemInventario.getName());                       
        });
    }
    
    /**
     * 
     * @param message 
     * Metodo per l'inserimento del testo nella console principale
     */
    public void updateOutTextArea(String message) {
        outTextArea.setText(message + "\n");
    }
    
    /**
     * 
     * @param timer_string 
     * Metodo per la visualizzazione del timer
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
        timer_label = new javax.swing.JLabel();
        exit_button = new javax.swing.JButton();
        tabGameInventory = new javax.swing.JTabbedPane();
        adventurePanel = new javax.swing.JPanel();
        image_lbl = new javax.swing.JLabel();
        TextPanel = new javax.swing.JPanel();
        outTextArea = new javax.swing.JTextArea();
        CommandPanel = new javax.swing.JPanel();
        up_button = new javax.swing.JButton();
        down_button = new javax.swing.JButton();
        right_button = new javax.swing.JButton();
        left_button = new javax.swing.JButton();
        pickUp_button = new javax.swing.JButton();
        itemDisplayer_comboBox = new javax.swing.JComboBox<>();
        phone_button = new javax.swing.JButton();
        observe_button = new javax.swing.JButton();
        move_button = new javax.swing.JButton();
        open_button = new javax.swing.JButton();
        interaction_button = new javax.swing.JButton();
        backToRoom_button = new javax.swing.JButton();
        inventoryPanel = new javax.swing.JPanel();
        InventoryPanel = new javax.swing.JPanel();
        itemComboBox = new javax.swing.JComboBox<>();
        ItemPanel = new javax.swing.JPanel();
        itemDescriptionArea = new javax.swing.JTextArea();
        inventoryImg_lbl = new javax.swing.JLabel();

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
                .addComponent(outTextArea)
                .addContainerGap())
        );
        TextPanelLayout.setVerticalGroup(
            TextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
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

        phone_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/phone_icon.png"))); // NOI18N
        phone_button.setMaximumSize(new java.awt.Dimension(48, 48));
        phone_button.setMinimumSize(new java.awt.Dimension(48, 48));
        phone_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_buttonActionPerformed(evt);
            }
        });

        observe_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Osservabile.png"))); // NOI18N
        observe_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observe_buttonActionPerformed(evt);
            }
        });

        move_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Sposta.png"))); // NOI18N
        move_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                move_buttonActionPerformed(evt);
            }
        });

        open_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Apribile.png"))); // NOI18N
        open_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_buttonActionPerformed(evt);
            }
        });

        interaction_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/useObject.png"))); // NOI18N
        interaction_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interaction_buttonActionPerformed(evt);
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
                        .addGap(60, 60, 60)
                        .addComponent(backToRoom_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(open_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(observe_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CommandPanelLayout.createSequentialGroup()
                        .addComponent(pickUp_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(itemDisplayer_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(move_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interaction_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(interaction_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CommandPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backToRoom_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout adventurePanelLayout = new javax.swing.GroupLayout(adventurePanel);
        adventurePanel.setLayout(adventurePanelLayout);
        adventurePanelLayout.setHorizontalGroup(
            adventurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adventurePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(adventurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adventurePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CommandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        adventurePanelLayout.setVerticalGroup(
            adventurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adventurePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adventurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adventurePanelLayout.createSequentialGroup()
                        .addComponent(TextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CommandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(image_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabGameInventory.addTab("tab1", adventurePanel);

        itemComboBox.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        itemComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InventoryPanelLayout = new javax.swing.GroupLayout(InventoryPanel);
        InventoryPanel.setLayout(InventoryPanelLayout);
        InventoryPanelLayout.setHorizontalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        InventoryPanelLayout.setVerticalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        itemDescriptionArea.setBackground(new java.awt.Color(0, 0, 0));
        itemDescriptionArea.setColumns(20);
        itemDescriptionArea.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        itemDescriptionArea.setForeground(new java.awt.Color(255, 255, 255));
        itemDescriptionArea.setRows(5);

        javax.swing.GroupLayout ItemPanelLayout = new javax.swing.GroupLayout(ItemPanel);
        ItemPanel.setLayout(ItemPanelLayout);
        ItemPanelLayout.setHorizontalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemDescriptionArea, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryImg_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        ItemPanelLayout.setVerticalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ItemPanelLayout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(itemDescriptionArea, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addGroup(ItemPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inventoryImg_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InventoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(InventoryPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabGameInventory.addTab("tab2", inventoryPanel);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabGameInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 1515, Short.MAX_VALUE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(timer_label)
                        .addGap(670, 670, 670)
                        .addComponent(exit_button)))
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit_button)
                    .addComponent(timer_label, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tabGameInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
    
        if (!is_game_lost && !is_game_won){
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

    /**Metodo che controlla se la porta a sud della stanza corrente è chiusa,
      usato per verificare se non è stata aperta la porta a sud della cucina
      per accedere al giardino**/
    private void portaChiusaSud(){
        if(game_status.getCurrent_room().getName().equals("Cucina")){
            game_status.getCurrent_room().getObjects().forEach((itemStanza) -> {
                if(itemStanza.getName().equals("Porta")){
                    if(itemStanza.isLocked()){
                        down_button.setEnabled(false);
                    }
                    else{
                        down_button.setEnabled(true);
                    }
                }
            });
        }
        else{
            down_button.setEnabled(true);
        }
    }
    
    /** Metodo per controllare se vi è una stanza ad Ovest della corrente, se si imposta la nuova stanza come
     * stanza corrente, prende e carica la sua immagine correlata (codice uguale per le altre 3 direzioni)
     * viene inoltre controllato se si possiedono i requisiti di vittoria del gioco**/
    private void left_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_left_buttonActionPerformed
        if (game_status.getCurrent_room().getWest() != null){
            game_status.setCurrent_room(game_status.getCurrent_room().getWest());
            outTextArea.setText("\n\nTi trovi in: " + game_status.getCurrent_room().getName());
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
                image_lbl.setIcon(icon);
                aggiornaOggettiStanza();
            } catch (NullPointerException e){
                System.err.println("Immagine non trovata: " + e.getMessage());
            }
            portaChiusaSud();
            haiChiaveOro();
        }
    }//GEN-LAST:event_left_buttonActionPerformed

    
    /**Metodo per la selezione di un oggetto o contenitore nella comboBox nell'avventura principale
     * vengono scandite tutte le liste alla ricerca dell'oggetto o contenitore specifico, 
     * una volta trovato verranno abilitati i pulsanti specifici di interazione per quell'oggetto 
     * e caricata l'immagine relativa, le liste sono in ordine:
     * oggetti nella stanza, contenitori nella stanza, oggetti nei contenitori (in caso il giocatore
     * abbia aperto un contenitore)
     **/
    private void itemDisplayer_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDisplayer_comboBoxActionPerformed
        //outTextArea.setText("");
        item_scelto = String.valueOf(itemDisplayer_comboBox.getSelectedItem());
        game_status.getCurrent_room().getObjects().forEach((itemStanza) -> {
            if(itemStanza.getName().equals(item_scelto)){
                isContainer = false;
                up_button.setEnabled(false);
                down_button.setEnabled(false);
                right_button.setEnabled(false);
                left_button.setEnabled(false);
                observe_button.setEnabled(false);
                pickUp_button.setEnabled(false);
                move_button.setEnabled(false);
                open_button.setEnabled(false);
                interaction_button.setEnabled(false);
                backToRoom_button.setEnabled(true);
                try {

                ImageIcon icon = new ImageIcon(getClass().getResource(itemStanza.getPath_image()));
                image_lbl.setIcon(icon);
            
                } catch (NullPointerException e){
                    System.err.println("Immagine non trovata: " + e.getMessage());
                }
                if(itemStanza.isOpenable()){
                    open_button.setEnabled(true);             
                }
                if (itemStanza.isObservable()){
                    observe_button.setEnabled(true);
                }
                if (itemStanza.isMovable()){
                    move_button.setEnabled(true);
                }
                if (itemStanza.isPickupable()){
                    pickUp_button.setEnabled(true);
                }
                if (itemStanza.isUsable()){
                    interaction_button.setEnabled(true);
                }
                return;
            }
        });
        
        game_status.getCurrent_room().getContainers().forEach((containerStanza) -> {
            if(containerStanza.getName().equals(item_scelto)){
                isContainer = true;
                up_button.setEnabled(false);
                down_button.setEnabled(false);
                right_button.setEnabled(false);
                left_button.setEnabled(false);
                observe_button.setEnabled(false);
                pickUp_button.setEnabled(false);
                move_button.setEnabled(false);
                open_button.setEnabled(false);
                interaction_button.setEnabled(false);
                backToRoom_button.setEnabled(true);
                try {

                ImageIcon icon = new ImageIcon(getClass().getResource(containerStanza.getPath_image()));
                image_lbl.setIcon(icon);
            
                } catch (NullPointerException e){
                    System.err.println("Immagine non trovata: " + e.getMessage());
                }
                if(containerStanza.getName().equals("Cuccia del cane")){
                    if(containerStanza.isOpenable()){
                        open_button.setEnabled(true);
                    }
                    if (containerStanza.isObservable()){
                        observe_button.setEnabled(true);
                    }
                    if (containerStanza.isMovable()){
                        move_button.setEnabled(true);
                    }
                    if (containerStanza.isPickupable()){
                        pickUp_button.setEnabled(true);
                    }
                    if (containerStanza.isUsable()){
                        interaction_button.setEnabled(true);
                    }
                }
                else{
                    if(containerStanza.isOpenable()){
                        open_button.setEnabled(true);
                    }
                        if (containerStanza.isObservable()){
                        observe_button.setEnabled(true);
                    }
                    if (containerStanza.isMovable()){
                        move_button.setEnabled(true);
                    }
                    if (containerStanza.isPickupable()){
                        pickUp_button.setEnabled(true);
                    }
                }
                return;
            }
        });
        
        game_status.getCurrent_room().getContainers().forEach((containerStanza) -> {
            for (AdventureObject itemContainer : containerStanza.getList()){
                if(itemContainer.getName().equals(item_scelto)){
                    isContainer = false;
                    up_button.setEnabled(false);
                    down_button.setEnabled(false);
                    right_button.setEnabled(false);
                    left_button.setEnabled(false);
                    observe_button.setEnabled(false);
                    pickUp_button.setEnabled(false);
                    move_button.setEnabled(false);
                    open_button.setEnabled(false);
                    interaction_button.setEnabled(false);
                    backToRoom_button.setEnabled(true);
                    if (itemContainer.isPickupable()){
                        pickUp_button.setEnabled(true);
                    }
                    if (itemContainer.isObservable()){
                        observe_button.setEnabled(true);
                    }
                    return;
                }
            }
        });
    }//GEN-LAST:event_itemDisplayer_comboBoxActionPerformed

    private void down_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_down_buttonActionPerformed
        if (game_status.getCurrent_room().getSouth() != null){
            game_status.setCurrent_room(game_status.getCurrent_room().getSouth());
            outTextArea.setText("\n\nTi trovi in: " + game_status.getCurrent_room().getName());
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
                image_lbl.setIcon(icon);
                aggiornaOggettiStanza();
            } catch (NullPointerException e){
                System.err.println("Immagine non trovata: " + e.getMessage());
            }
            portaChiusaSud();
            haiChiaveOro();
        }
    }//GEN-LAST:event_down_buttonActionPerformed

    private void right_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_right_buttonActionPerformed
        if (game_status.getCurrent_room().getEast() != null){
            game_status.setCurrent_room(game_status.getCurrent_room().getEast());
            outTextArea.setText("\n\nTi trovi in: " + game_status.getCurrent_room().getName());
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
                image_lbl.setIcon(icon);
                aggiornaOggettiStanza();
            } catch (NullPointerException e){
                System.err.println("Immagine non trovata: " + e.getMessage());
            }
            portaChiusaSud();
            haiChiaveOro();
        }
    }//GEN-LAST:event_right_buttonActionPerformed

    
    /**Metodo per acquisire un oggetto nell'inventario, che esso sia presente nella
    * stanza o in un contenitore specifico, una volta trovato viene messo nell'inventario**/
    private void pickUp_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickUp_buttonActionPerformed
        item_scelto = String.valueOf(itemDisplayer_comboBox.getSelectedItem());
        if(!item_scelto.equals("\n\n"+"Seleziona Oggetto...")){
            outTextArea.setText("Ho raccolto: " + item_scelto + ".\n"
                    + "Se fossi in un gioco e avessi un inventario controllerei li");
        }
        game_status.getCurrent_room().getObjects().forEach((itemStanza) -> {
            if(itemStanza.getName().equals(item_scelto)){
                game_status.getInventario().addObject(itemStanza);
                game_status.getCurrent_room().getObjects().remove(itemStanza);
                aggiornaOggettiInventario();
                aggiornaOggettiStanza();
                return;
            }
        });
        
        game_status.getCurrent_room().getContainers().forEach((containerStanza) -> {
            for (AdventureObject itemContainer : containerStanza.getList()){ 
                if(itemContainer.getName().equals(item_scelto)){
                    game_status.getInventario().addObject(itemContainer);
                    containerStanza.removeObject(itemContainer);
                    aggiornaOggettiInventario();
                    aggiornaOggettiContainer(containerStanza);
                    return;
                }
            }
        });
    }//GEN-LAST:event_pickUp_buttonActionPerformed

    private void up_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_buttonActionPerformed
        if (game_status.getCurrent_room().getNorth() != null){
            game_status.setCurrent_room(game_status.getCurrent_room().getNorth());
            outTextArea.setText("\n\nTi trovi in: " + game_status.getCurrent_room().getName());
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
                image_lbl.setIcon(icon);
                aggiornaOggettiStanza();
            } catch (NullPointerException e){
                System.err.println("Immagine non trovata: " + e.getMessage());
            }
            portaChiusaSud();
            haiChiaveOro();
        }
    }//GEN-LAST:event_up_buttonActionPerformed

    /**Metodo per ritornare alla visione dell'intera stanza per la scelta di un altro oggetto da esaminare, ricarica
     la lista della stanza e la sua immagine**/
    private void backToRoom_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToRoom_buttonActionPerformed
        outTextArea.setText("\n\nTi trovi in: " + game_status.getCurrent_room().getName());
            
        //carico l'immagine dell'ultima stanza in cui mi trovavo
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(game_status.getCurrent_room().getImage_path()));
            image_lbl.setIcon(icon);
            
        } catch (NullPointerException e){
                System.err.println("Immagine non trovata: " + e.getMessage());
        }
        aggiornaOggettiStanza();
        portaChiusaSud();
    }//GEN-LAST:event_backToRoom_buttonActionPerformed

    /**Metodo che chiama a seconda dell'oggetto il metodo di interazione specifico**/
    private void interaction_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interaction_buttonActionPerformed
        game_status.getCurrent_room().getObjects().forEach((itemStanza) -> {
           if(itemStanza.getName().equals("Banco da lavoro")){
                bancoDaLavoro();
                outTextArea.setText("\n\n"+"Perfetto!! Ho riparato la chiave!!\n"
                        + "Adesso ho una chiave intera,\n"
                        + "anni e anni di lavoro sottopagato nell'officina di papà son serviti a qualcosa...");
                return;
            } 
        });
        game_status.getCurrent_room().getContainers().forEach((containerStanza) -> {
            if(containerStanza.getName().equals("Cuccia del cane")){
                distraiCane();
                return;
            }
        });
    }//GEN-LAST:event_interaction_buttonActionPerformed

    /**Metodo di interazione del banco da lavoro, controlla se possiedi entrambi i pezzi di chiave
      *nell'inventario e se le possiedi le rimuove e ti da la chiave intera**/
    private void bancoDaLavoro(){
        game_status.getInventario().getList().forEach((itemInventario) -> {
            if(itemInventario.getName().equals("Pezzo di chiave #1")){
                haiChiave1 = true;
            }
            if(itemInventario.getName().equals("Pezzo di chiave #2")){
                haiChiave2 = true;
            }
        });
        if(haiChiave1 && haiChiave2){
            cancellaPezziChiave();
            game_status.getInventario().addObject(game_status.getChiaveIntera());
            aggiornaOggettiInventario();
        }
        else {
            return;
        }
    }
    
    /**Metodo per la rimozione dei pezzi di chiave dall'inventario**/
    private void cancellaPezziChiave(){
        Iterator<AdventureObject> iterator = game_status.getInventario().getList().iterator();
        while(iterator.hasNext()){  
            AdventureObject item = iterator.next();
            if(item.getName().equals("Pezzo di chiave #1")){
                iterator.remove();
                aggiornaOggettiInventario();
            }
            if(item.getName().equals("Pezzo di chiave #2")){
                iterator.remove();
                aggiornaOggettiInventario();
            }
        }
    }

    /**Metodo per l'apertura della porta chiusa, controlla se possiedi nell'inventario la chiave
       completa, se si la rimuove dell'inventario e apre la porta**/
    private void apriPorta(){
        Iterator<AdventureObject> iterator = game_status.getInventario().getList().iterator();
        while(iterator.hasNext()){ 
            AdventureObject item = iterator.next();
            if(item.getName().equals("Chiave giardino")){
                haiChiaveGiardino = true;
                iterator.remove();
                aggiornaOggettiInventario();
            }
        }
        if(haiChiaveGiardino){
            outTextArea.setText("\n\n"+"Perfetto!.\n"
                    + "Ho usato la chiave d'argento per aprire la porta!");
            game_status.getCurrent_room().getObjects().forEach((itemStanza) -> {
                if(itemStanza.getName().equals("Porta")){
                    itemStanza.setLocked(false);
                    //dialogo porta aperta
                }
            });
        }
        else{
            outTextArea.setText("\n\n"+"Cavolo...la porta è chiusa a chiave.\n"
                    + "Ho bisogno di una chiave per aprirla...");
            return;
        }
    }
    
    /**Metodo per l'apertura della dispensa, controlla se possiedi nell'inventario l'ascia,
       se si la rimuove dell'inventario permette la visualizzazione degli oggetti nella dispensa**/
    private void apriDispensa(){
        Iterator<AdventureObject> iterator = game_status.getInventario().getList().iterator();
        while(iterator.hasNext()){  
            AdventureObject item = iterator.next();
            if(item.getName().equals("Ascia da boscaiolo")){
                haiAscia = true;
                iterator.remove();
                aggiornaOggettiInventario();
            }
        }
        if(haiAscia){
            game_status.getCurrent_room().getContainers().forEach((containerStanza) -> {
                if(containerStanza.getName().equals("Dispensa della cucina")){
                    containerStanza.setLocked(false);
                    aggiornaOggettiContainer(containerStanza);
                    outTextArea.setText("\n\n"+"Esattamente come pensavo!!.\n"
                    + "Nessuna serratura in legno può resistere alla forza bruta di un'ascia. Ora la dispensa è aperta.");
                }
            });
        }
        else{
            outTextArea.setText("\n\n"+"Cavolo...la dispensa è chiusa a chiave.\n"
                    + "Devo trovare un modo per aprirla...");
            return;
        }
    }
    
    /**Metodo per l'interazione con il cane, controlla se possiedi nell'inventario l'osso,
       se si lo rimuove dell'inventario e permette la visualizzazione del contenuto della cuccia**/
    private void distraiCane(){
        Iterator<AdventureObject> iterator = game_status.getInventario().getList().iterator();
        while(iterator.hasNext()){   
            AdventureObject item = iterator.next();
            if(item.getName().equals("Osso")){
                haiOsso = true;
                iterator.remove();
                aggiornaOggettiInventario();
            }
        }
        if(haiOsso){
            game_status.getCurrent_room().getContainers().forEach((containerStanza) -> {
                if(containerStanza.getName().equals("Cuccia del cane")){
                    containerStanza.setLocked(false);
                    aggiornaOggettiContainer(containerStanza);
                    outTextArea.setText("\n\n"+"Fantastico!!\n"
                    + "Non ci avrei mai sperato, ma ora il cane è distratto dal succulento osso che gli ho dato. \n"
                            + "Prendere la chiave sarà un gioco da ragazzi");
                }
            });
        }
        else{
            outTextArea.setText("\n\n"+"Argh!!\n"
                    + "Se solo provassi ad avvicinarmi alla chiave questo cane rabbioso mi sbranerebbe l'intero braccio.");
            return;
        }
    }
    
    /**Metodo per l'apertura di un oggetto (es Porta) o contenitore, controlla se vuoi aprire o un
     contenitore o un oggetto, in entrambi i casi controlla se esso è chiuso, se è aperto per il contenitore
     visualizza gli oggetti al suo interno, nel caso siano chiusi chiama il metodo di apertura
     (non per la cuccia poichè essa viene sbloccata per interazione, il tasto apri serve solo per
     visualizzare i suoi oggetti quando è già sbloccata)**/
    private void open_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_buttonActionPerformed
        if(isContainer){
            item_scelto = String.valueOf(itemDisplayer_comboBox.getSelectedItem());
            outTextArea.setText("\n\n"+"Ho aperto " + item_scelto + "\n"
                    + "Chissà cosa c'è dentro...");
            open_button.setEnabled(false);
            observe_button.setEnabled(false);
            game_status.getCurrent_room().getContainers().forEach((containerStanza) -> {
                if(!containerStanza.isLocked() && containerStanza.getName().equals(item_scelto)){
                    aggiornaOggettiContainer(containerStanza);
                    return;
                }
            });
            if(item_scelto.equals("Dispensa della cucina")){
                apriDispensa();
                return;
            }
            if(item_scelto.equals("Cuccia del cane")){
                outTextArea.setText("\n\n"+"Argh!!\n"
                    + "Se solo provassi ad avvicinarmi alla chiave questo cane rabbioso mi sbranerebbe l'intero braccio.");
                return;
            }
        }
        else{
            game_status.getCurrent_room().getObjects().forEach((itemStanza) -> {
                if(itemStanza.isLocked()){
                    if(itemStanza.getName().equals("Porta")){
                        apriPorta();
                        return;
                    }
                }
            });
        }
    }//GEN-LAST:event_open_buttonActionPerformed

    /**Metodo per la selezione di un oggetto nell'inventaorio del giocatore, esso una volta scelto
     caricherà testo e immagine relative all'oggetto**/
    private void itemComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComboBoxActionPerformed
        item_scelto = String.valueOf(itemComboBox.getSelectedItem());
        if(item_scelto.equals("Seleziona Oggetto...")){
            inventoryImg_lbl.setIcon(null);
            itemDescriptionArea.setText("");
        }
        game_status.getInventario().getList().forEach((itemInventario) -> {
            if(itemInventario.getName().equals(item_scelto)){
                
                itemDescriptionArea.setText("\n\n" + itemInventario.getName() + "\n\n" + itemInventario.getDescription());
                
                try {

                ImageIcon iconInventory = new ImageIcon(getClass().getResource(itemInventario.getPath_image()));
                inventoryImg_lbl.setIcon(iconInventory);
            
                } catch (NullPointerException e){
                    System.err.println("Immagine non trovata: " + e.getMessage());
                }
                return;
            }
        });
    }//GEN-LAST:event_itemComboBoxActionPerformed

    /**Metodo spostare un oggetto, controlla quale oggetto si vuole spostare, dato che
       l'unico item spostabile è tappeto controllo solo se è negli oggetti della stanza attuale
       perchè il bottone sarà premibile solo se è stato selezionato. Superato il controllo lancia
       il metodo corrispondente**/
    private void move_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_move_buttonActionPerformed
        game_status.getCurrent_room().getObjects().forEach((itemStanza) -> {
            if(itemStanza.getName().equals("Tappeto a scacchiera")){
                tappetoScacchieraSpostato();
                observe_button.setEnabled(false);
                outTextArea.setText("\n\n"+"Fantastico!!\nHo spostato il tappeto e sotto ci ho trovato la seconda metà di una chiave argentata.");
            }
        });
    }//GEN-LAST:event_move_buttonActionPerformed

    /**
     * Metodo che stampa la descrizione dell'oggetto osservato selezionato.
     * @param evt 
     */
    private void observe_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observe_buttonActionPerformed
        //outTextArea.setText("");
        if(isContainer){
            //item_scelto = String.valueOf(itemDisplayer_comboBox.getSelectedItem());
            game_status.getCurrent_room().getContainers().forEach((containerStanza) -> {
                if(containerStanza.getName().equals(item_scelto)){
                    outTextArea.setText("\n\n"+containerStanza.getName().toUpperCase() + "\n\n" + containerStanza.getDescription());
                    return;
                }
            });
        } else {
            game_status.getCurrent_room().getObjects().forEach((itemStanza) -> {
                if(itemStanza.getName().equals(item_scelto)){
                    outTextArea.setText("\n\n"+itemStanza.getName().toUpperCase() + "\n\n" + itemStanza.getDescription());
                    return;
                }
            });
        }
    }//GEN-LAST:event_observe_buttonActionPerformed
    
    /**Metodo che spostando il tappeto ti da l'oggetto presente sotto di esso, una volta
     preso l'oggetto il tappeto non è più spostabile**/
    private void tappetoScacchieraSpostato(){
        game_status.getInventario().addObject(game_status.getPezzoChiave2());
        aggiornaOggettiInventario();
        game_status.getCurrent_room().getObjects().forEach((itemStanza) -> {
            if(itemStanza.getName().equals("Tappeto a scacchiera")){
                itemStanza.setMovable(false);
                move_button.setEnabled(false);
            }
        });
    }
    
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
    
    /**Metodo che controlla le condizioni di vittoria del giocatore, se esso ha la chiave d'oro e si trova nel soggiorno**/
    private void haiChiaveOro(){
        game_status.getInventario().getList().forEach((itemInventario) -> {
            if(itemInventario.getName().equals("Chiave d'oro") && game_status.getCurrent_room().getName().equals("Soggiorno")){
                game_won();
            }
        });
    }
    
    /**Sia questo metodo che il successivo pongono fine al gioco disabilitando il timer, caricando
     l'immagine relativa (vittoria o sconfitta) e disabilitando tutti i bottoni e comboBox**/
    public void game_won(){
        timerThread.interrupt();
        ImageIcon icon = new ImageIcon(getClass().getResource("/immagini/vittoria.png"));
        image_lbl.setIcon(icon);
        
        String won_sentence = "\n\nHAI VINTO!"
                + "\n\nPurtroppo per te, davanti alla porta di uscita della casa c'era un creeper che è esploso appena ti ha visto."
                + "\n\nSei morto.";
        outTextArea.setText(won_sentence);
        
        is_game_won = true;
        up_button.setEnabled(false);
        down_button.setEnabled(false);
        left_button.setEnabled(false);
        right_button.setEnabled(false);
        phone_button.setEnabled(false);
        pickUp_button.setEnabled(false);
        move_button.setEnabled(false);
        observe_button.setEnabled(false);
        open_button.setEnabled(false);
        interaction_button.setEnabled(false);
        backToRoom_button.setEnabled(false);
        itemComboBox.setEnabled(false);
        itemDisplayer_comboBox.setEnabled(false);
    }
    
    public void game_lost(){
        timer_label.setForeground(Color.red);
        ImageIcon icon = new ImageIcon(getClass().getResource("/immagini/game_lost_image.jpg"));
        image_lbl.setIcon(icon);
        
        String lost_sentence = "\n\nHAI PERSO!\n\nSono passati 20 minuti e non sei riuscito a fuggire in tempo. "
                + "La tua ragazza è tornata in casa con un'ascia in mano e ti ha ammazzato.\n\nSei morto.";
        outTextArea.setText(lost_sentence);
        is_game_lost = true;
        up_button.setEnabled(false);
        down_button.setEnabled(false);
        left_button.setEnabled(false);
        right_button.setEnabled(false);
        phone_button.setEnabled(false);
        pickUp_button.setEnabled(false);
        move_button.setEnabled(false);
        observe_button.setEnabled(false);
        open_button.setEnabled(false);
        interaction_button.setEnabled(false);
        backToRoom_button.setEnabled(false);
        itemComboBox.setEnabled(false);
        itemDisplayer_comboBox.setEnabled(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public void run_adventure_frame() {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Faccio partire il timer.
                timerThread = new Thread(timerManager);
                timerThread.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CommandPanel;
    private javax.swing.JPanel InventoryPanel;
    private javax.swing.JPanel ItemPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel TextPanel;
    private javax.swing.JPanel adventurePanel;
    private javax.swing.JButton backToRoom_button;
    private javax.swing.JButton down_button;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel image_lbl;
    private javax.swing.JButton interaction_button;
    private javax.swing.JLabel inventoryImg_lbl;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JComboBox<String> itemComboBox;
    private javax.swing.JTextArea itemDescriptionArea;
    private javax.swing.JComboBox<String> itemDisplayer_comboBox;
    private javax.swing.JButton left_button;
    private javax.swing.JButton move_button;
    private javax.swing.JButton observe_button;
    private javax.swing.JButton open_button;
    private javax.swing.JTextArea outTextArea;
    private javax.swing.JButton phone_button;
    private javax.swing.JButton pickUp_button;
    private javax.swing.JButton right_button;
    private javax.swing.JTabbedPane tabGameInventory;
    private javax.swing.JLabel timer_label;
    private javax.swing.JButton up_button;
    // End of variables declaration//GEN-END:variables
}
