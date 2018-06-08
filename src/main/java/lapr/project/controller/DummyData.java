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
    List<Organiser> organiserList = new ArrayList<>();
    ExhibitionCentre exhibitionCentre;
    User u1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123);
    
    Event event1 = new Event(organiserRegister);
    Event event2 = new Event(organiserRegister);
    Event event3 = new Event(organiserRegister);
    
    EventRegister eventRegister = new EventRegister();
    
    public EventRegister getEventRegister() {
        return eventRegister;
    }
    
    public void setEventRegsiter(EventRegister eventRegsiter) {
        this.eventRegister = eventRegsiter;
    }
    
    public DummyData(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre = exhibitionCentre;
        
        org1 = new Organiser();
        org1.setOrganiser(u1);
        Organiser org2 = new Organiser();
        org2.setOrganiser(u1);
        User us1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123);
        User us2 = new User("1", "1", "1", 1);
        Organiser org1 = new Organiser(us1);
        org2 = new Organiser(us2);
        
        organiserList.add(org1);
        
        organiserList.add(org2);
        organiserRegister.setOrganiserList(organiserList);
        
        this.event1 = new Event(organiserRegister);
        event1.setEventState(EventState.READY_FOR_APPLICATION);
        event1.addOrganiserRegister(organiserRegister);
        eventRegister.setEvent(event1);
        exhibitionCentre.setEventRegister(eventRegister);
        System.out.println("user on line");
        
        exhibitionCentre.setUserOnline(u1);
        System.out.println(exhibitionCentre.getUserOnline());
        event1.getOrganiserRegister().addOrganiser(org1);
    }
    
    public OrganiserRegister getOrganiserRegister() {
        return organiserRegister;
    }
    
    public void setOrganiserRegister(OrganiserRegister organiserRegister) {
        this.organiserRegister = organiserRegister;
    }
    
}
