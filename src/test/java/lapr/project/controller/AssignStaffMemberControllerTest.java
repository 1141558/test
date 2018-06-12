/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
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
    
    private Organiser organiserU1 = new Organiser(u1);
    private Organiser organiserU2 = new Organiser(u2);
    private Organiser organiserU3 = new Organiser(u3);
    private List<Organiser> organiserList = new ArrayList<>();
    private OrganiserRegister organiserRegister = new OrganiserRegister();
    
    private User u4 = new User("Andre", "mailu3@portugal.pt", "andr", 133);
    private User u5 = new User("Maria", "mariamail@hotmail.com", "mar", 123);
    private User u6 = new User("Joaquim", "mailgdfgdgfdgu3@portugal.pt", "jq", 133);
    private User u7 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123);
    private List<User> userList = new ArrayList<>();
    private List<User> userList2 = new ArrayList<>();
    private UserRegister userRegister = new UserRegister();
    private UserRegister userRegister2 = new UserRegister();
    
    private Event event = new Event();
    private ExhibitionCentre exhibitionCentre = new ExhibitionCentre();
    private ExhibitionCentre exhibitionCentre2 = new ExhibitionCentre();
     
   
    /**
     * Test of filterUserRegisterByNoOrganiserEventSelected of class
     * AssignStaffMemberController
     */
//    @Test
//    public void testfilterUserRegisterByNoOrganiserEventSelected() {
//        
//        //Arrange
//        userList.add(u1);
//        userList.add(u2);
//        userList.add(u3);
//        userList.add(u4);
//        userList.add(u5);
//        userList.add(u6);
//        userList.add(u7);
//        
//        organiserList.add(organiserU1);
//        organiserList.add(organiserU2);
//        organiserList.add(organiserU3);
//        organiserRegister.setOrganiserList(organiserList);
//        
//        userRegister.setUserList(userList);
//        System.out.println("userRegister: " + userRegister.toString());
//        event.addOrganiserRegister(organiserRegister);
//        exhibitionCentre.setUserRegister(userRegister);
//        
//        AssignStaffMemberController assignStaffMemberController = new AssignStaffMemberController(exhibitionCentre, userOnline);
//        
//        //Act
//        List<User> users = assignStaffMemberController.filterUserRegisterByNoOrganiserEventSelected(event, userOnline);
//        
//        //Assert
//        Assert.assertNotNull(users.get(0));
//        Assert.assertNotNull(users.get(1));
//        
//    }
//    
//    @Test
//    public void showUsersExhibitionCentreTest() {
//        
//        //Arrange
//        userList2.add(u1);
//        userList2.add(u2);
//        userRegister2.setUserList(userList2);
//        exhibitionCentre2.setUserRegister(userRegister2);
//        List<User> usersReturn = new ArrayList<>();
//        
//        //Act
//        AssignStaffMemberController assignStaffMemberController2 = new AssignStaffMemberController(exhibitionCentre2);
//        usersReturn = assignStaffMemberController2.getUsersExhibitionCentre();
//        
//        //Assert
//        Assert.assertEquals("manuel", usersReturn.get(0).getName());
//        Assert.assertEquals("garnel", usersReturn.get(0).getUsername());
//        Assert.assertEquals("jose", usersReturn.get(1).getName());
//        Assert.assertEquals("jo", usersReturn.get(1).getUsername());
//        
//    }
//    
    @Test
    public void getEventsLisByOrganiserTest() {
        //Arrange
        Event event3 = new Event();
        OrganiserRegister organiserRegister3 = new OrganiserRegister();
        
        exhibitionCentre.setUserOnline(userOnline);
        organiserList.add(organiserU1);
        organiserList.add(organiserU2);
        organiserRegister3.setOrganiserList(organiserList);
        event3.setOrganisersRegister(organiserRegister3);
        EventRegister eventRegister3 = new EventRegister();
        eventRegister3.addEvent(event3);
        exhibitionCentre.setEventRegister(eventRegister3);
        
         //Act
      AssignStaffMemberController assignStaffMemberController3 = new AssignStaffMemberController(exhibitionCentre2);
        List <Event> eventListByOrganiser = assignStaffMemberController3.getEventsListByOrganiser();
        
         //Assert
         Assert.assertEquals(eventListByOrganiser.get(0).getTitle(),"EVENTO UM");
    }
//     @Test
//    public void getAvailableUsers() {
//        
//          //Arrange
//              User userOnline = new User("userOnline1", "online1@hotmail.com", "online", 555555);
//             User u10 = new User("Andre", "mailu3@portugal.pt", "andr", 133);
//            User u11 = new User("Maria", "mariamail@hotmail.com", "mar", 123);
//              List<User> userList = new ArrayList<>();
//              userList.add(u10);
//              userList.add(u11);
//              
//              UserRegister userRegister4 = new UserRegister();
//              userRegister4.setUserList(userList);
//              
//              Event event = new Event();
//             
//        
//       
//        exhibitionCentre2.setUserRegister(userRegister4);
//      
//        List<User> usersReturn = new ArrayList<>();
//        AssignStaffMemberController assignStaffMemberController3 = new AssignStaffMemberController(exhibitionCentre2,userOnline);
//        //Act
//       
//         System.err.println("teste teste"+
//                assignStaffMemberController3.getAvailableUsers(event, userOnline));
//        
//        //Assert
////        Assert.assertEquals("manuel", usersReturn.get(0).getName());
////        Assert.assertEquals("garnel", usersReturn.get(0).getUsername());
////        Assert.assertEquals("jose", usersReturn.get(1).getName());
////        Assert.assertEquals("jo", usersReturn.get(1).getUsername());
//         System.out.println("users"+ usersReturn);
//    }
}
