package com.mycompany.avventuratestuale_cheesywizards.type;

/**
 *
 * @author nico0
 */
public class Users {
    
    private String email;
    
    private String username;
    
    private String password;

    /**
     * 
     * @param email
     * @param username
     * @param password 
     */
    public Users(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
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
