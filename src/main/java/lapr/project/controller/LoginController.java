/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.ExhibitionCentre;
import lapr.project.model.PasswordEncryption;
import lapr.project.model.User;

/**
 *
 * @author MariaJoão
 */
public class LoginController {
    
    ExhibitionCentre centre;
    
    
    public LoginController(ExhibitionCentre centre){
      this.centre= centre;
           
    } 

    public boolean login(String username, String passwordString) {
        for (User u : centre.getUserRegister().getUserList()) {
            if(u.getUsername().equals(username)){
                if(Double.compare(u.getPassword(), PasswordEncryption.encryptPassword(passwordString))==0){
                    centre.setUserOnline(u);
                    return true;
                    
                }
                
            }
        }
        return false;


    }
    
    
    
}