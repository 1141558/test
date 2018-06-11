/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MariaJoão
 */
public class UserRegister {

    private List<User> userList;

    private User user;

    /**
     * Constructor
     *
     * @param userList List of user to be considered
     */
    public UserRegister(List<User> userList) {
        this.userList = userList;
    }

    /**
     * Constructor
     */
    public UserRegister() {
        this.userList = new ArrayList<>();
    }

    /**
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user
     *
     * @param user to be set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     *
     * @param user to be added
     * @return boolean value according to the user add
     */
    public boolean addUser(User user) {
        if(userExists(user)){
            return false;
        }else{
            this.userList.add(user);
            return true;
        }
//        return this.userList.add(user);
//        return ((userExists(user) ? false : this.userList.add(user)));
    }

    /**
     * Method to check if the user already exists
     *
     * @param user User to be validated
     * @return boolean value relative to the user existence
     */
    public boolean userExists(User user) {
        //email e username são únicos no sistema
        for (User temp : userList) {
            if (temp.getName().equals(user.getName())) {
                return true;
            }
            if (temp.getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
