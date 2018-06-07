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

/**
 *
 * @author Altran
 */
class DummyData {
    
   // Organiser org1 = new Organiser("manuel", "mjdg111@hotmail.com","garnel",123);
    Organiser org3323 = new Organiser();
    OrganiserRegister organiserRegister = new OrganiserRegister();
    List<Organiser> organiserList = new ArrayList<>();
    ExhibitionCentre exhibitionCentre = new ExhibitionCentre();
    
     Event event1 = new Event(organiserRegister);
    Event event2 = new Event(organiserRegister);
    Event event3= new Event(organiserRegister);
    
    
    EventRegister eventRegister = new EventRegister();

    public EventRegister getEventRegsiter() {
        return eventRegister;
    }

    public void setEventRegsiter(EventRegister eventRegsiter) {
        this.eventRegister = eventRegsiter;
    }

    public DummyData() {
           User us1 = new User("manuel", "mjdg111@hotmail.com","garnel",123);
          Organiser org1= new Organiser(us1);
          
          
        organiserList.add(org1);
        System.out.println(org1);
        System.err.println(organiserList);
        organiserList.add(org3323);
        organiserRegister.setOrganiserList(organiserList);
       
        this.event1 = new Event(organiserRegister);
        event1.addOrganiserRegister(organiserRegister);
        eventRegister.setEvent(event1);
        exhibitionCentre.setEventRegister(eventRegister);
         System.out.print(exhibitionCentre);
        
    }

    public OrganiserRegister getOrganiserRegister() {
        return organiserRegister;
    }

    public void setOrganiserRegister(OrganiserRegister organiserRegister) {
        this.organiserRegister = organiserRegister;
    }
    
}
