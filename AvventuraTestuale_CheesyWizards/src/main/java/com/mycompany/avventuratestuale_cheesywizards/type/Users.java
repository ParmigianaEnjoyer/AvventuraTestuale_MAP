package com.mycompany.avventuratestuale_cheesywizards.type;

/**
 *
 * @author nico0
 */
public class Users {
    
    private String username;
    
    private String password;

    /**
     * 
     * @param username
     * @param password 
     */
    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 
     */
    public Users() {
    }

    /**
     * 
     * @return 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
