/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.RESTful;

/**
 *
 * @author nico0
 */
import java.io.InputStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    /**
     * Funzione che permette di inviare un'email di avvenuta iscrizione.
     * @param toEmail 
     */
    public static void sendEmail(String toEmail) {
        Properties configProps = new Properties();
        try (InputStream input = EmailSender.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Impossibile trovare 'config.properties'");
                return;
            }
            configProps.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        final String username = configProps.getProperty("mail.username");
        final String password = configProps.getProperty("mail.password");
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Conferma iscrizione.");
            message.setText("Salve utente!! \nGrazie mille per esserti iscritto "
                    + "alla nostra avventura testuale: 'La mia ragazza è pazza!!', la prima "
                    + "della software house CheesyWizards.\n\nBuon divertimento!\n - CheesyWizards");

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }
}
