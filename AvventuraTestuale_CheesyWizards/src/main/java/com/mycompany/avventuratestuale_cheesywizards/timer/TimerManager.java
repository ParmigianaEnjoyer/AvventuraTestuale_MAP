/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.timer;

import com.mycompany.avventuratestuale_cheesywizards.swing.AdventureFrame;

/**
 *
 * @author nico0
 */
public class TimerManager implements Runnable{
    
    private Timer timer;
    private boolean running;            // Flag per indicare se il timer è attivo
    private AdventureFrame adventureFrame;
    
    /**
     * Costruttore della classe TimerManager
     * @param timer 
     */
    public TimerManager(Timer timer, AdventureFrame adventureFrame) {
        this.timer = timer;
        this.adventureFrame = adventureFrame;
        this.running = false;
    }
    
    /**
     * Metodo per fermare il timer
     */
    public void stopTimer() {
        running = false;
    }
    
    // Metodo run per l'interfaccia Runnable
    @Override
    public void run() {
        running = true;
        while (running && timer.getCurrent_value() > 0) {
            try {
                Thread.sleep(1000); // Pausa di 1 secondo
                timer.setCurrent_value(timer.getCurrent_value() - 1); // Decremento di currentValue
                
                int minutes = timer.getCurrent_value() / 60;
                int seconds = timer.getCurrent_value() % 60;
                String timeString = String.format("%02d:%02d", minutes, seconds);
                
                adventureFrame.setTimerLabel(timeString);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Il thread del timer è stato interrotto.");
            }
        }
        if (timer.getCurrent_value() <= 0) {
            adventureFrame.game_lost();
            System.out.println("TEMPO SCADUTO!.");
        }
        running = false;
    }
}
