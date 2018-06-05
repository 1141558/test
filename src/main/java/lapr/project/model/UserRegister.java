/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;

/**
 *
 * @author MariaJoão
 */
public class UserRegister {
    
     private ArrayList<User> userList;

    public UserRegister(ArrayList<User> userList) {
        this.userList = userList;
    }

    public UserRegister() {
        this.userList= new ArrayList<User>();
    }

    /**
     * @return the userList
     */
    public ArrayList<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

}
