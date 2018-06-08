/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Arrays;
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
    
    public UserRegistrationController(ExhibitionCentre exhibitionCentre){
        this.exhibitionCentre=exhibitionCentre;
        this.user=new User();
    }
    
    
    
    
    public void setData(String name, String email, String username, String password){
        
        this.user.setName(name);
        this.user.setEmail(email);
        this.user.setUsername(username);
        
        System.out.println(encryptPassword(password));
        this.user.setPassword(encryptPassword(password));
        
     
        
    }
    
    
    public boolean addUser() {
        return this.exhibitionCentre.getUserRegister().addUser(this.user);
    }
    
}
