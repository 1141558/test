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

    /**
     * Constructor
     *
     * @param name Name to be stored in the User
     * @param email Email to be stored in the User
     * @param username Username to be stored in the User
     * @param password Password to be stored in the User
     */
    public User(String name, String email, String username, double password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * Empty constructor
     */
    public User() {

    }

    /**
     * Copy constructor
     *
     * @param otherUser User to be copied
     */
    public User(User otherUser) {
        this.email = otherUser.email;
        this.name = otherUser.name;
        this.password = otherUser.password;
        this.username = otherUser.username;
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

    /**
     * Method to compare 2 Users using the attributes
     *
     * @param obj User to be compared to
     * @return boolean value indicating if the users match
     */
    public boolean equalsUser(User obj) {
        if (obj == null) {
            return false;
        }
        return (obj.email.equals(this.email) && obj.name.equals(this.name) && Double.compare(obj.password, this.password)==0 && obj.username.equals(this.username));
    }

    
    @Override
    public String toString() {
        return "User:{" + "name=" + name + ", email=" + email + ", username=" + username + ", password=" + password + '}';
    }

}
