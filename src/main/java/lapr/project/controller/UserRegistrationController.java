/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import static lapr.project.model.PasswordEncryption.encryptPassword;

/**
 *
 * @author JM
 */
public class UserRegistrationController {

    private ExhibitionCentre exhibitionCentre;
    private User user;

    /**
     * Constructor
     *
     * @param exhibitionCentre Exhibition centre in use, introduced as parameter
     */
    public UserRegistrationController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre = exhibitionCentre;
        this.user = new User();
    }

    /**
     * Method to store/modify data
     *
     * @param name Name to be stored in the User
     * @param email Email to be stored in the User
     * @param username Username to be stored in the User
     * @param password Password to be stored in the User
     */
    public void setData(String name, String email, String username, String password) {
        this.user.setName(name);
        this.user.setEmail(email);
        this.user.setUsername(username);
        this.user.setPassword(encryptPassword(password));
    }

    /**
     * Method to add the current user to the User list in the exhibition centre
     *
     * @return a boolean value defining if the user was successfully added to
     * the register
     */
    public boolean addUser() {
        return this.exhibitionCentre.getUserRegister().addUser(this.user);
    }

    /**
     * Method to return the current user
     *
     * @return The user stored
     */
    public User getUser() {
        return user;
    }
}
