/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Manuel Garnel
 */
public class OrganiserTest {
     /**
     * Test of getName method, of class User.
     */
    @Test
    public void GetNameTest() {
        System.out.println("getName");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "Nome Nome";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    
    
     @Test
    public void equalsTest() {
        System.out.println("toString");
        //Arrange
        User organiser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User otherOrganiser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        
        organiser.equals(otherOrganiser);
        
         assertTrue(organiser.equals(otherOrganiser));
    }
    
}
