/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import lapr.project.utils.Utils;
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
     * Test of getName method, of class Organiser.
     */
    @Test
    public void GetNameTest() {
        System.out.println("getName");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "Nome Nome";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equalsUser method, of class Organiser.
     */
    @Test
    public void equalsTest() {
        System.out.println("toString");
        
        //Arrange
        User user = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);

        Organiser organiser = new Organiser(user);
        Organiser otherOrganiser = new Organiser(otherUser);
        boolean expectedResult = true;

        Object obj = new Organiser(otherUser);

        //Act
        boolean result = organiser.equals(obj);
       
        //Assert
        assertEquals(result, expectedResult);

    }
        @Test
    public void notEqualsTest() {
        System.out.println("toString");
        
        //Arrange
        User user = new User("Name name", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);

        Organiser organiser = new Organiser(user);
        Organiser otherOrganiser = new Organiser(otherUser);
        boolean expectedResult = true;

        Object obj = new Organiser(otherUser);

        //Act
        boolean result = organiser.equals(obj);
       
        //Assert
         Assert.assertNotEquals(result, expectedResult);

    }
}
