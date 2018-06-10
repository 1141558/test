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
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;

/**
 *
 * @author Altran
 */
public class DummyData {
    
    Organiser org1;
    Organiser org2;
    Organiser org3;
    
    OrganiserRegister organiserRegister = new OrganiserRegister();
    OrganiserRegister organiserRegister2 = new OrganiserRegister();
    OrganiserRegister organiserRegister3 = new OrganiserRegister();
    
    List<Organiser> organiserList = new ArrayList<>();
    List<Organiser> organiserList2 = new ArrayList<>();
    List<Organiser> organiserList3 = new ArrayList<>();
    
    StaffRegister staffRegister1 = new StaffRegister();
    List<StaffMember> staffMemberListEvent1 = new ArrayList<>();
    
    ExhibitionCentre exhibitionCentre;
    User user1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123);
    User user2 = new User("jose", "mail2@hotmail.com", "jo", 123);
    User user3 = new User("sandra", "sandra@hotmail.com", "antunex", 123);
    User user4 = new User("staffElement1_manuel", "mjdg111@hotmail.com", "garnel23", 123);
    User user5 = new User("staffElment2_jose", "Jose@hotmail.com", "Jose1234", 123);
    User user6 = new User("Organiser2", "mail2@hotmail.com", "orga2", 123);    
    User user7 = new User("Andre", "mailu3", "andr", 133);
    User user8 = new User("Luisa", "Luisa@hotmail.com", "mar", 123);   
    User user9 = new User("Joaquim", "mailgdfgdgfdgu3", "jq", 133);
    User user10 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123);
    
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
        System.out.println("user do centro" + usersCentre);
        exhibitionCentre.setUserRegister(userRegister);

    }
    
    //*********************************************************************************************
    Event event1;
    Event event2;
    Event event3;
    
    EventRegister eventRegister = new EventRegister();
    
    public EventRegister getEventRegister() {
        return eventRegister;
    }
    
    public void setEventRegsiter(EventRegister eventRegsiter) {
        this.eventRegister = eventRegsiter;
    }
    
    public DummyData(ExhibitionCentre exhibitionCentre) {
        
        this.exhibitionCentre = exhibitionCentre;
        
        createUsers();
        /*
        Event 1
        
        */
        
        org1 = new Organiser();
        org1.setOrganiser(user1);
        org2 = new Organiser();
        org2.setOrganiser(user2);
        org3 = new Organiser();
        org3.setOrganiser(user3);
        
        organiserList.add(org2);
        organiserList.add(org1);
        organiserList.add(org3);
        organiserRegister.setOrganiserList(organiserList);
        
        StaffMember staff11 = new StaffMember();
        StaffMember staff12 = new StaffMember();
        
        staff11.setStaff(user4);
        staff12.setStaff(user5);
        staffMemberListEvent1.add(staff11);
        staffMemberListEvent1.add(staff12);
        
        staffRegister1.add(staffMemberListEvent1);
        
        this.event1 = new Event(organiserRegister);
        
        this.event1.setTitle("EVENTO UM");
        event1.setEventState(EventState.READY_FOR_APPLICATION);
        event1.addOrganiserRegister(organiserRegister);
        event1.setStaffRegister(staffRegister1);
        eventRegister.setEvent(event1);
        
        /*
        Event 2
        */
        Organiser org22 = new Organiser();
        org22.setOrganiser(user7);
        Organiser org222 = new Organiser();
        org222.setOrganiser(user8);
        organiserList2.add(org22);
        organiserList2.add(org222);
        organiserRegister2.setOrganiserList(organiserList2);
        this.event2 = new Event(organiserRegister2);
        event2.setTitle("Evento 2");
        event2.setEventState(EventState.READY_FOR_APPLICATION);
        event2.addOrganiserRegister(organiserRegister2);
        eventRegister.setEvent(event2);
        
        /*
        Event 3
        */
        Organiser org31 = new Organiser();
        org31.setOrganiser(user9);
        Organiser org32 = new Organiser();
        org32.setOrganiser(user10);
        organiserList3.add(org31);
        organiserList3.add(org32);
        
        organiserRegister3.setOrganiserList(organiserList3);
        this.event3 = new Event(organiserRegister3);
        event3.setTitle("Evento 3");
        event3.setEventState(EventState.READY_FOR_APPLICATION);
        event3.addOrganiserRegister(organiserRegister3);
        
        eventRegister.addEvent(event1);
        eventRegister.addEvent(event2);
        eventRegister.addEvent(event3);
        exhibitionCentre.setEventRegister(eventRegister);
        
        exhibitionCentre.setUserOnline(user1);
        
    }
    
    public OrganiserRegister getOrganiserRegister() {
        return organiserRegister;
    }
    
    public void setOrganiserRegister(OrganiserRegister organiserRegister) {
        this.organiserRegister = organiserRegister;
    }
    
}
