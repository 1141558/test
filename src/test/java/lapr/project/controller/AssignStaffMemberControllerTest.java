/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Role;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Manuel Garnel
 */
public class AssignStaffMemberControllerTest {
    
    /**
     * Data to be used on the tests
     *
     */
    private User userOnline = new User("userOnline1", "online1@hotmail.com", "online", 555555);
    private User u1 = new User("manuel", "manuel@hotmail.com", "garnel", 555555);
    private User u2 = new User("jose", "manuel@hotmail.com", "jo", 123321);
    private User u3 = new User("garnel", "garnel@hotmail.com", "garne", 321123);
    private EventRegister eventRegister3 = new EventRegister();
    private Organiser organiserU1 = new Organiser(u1);
    private Organiser organiserU2 = new Organiser(u2);
    private Organiser organiserU3 = new Organiser(u3);
    private OrganiserRegister organiserRegister = new OrganiserRegister();
    private List<Organiser> organiserList = new ArrayList<>();
    private List<StaffMember> staffMemberList = new ArrayList<>();
    
    private User u4 = new User("Andre", "mailu3@portugal.pt", "andr", 133);
    private User u5 = new User("Maria", "mariamail@hotmail.com", "mar", 123);
    private User u6 = new User("Joaquim", "mailgdfgdgfdgu3@portugal.pt", "jq", 133);
    private User u7 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123);
    
    private User u8 = new User("Marg ", "magdfgail@hotmail.com", "marg ", 123);
    private StaffMember staffMember1 = new StaffMember();
    
    private List<User> userList = new ArrayList<>();
    
    private List<User> userList2 = new ArrayList<>();
    private UserRegister userRegister = new UserRegister();
    
    private UserRegister userRegister2 = new UserRegister();
    StaffRegister staffRegister = new StaffRegister();
    
    private Event event = new Event();
    private ExhibitionCentre exhibitionCentre = new ExhibitionCentre();
    private ExhibitionCentre exhibitionCentre2 = new ExhibitionCentre();
    private ExhibitionCentre ec = new ExhibitionCentre();
    
    DummyData dummy = new DummyData(exhibitionCentre);
    
    private Event event3 = new Event();
    
    @Test
    public void getEventsLisByOrganiserTest() {
        
        //Arrange
        AssignStaffMemberController assignStaffMemberController3 = new AssignStaffMemberController(exhibitionCentre);
        
        //Act
        List<Event> eventListByOrganiser = assignStaffMemberController3.getEventsListByOrganiser();
        
        //Assert
        Assert.assertEquals(eventListByOrganiser.get(1).getTitle(), "EVENTO UM");
    }
    
    @Test
    public void selectEventTest() {
        
        //Arrange
        AssignStaffMemberController assignStaffMemberController = new AssignStaffMemberController(exhibitionCentre);
        
        //Act
        assignStaffMemberController.selectEvent(event3);
        
        assignStaffMemberController.getStaffMemberList();
        //Assert
        Assert.assertEquals(event3, event3);
    }
    
    @Test
    public void filterUserRegisterByNoOrganiserEventSelectedTest() {
        
        //Arrange
        ExhibitionCentre ec = new ExhibitionCentre();
        AssignStaffMemberController assignStaffMemberController = new AssignStaffMemberController(exhibitionCentre);
        StaffMember staffMemberOne = new StaffMember();
        staffMemberOne.setUser(u1);
        assignStaffMemberController.selectEvent(event3);
        assignStaffMemberController.addStaffMemberToEvent(staffMemberOne);
        
        //Act
        List<User> users = assignStaffMemberController.filterUserRegisterByNoOrganiserEventSelected();
        
        //Assert
        Assert.assertEquals("manuel", users.get(0).getName());
        Assert.assertEquals("garnel", users.get(0).getUsername());
        Assert.assertEquals("mjdg111@hotmail.com", users.get(0).getEmail());
    }
  
    @Test
    public void assignUserTest() {
        
        //Arrange
        User availableUser1 = new User("jose", "manuel@hotmail.com", "jo", 123321);
        User availableUser2 = new User("Manuel garnel", "garnel@hotmail.com", "garne", 321123);
        Event event1 = new Event();
        DummyData data = new DummyData(exhibitionCentre);
        AssignStaffMemberController aStaffMembController = new AssignStaffMemberController(exhibitionCentre);
        aStaffMembController.selectEvent(event3);
        UserRegister usReg = new UserRegister();
        exhibitionCentre.setUserRegister(usReg);
        List<Event> eventList = new ArrayList<>();
        List<User> users = new ArrayList<>();
        users.add(availableUser1);
        StaffMember staffMember = new StaffMember(availableUser2);
        staffMemberList.add(staffMember);
        staffRegister.add(staffMemberList);
        event3.setStaffRegister(staffRegister);
        eventList.add(event3);
        eventRegister3.setEventList(eventList);
        exhibitionCentre.setEventRegister(eventRegister3);
        
        //Act
        aStaffMembController.assignUser(users, 1);
        
        //Assert
        Assert.assertEquals(eventRegister3.getEvent(0).getStaffRegister().getStaffList().get(0).getStaff().getName().toString(), "Manuel garnel");
        
    }
    @Test
    public void getAvailableUsers() {
        
      //Arrange
        User availableUser1 = new User("jose", "manuel@hotmail.com", "jo", 123321);
        User availableUser2 = new User("Manuel garnel", "garnel@hotmail.com", "garne", 321123);
        Event event1 = new Event();
        DummyData data = new DummyData(exhibitionCentre);
        AssignStaffMemberController aStaffMembController = new AssignStaffMemberController(exhibitionCentre);
        aStaffMembController.selectEvent(event3);
        UserRegister usReg = new UserRegister();
        exhibitionCentre.setUserRegister(usReg);
        List<Event> eventList = new ArrayList<>();
        List<User> users = new ArrayList<>();
        users.add(availableUser1);
        StaffMember staffMember = new StaffMember(availableUser2);
        staffMemberList.add(staffMember);
        staffRegister.add(staffMemberList);
        event3.setStaffRegister(staffRegister);
        eventList.add(event3);
        eventRegister3.setEventList(eventList);
        exhibitionCentre.setEventRegister(eventRegister3);
        List<User> expecteds = new ArrayList<>();
                  
      List<User> actuals=   aStaffMembController.getAvailableUsers();
      //actuals.get(0);
      //expecteds.get(0);
      // Assert.assertEquals(expecteds, actuals);
        
                
    }
}
