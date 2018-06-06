/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author MariaJoão
 */
public class User {
    
    private String name;
    private String email;
    private String username;
    private double password;
    
    public User(String name, String email, String username, double password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public double getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(double password) {
        this.password = password;
    }
    
}
