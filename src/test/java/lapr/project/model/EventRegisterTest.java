/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Manuel
 */
public class EventRegisterTest {
    
    private Event event1 = new Event();
    private Event event2 = new Event();
    private Event event3 = new Event();
    EventRegister eventRegister = new EventRegister();
    
    @Test
    public void registerEventFalseTest() {
        
        //Arrange
        eventRegister.addEvent(event1);
        
        //Act
        boolean expectedResult = false;
        boolean result = eventRegister.registerEvent(event1);
        
        //Assert
        Assert.assertEquals(result, expectedResult);
    }
    
    @Test
    public void registerEventTrueTest() {
        
        //Arrange
        eventRegister.addEvent(event1);
        
        //Act
        boolean expectedResult = true;
        boolean result = eventRegister.registerEvent(event2);
        
        //Assert
        Assert.assertEquals(result, expectedResult);
    }
    
    @Test
    public void userOrganiserTrueTest() {
        
        //Arrange
        User user = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        
        Organiser organiser = new Organiser(user);
        Organiser otherOrganiser = new Organiser(otherUser);
        
        OrganiserRegister organiserRegister = new OrganiserRegister();
        organiserRegister.addOrganiser(organiser);
        event1.addOrganiserRegister(organiserRegister);
        
        EventRegister eventRegister = new EventRegister();
        eventRegister.addEvent(event1);
        eventRegister.addEvent(event2);
        //Act
        boolean result = eventRegister.userIsOrganiser(otherUser);
        boolean expectedResult = true;
        
        //Assert
        Assert.assertEquals(result, expectedResult);
    }
    
    @Test
    public void userOrganiserFalseTest() {
        
        //Arrange
        User user = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Outro nome", "email@server.com", "user1", 0.1234);
        User otherUserButNoOrganiser = new User("Nao organiser", "email@server.com", "userr441", 0.433441234);
        
        Organiser organiser = new Organiser(user);
        Organiser otherOrganiser = new Organiser(otherUser);
        
        OrganiserRegister organiserRegister = new OrganiserRegister();
        organiserRegister.addOrganiser(organiser);
        event1.addOrganiserRegister(organiserRegister);
        
        EventRegister eventRegister = new EventRegister();
        eventRegister.addEvent(event1);
        eventRegister.addEvent(event2);
        //Act
        boolean result = eventRegister.userIsOrganiser(otherUserButNoOrganiser);
        //boolean expectedResult = false;
        System.out.println("result" + result);
        //Assert
        Assert.assertFalse(result);
    }
    
    @Test
    public void userIsStaffMemberrTrueTest() {
        
        //Arrange
        User user = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        
        StaffMember staffMember = new StaffMember(user);
        StaffMember otherStaffMember = new StaffMember(otherUser);
        
        StaffRegister staffRegister = new StaffRegister();
        staffRegister.addStaffMember(staffMember);
        event1.saveStaffRegister(staffRegister);
        
        EventRegister eventRegister = new EventRegister();
        eventRegister.addEvent(event1);
        eventRegister.addEvent(event2);
        //Act
        boolean result = eventRegister.userIsStaffMember(otherUser);
        boolean expectedResult = true;
        
        //Assert
        Assert.assertEquals(result, expectedResult);
    }
    
    @Test
    public void userStaffMemberFalseTest() {
        
        //Arrange
        User user = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Outro nome", "email@server.com", "user1", 0.1234);
        User otherUserButNoOrganiser = new User("Nao organiser", "email@server.com", "userr441", 0.433441234);
        
        StaffMember staffMember = new StaffMember(user);
        StaffMember otherstaffMember = new StaffMember(otherUser);
        
        StaffRegister staffRegister = new StaffRegister();
        staffRegister.addStaffMember(staffMember);
        event1.saveStaffRegister(staffRegister);
        
        EventRegister eventRegister = new EventRegister();
        eventRegister.addEvent(event1);
        eventRegister.addEvent(event2);
        //Act
        boolean result = eventRegister.userIsStaffMember(otherUserButNoOrganiser);
        //boolean expectedResult = false;
        System.out.println("result" + result);
        //Assert
        Assert.assertFalse(result);
    }
    
    @Test
    public void userIsEventManagerTest() {
        //Arrange
        User user = new User("Nome Nome", "email@server.com", "user1", 0.1234, Role.EVENT_MANAGER);
        User otherUser = new User("Outro nome", "email@server.com", "user1", 0.1234, Role.ATENDEE);
        
        EventRegister eventRegister = new EventRegister();
        boolean expected = eventRegister.userIsEventManager(user);
        Assert.assertTrue(expected);
        
    }
    
    @Test
    public void userIsEventManagerFalseTest() {
        //Arrange
        User user = new User("Nome Nome", "email@server.com", "user1", 0.1234, Role.ATENDEE);
        User otherUser = new User("Outro nome", "email@server.com", "user1", 0.1234, Role.ATENDEE);
        
        EventRegister eventRegister = new EventRegister();
        boolean expected = eventRegister.userIsEventManager(user);
        Assert.assertFalse(expected);
        
    }
    
    @Test
    public void existEventByDescriptionTrueTest() {
        //Arrange
       
        
        Event event1 = new Event();
        event1.setDescription("Evento");
        String s = "Evento";
        
        EventRegister eventRegister = new EventRegister();        
        eventRegister.addEvent(event1);
        Event event2 = eventRegister.existEventByDescription(s);
        Assert.assertNotNull(event2);
        
    }
      @Test
    public void existEventByDescriptionFalseTest() {
        //Arrange
       
        
        Event event1 = new Event();
        event1.setDescription("Evento");
        String s = "Outro Evento";
        
        EventRegister eventRegister = new EventRegister();        
        eventRegister.addEvent(event1);
        Event event2 = eventRegister.existEventByDescription(s);
        
        Assert.assertNotEquals(event2,event1);
        
    }
}
