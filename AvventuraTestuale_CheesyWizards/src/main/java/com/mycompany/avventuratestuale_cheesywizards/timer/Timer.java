/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.timer;

import java.io.Serializable;

/**
 *
 * @author nico0
 */
public class Timer implements Serializable{
    
    private final int TIMER_VALUE = 5;   // 1200s = 20min
    private int current_value;              // valore corrente del timer

    /**
     * 
     */
    public Timer() {
        this.current_value = TIMER_VALUE;
    }
    
    /**
     * 
     * @param current_value 
     */
    public Timer(int current_value){
        this.current_value = current_value;
    }

    /**
     * 
     * @return 
     */
    public int getCurrent_value() {
        return current_value;
    }

    /**
     * 
     * @param current_value 
     */
    public void setCurrent_value(int current_value) {
        this.current_value = current_value;
    }
    
}
