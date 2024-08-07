/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.swing;

import com.mycompany.avventuratestuale_cheesywizards.db.DBManager;
import com.mycompany.avventuratestuale_cheesywizards.files.FileManager;
import com.mycompany.avventuratestuale_cheesywizards.type.GameStatus;
import com.mycompany.avventuratestuale_cheesywizards.type.Users;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author nico0
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        
        //metto il frame al centro dello schermo
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

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comunication_label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("La mia ragazza è una pazza!");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setAutoscrolls(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USERNAME:");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PASSWORD:");

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("GIOCA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 51));
        jLabel3.setText("LA MIA RAGAZZA E' PAZZA !");

        comunication_label.setForeground(new java.awt.Color(255, 255, 255));
        comunication_label.setText("Inserisci username e password per accedere o registrarti.");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/girl_image.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(comunication_label, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel1))
                .addGap(81, 81, 81)
                .addComponent(comunication_label, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GameStatus saves = new GameStatus();
        DBManager db = new DBManager();
        FileManager file = new FileManager();
        String email = "";
        String username = "";
        String password = "";
        Users user = null;
        
        username = jTextField1.getText();
        password = jPasswordField1.getText();
        
        if (jTextField1.getText().compareTo("")!=0 && jPasswordField1.getText().compareTo("")!=0){
            if (isValidUsername(username) && isValidPassword(password)){
                if (db.is_user_existent(username)) {
                    if (db.is_password_correct(username, password)){
                        if (!db.user_has_savings(username, password)){

                            //Inizializzo un nuovo salvataggio, con i valori di default iniziali: uno nuova partita
                            saves.initialize_game_status();
                            file.update_savings_on_file_and_db(username, password, saves);
                            
                            user = new Users(email, username, password);
                            new AdventureFrame(user, saves).run_adventure_frame();
                            dispose(); 

                        } else {

                            //Prende il salvataggio già presente per l'utente.
                            saves = file.get_saves_from_file(username, password);
                            System.out.println("Salvataggio caricato");
                            System.out.println(saves.getTimer_partita().getCurrent_value());
                            
                            user = new Users(email, username, password);
                            new AdventureFrame(user, saves).run_adventure_frame();
                            dispose(); 
                        }     
                    } else {
                        comunication_label.setForeground(Color.red);
                        comunication_label.setText("<html><b>Password errata!</b><br/>La password memorizzata per questo username è diversa da quella inserita!!</html>");
                    }

                } else {
                    Object[] options = {"Login", "Registrati"};
                    int answer = JOptionPane.showOptionDialog(null, "Questo utente non esiste, intendi registrarti o riprovare il login?","Questo account non esiste!", 
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]
                    );

                    if (answer == 0) {
                        System.out.println("Hai scelto: Login");
                        comunication_label.setText("Ritenta il login.");
                        jTextField1.setText("");
                        jPasswordField1.setText("");
                    } else if (answer == 1) {
                        System.out.println("Hai scelto: Registrati");
                        email = showEmailInputDialog();
                        if (email != null){
                            if (isValidEmail(email)){
                                if (!db.email_already_exists(email)){
                                    if (!db.username_already_exists(username)){
                                       db.add_new_user(email, username, password);
                                       comunication_label.setForeground(Color.green);
                                       comunication_label.setText("Nuovo utente registrato, ora effettua il login.");
                                       jTextField1.setText("");
                                       jPasswordField1.setText("");    
                                    } else {
                                        comunication_label.setForeground(Color.red);
                                        comunication_label.setText("Username già in uso!!");
                                    }
                                } else {
                                    comunication_label.setForeground(Color.red);
                                    comunication_label.setText("Email già in uso!!");
                                }
                            } else {
                                comunication_label.setForeground(Color.red);
                                comunication_label.setText("Bisogna inserire un'email nel formato corretto per potersi registrare!!");
                            }
                        } else {
                            comunication_label.setForeground(Color.red);
                            comunication_label.setText("Bisogna inserire un'email per potersi registrare!!");
                        }

                    } else {
                        System.out.println("Nessuna scelta effettuata.");
                    }
                }
            } else {
                comunication_label.setForeground(Color.red);
                comunication_label.setText("<html><b>Formato delle credenziali errato!</b><br/>"
                        + "USERNAME: Deve iniziare con una lettera, seguito da lettere, numeri, underscore o punti. Lunghezza minima 3 caratteri, massima 20 caratteri.<br/>"
                        + "PASSWORD: Lunghezza minima 8 caratteri, deve contenere almeno una lettera maiuscola, una minuscola e un numero</html>");
            }
        } else {
            comunication_label.setForeground(Color.red);
            comunication_label.setText("Bisogna compilare entrambi i campi per effettuare un login!!");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    /**
     * 
     */
    public void run_login_frame() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    /**
     * 
     * @return 
     */
    private static String showEmailInputDialog() {
        return JOptionPane.showInputDialog(null, "Inserisci la tua email, riceverai un messaggio di conferma di avvenuta registrazione:", "Completa la registrazione!", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Funzione che definisce se un'email è scritta nel giusto formato.
     * @param email
     * @return 
     */
    private static boolean isValidEmail(String email) {
        // Regex per controllare se l'email è nel formato corretto
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Verifica se l'email corrisponde alla regex
        return email.matches(emailRegex);
    }
    
    /**
     * Funzione che definisce se un username è scritto nel giusto formato.
     * @param username
     * @return 
     */
    private static boolean isValidUsername(String username) {
        // Regex per controllare se lo username è nel formato corretto
        // Deve iniziare con una lettera, seguito da lettere, numeri, underscore o punti
        // Lunghezza minima 3 caratteri, massima 20 caratteri
        String usernameRegex = "^[a-zA-Z][a-zA-Z0-9_.]{2,19}$";
        return username.matches(usernameRegex);
    }

    /**
     * Funzione che definisce se una password è scritta nel giusto formato.
     * @param password
     * @return 
     */
    private static boolean isValidPassword(String password) {
        // Regex per controllare se la password è nel formato corretto
        // Lunghezza minima 8 caratteri, deve contenere almeno una lettera maiuscola, una minuscola e un numero
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return password.matches(passwordRegex);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel comunication_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
