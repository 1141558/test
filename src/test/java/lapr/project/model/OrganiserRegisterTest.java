/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Altran
 */
public class OrganiserRegisterTest {
    
    @Test
    public void organiserRegisterTest() {
        //Arrange
        User user = new User("Name name", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User inexistentUser = new User("Nome sem nome", "semmail@server.com", "noUser1", 0.1234);
        int size;
        Organiser noOrganiser = new Organiser(inexistentUser);
        Organiser organiser = new Organiser(user);
        Organiser otherOrganiser = new Organiser(otherUser);
        OrganiserRegister organiserRegister = new OrganiserRegister();
        
        //Act
        organiserRegister.addOrganiser(organiser);
        organiserRegister.registerOrganiser(user);
        OrganiserRegister otherOrganiserRegister = new OrganiserRegister();
        otherOrganiserRegister.addOrganiser(organiser);
        otherOrganiserRegister.addOrganiser(organiser);
        otherOrganiserRegister.registerOrganiser(user);
        size = organiserRegister.sizeOrganiserList();
        OrganiserRegister organiserRegister123 = new OrganiserRegister(organiserRegister.getOrganiserList());
        
        //Assert
        Assert.assertEquals(otherOrganiserRegister, organiserRegister);
        Assert.assertEquals(1, size);
        Assert.assertTrue(otherOrganiserRegister.registerOrganiser(inexistentUser));
        
    }
    
    @Test
    public void organiserRegisterTestTrue() {
        
        //Arrange
        User user = new User("Name name", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        OrganiserRegister organiserRegister = new OrganiserRegister();
        System.out.println("No added organiser " + organiserRegister.toString());
        Organiser organiser = new Organiser(user);
        boolean expecteds = true;
        
        //Act
        boolean actuals = organiserRegister.addOrganiser(organiser);
        
        //Assert
        Assert.assertEquals(expecteds, actuals);
    }
    
    @Test
    public void organiserRegisterTestFalse() {
        
        //Arrange
        User user = new User("Name name", "email@server.com", "user", 0.1234);
        User otherUser = new User("Outro nome", "email2@server.com", "user1", 0.1234);
        OrganiserRegister organiserRegister = new OrganiserRegister();
        
        Organiser organiser = new Organiser(user);
        Organiser organiser1 = new Organiser(otherUser);
        boolean expecteds = true;
        
        //Act
        organiserRegister.addOrganiser(organiser);
        organiserRegister.addOrganiser(organiser1);
        
        //Assert
        Assert.assertNotEquals(organiserRegister.getOrganiserList().get(0), organiserRegister.getOrganiserList().get(1));
    }
    
    @Test
    public void notEqualsTest() {
        
        //Arrange
        User user = new User("Name name", "email@server.com", "user", 0.1234);
        User otherUser = new User("Outro nome", "email2@server.com", "user1", 0.1234);
        
        OrganiserRegister organiserRegister = new OrganiserRegister();
        
        Organiser organiser = new Organiser(user);
        Organiser organiser1 = new Organiser(otherUser);
        boolean expecteds = true;
        
        //Assert
        Assert.assertFalse(organiserRegister.equals(otherUser));
        
        
    }
    
    @Test
    public void hashCodeTest() {
        
        OrganiserRegister organiserRegister = new OrganiserRegister();
        OrganiserRegister organiserRegister1 = new OrganiserRegister();
        Assert.assertEquals(organiserRegister.hashCode(), organiserRegister1.hashCode());
    }
    
}