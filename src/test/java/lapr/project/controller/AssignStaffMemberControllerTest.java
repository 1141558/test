/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Manuel Garnel
 */
public class AssignStaffMemberControllerTest {
    
   
    
    private User online = new User("userOnline1", "online1@hotmail.com", "online", 555555);
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
    private UserRegister userRegister = new UserRegister();
    
    private Event event = new Event();
    private ExhibitionCentre exhibitionCentre = new ExhibitionCentre();
    
    /**
     * Test of filterUserRegisterByNoOrganiserEventSelected of class
     * AssignStaffMemberController
     */
    @Test
    public void testfilterUserRegisterByNoOrganiserEventSelected() {
        
        //Arrange
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);
         userList.add(u6);
          userList.add(u7);
         
       
        
        organiserList.add(organiserU1);
        organiserList.add(organiserU2);
        organiserList.add(organiserU3);
        organiserRegister.setOrganiserList(organiserList);
        
        userRegister.setUserList(userList);
        System.out.println("userRegister: " + userRegister.toString());
        event.addOrganiserRegister(organiserRegister);
        exhibitionCentre.setUserRegister(userRegister);
      
 AssignStaffMemberController assignStaffMemberController = new AssignStaffMemberController( exhibitionCentre,online);
       
        
        //Act
        List<User> users = assignStaffMemberController.filterUserRegisterByNoOrganiserEventSelected(event, online);
        
        //Assert
          Assert .assertNotNull(users.get(0));
            Assert .assertNotNull(users.get(1));
        
    }
}
