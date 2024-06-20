/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avventuratestuale_cheesywizards.type;

/**
 *
 * @author nico0
 */
public class CurrentAdventure {
    
    private Users current_user;
    
    private Inventory current_inventory;    

    /**
     * 
     * @param current_user
     * @param current_inventory 
     */
    public CurrentAdventure(Users current_user, Inventory current_inventory) {
        this.current_user = current_user;
        this.current_inventory = current_inventory;
    }

    /**
     * 
     */
    public CurrentAdventure() {
    }

    /**
     * 
     * @return 
     */
    public Users getCurrent_user() {
        return current_user;
    }

    /**
     * 
     * @param current_user 
     */
    public void setCurrent_user(Users current_user) {
        this.current_user = current_user;
    }

    /**
     * 
     * @return 
     */
    public Inventory getCurrent_inventory() {
        return current_inventory;
    }

    /**
     * 
     * @param current_inventory 
     */
    public void setCurrent_inventory(Inventory current_inventory) {
        this.current_inventory = current_inventory;
    }
    
    
}
