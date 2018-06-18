/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.controller.DummyData;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Role;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;


/**
 *
 * @author andre
 */
public class ReadFileStandTest {
    
    Organiser org1;
    Organiser org2;
    Organiser org3;
    
    Date data1, data2, data3, data4;
    
    OrganiserRegister organiserRegister4 = new OrganiserRegister();
    
    List<Organiser> organiserList4 = new ArrayList<>();
    
  
    StaffRegister staffRegister4 = new StaffRegister();
    
    List<StaffMember> staffMemberListEvent4 = new ArrayList<>();
    
    ExhibitionCentre exhibitionCentre = new ExhibitionCentre();
    User user1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
    User user2 = new User("jose", "mail2@hotmail.com", "jo", 123 , Role.ATENDEE);
    User user3 = new User("sandra", "sandra@hotmail.com", "antunex", 123 , Role.ATENDEE);
    User user4 = new User("staffElement1_manuel", "mjdg111@hotmail.com", "garnel23", 123 , Role.ATENDEE);
    User user5 = new User("staffElment2_jose", "Jose@hotmail.com", "Jose1234", 123, Role.ATENDEE);
    User user6 = new User("O2", "mail2@hotmail.com", "orga2", 123, Role.ATENDEE);    
    User user7 = new User("Andre", "mailu3", "andr", 133 , Role.ATENDEE);
    User user8 = new User("Luisa", "Luisa@hotmail.com", "mar", 123, Role.EMPLOYEE);   
    User user9 = new User("Joaquim", "mailgdfgdgfdgu3", "jq", 133, Role.ATENDEE);
    User user10 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123, Role.ATENDEE);
    
    Event event4;
    
    EventRegister eventRegister = new EventRegister();
    
    public EventRegister getEventRegister() {
        return eventRegister;
    }
    
    public void setEventRegsiter(EventRegister eventRegsiter) {
        this.eventRegister = eventRegsiter;
    }
    
    //*****************************************************************************************
    //************************Criar registo de utilizadores***********************************
    public void createUsers() {
        UserRegister userRegister = new UserRegister();
        
        List<User> usersCentre = new ArrayList<>();
        
        usersCentre.add(user1);
        usersCentre.add(user2);
        usersCentre.add(user3);
        usersCentre.add(user4);
        usersCentre.add(user5);
        usersCentre.add(user6);
    
        usersCentre.add(user7);
        usersCentre.add(user8);
        usersCentre.add(user9);       
        usersCentre.add(user10);
       
        userRegister.setUserList(usersCentre);
      
        exhibitionCentre.setUserRegister(userRegister);
        exhibitionCentre.setEventRegister(eventRegister);

    }
    
    public ReadFileStandTest() {
        
        /*
        Event 4

        */

        org1 = new Organiser();
        org1.setOrganiser(user1);
        org2 = new Organiser();
        org2.setOrganiser(user2);


        organiserList4.add(org2);
        organiserList4.add(org1);

        organiserRegister4.setOrganiserList(organiserList4);

        StaffMember staff41 = new StaffMember();
        StaffMember staff42 = new StaffMember();

        staff41.setUser(user4);
        staff42.setUser(user5);
        staffMemberListEvent4.add(staff41);
        staffMemberListEvent4.add(staff42);

        staffRegister4.add(staffMemberListEvent4);

        this.event4 = new Event(organiserRegister4);

        this.event4.setTitle("EVENTO 4");
        event4.setEventState(EventState.CREATED);
        event4.addOrganiserRegister(organiserRegister4);
        event4.setStaffRegister(staffRegister4);
        event4.setDaysApplication(4);
        event4.setStartDate(data1);
        event4.setEndDate(data2);
        eventRegister.addEvent(event4);
        
        createUsers();
    }
    
//    /**
//     * Test of run method, of class ReadFileStand.
//     */
//    @Test
//    public void testRun() throws Exception {
//        ExhibitionCentre  centre = new ExhibitionCentre();
//        System.out.println("Read File 1");
//        ReadFileStand instance = new ReadFileStand();
//        instance.run(exhibitionCentre);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//    
}