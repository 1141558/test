/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.util.Objects;
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
    /**
     * Test of hashCode method, of class Organiser.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Organiser organiserHashCode = new Organiser();
        int hash = 0;
         hash = 53 * hash + Objects.hashCode(organiserHashCode);
        int result = organiserHashCode.hashCode();
       // int expectedResult = organiserHashCode.hashCode();
        Assert.assertEquals(hash, result);
                
    }
     @Test
    public void compareToTest() {
        User user1 = new User("Filipa", "filipa@server.com", "user1", 0.1234);
        Organiser organiser1 = new Organiser(user1);
        
        
        User user2 = new User("Filipa", "filipa@server.com", "user1", 0.1234);
        Organiser organiser2 = new Organiser(user2);
        int result = organiser1.compareTo(organiser2);
         System.out.println("result" +result);
         Assert.assertEquals(0, result);
    }
}

