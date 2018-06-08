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
import lapr.project.model.User;

/**
 *
 * @author Altran
 */
public class DummyData {
    
    Organiser org1;
    
    OrganiserRegister organiserRegister = new OrganiserRegister();
    OrganiserRegister organiserRegister2 = new OrganiserRegister();
    OrganiserRegister organiserRegister3 = new OrganiserRegister();
    
    List<Organiser> organiserList = new ArrayList<>();
    List<Organiser> organiserList2 = new ArrayList<>();
    List<Organiser> organiserList3 = new ArrayList<>();
    
    ExhibitionCentre exhibitionCentre;
    User u1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123);
    User u2 = new User("jose", "mail2@hotmail.com", "jo", 123);
    
    User u3 = new User("Andre", "mailu3", "andr", 133);
    User u4 = new User("Maria", "mariamail@hotmail.com", "mar", 123);
    
    User u5 = new User("Joaquim", "mailgdfgdgfdgu3", "jq", 133);
    User u6 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123);
    
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
        
        /*
        Event 1
        
        */
        org1 = new Organiser();
        org1.setOrganiser(u1);
        Organiser org2 = new Organiser();
        org2.setOrganiser(u2);
        
        organiserList.add(org2);
        organiserList.add(org1);
        organiserRegister.setOrganiserList(organiserList);
        
        this.event1 = new Event(organiserRegister);
        event1.setEventState(EventState.READY_FOR_APPLICATION);
        event1.addOrganiserRegister(organiserRegister);

        eventRegister.setEvent(event1);
        
        /*
        Event 2
        */
        Organiser org22 = new Organiser();
        org22.setOrganiser(u3);
        Organiser org222 = new Organiser();
        org222.setOrganiser(u4);
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
        Organiser org3_1 = new Organiser();
        org3_1.setOrganiser(u1);
        Organiser org3_2 = new Organiser();
        org3_2.setOrganiser(u6);
        organiserList3.add(org3_1);
        organiserList3.add(org3_2);
        
        organiserRegister3.setOrganiserList(organiserList3);
        this.event3 = new Event(organiserRegister3);
        event3.setTitle("Evento 3");
        event3.setEventState(EventState.READY_FOR_APPLICATION);
        event3.addOrganiserRegister(organiserRegister3);
        
        
        
        eventRegister.setEvent(event3);              
           
               
                
        

        eventRegister.addEvent(event1);

        exhibitionCentre.setEventRegister(eventRegister);
        
        
        
        exhibitionCentre.setUserOnline(u1);
        
        // event1.getOrganiserRegister().addOrganiser(org1);
    }
    
    public OrganiserRegister getOrganiserRegister() {
        return organiserRegister;
    }
    
    public void setOrganiserRegister(OrganiserRegister organiserRegister) {
        this.organiserRegister = organiserRegister;
    }
    
}
