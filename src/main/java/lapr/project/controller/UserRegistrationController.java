/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Arrays;
import lapr.project.model.User;
import static lapr.project.model.PasswordEncryption.encryptPassword;

/**
 *
 * @author JM
 */
public class UserRegistrationController {
    
    private User user;
    
    public UserRegistrationController(){
        this.user=new User();
    }
    
    
    
    
    public boolean setData(String name, String email, String username, String password){
        
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        
        System.out.println(encryptPassword(password));
        user.setPassword(encryptPassword(password));
        
     
        
        return true;
    }
    
    
}
