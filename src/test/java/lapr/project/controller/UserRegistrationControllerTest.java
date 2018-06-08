/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.ExhibitionCentre;
import lapr.project.model.PasswordEncryption;
import lapr.project.model.User;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class UserRegistrationControllerTest {
    
    /**
     * Test of setData method, of class UserRegistrationController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        User user=new User("nome completo","email@server.com","user",PasswordEncryption.encryptPassword("12345678"));
        String name = "nome completo";
        String email = "email@server.com";
        String username = "user";
        String password = "12345678";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        instance.setData(name, email, username, password);
        assertEquals(user.getName(), instance.getUser().getName());
        assertEquals(user.getEmail(), instance.getUser().getEmail());
        assertEquals(user.getUsername(), instance.getUser().getUsername());
        assertEquals(user.getPassword(), instance.getUser().getPassword(),0);
        
    }

    /**
     * Test of addUser method, of class UserRegistrationController.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String name = "nome completo";
        String email = "email@server.com";
        String username = "user";
        String password = "12345678";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        instance.setData(name, email, username, password);
        instance.addUser();
        assertTrue(centre.getUserRegister().getUserList().contains(instance.getUser()));
        
    }
    
}
