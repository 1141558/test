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

/**
 *
 * @author Altran
 */
class DummyData {
    
    Organiser org1 = new Organiser();
    Organiser org2 = new Organiser();
    OrganiserRegister organiserRegister = new OrganiserRegister();
    List<Organiser> organiserList = new ArrayList<>();
    ExhibitionCentre exhibitionCentre = new ExhibitionCentre();
    
     Event event1;
    Event event2 = new Event();
    Event event3= new Event();
    
    
    EventRegister eventRegister = new EventRegister();

    public EventRegister getEventRegsiter() {
        return eventRegister;
    }

    public void setEventRegsiter(EventRegister eventRegsiter) {
        this.eventRegister = eventRegsiter;
    }

    public DummyData() {
        organiserList.add(org1);
        organiserList.add(org2);
        organiserRegister.setOrganiserList(organiserList);
       
        this.event1 = new Event();
        event1.addOrganiserRegister(organiserRegister);
        eventRegister.setEvent(event1);
        exhibitionCentre.setEventRegister(eventRegister);
        
    }

    public OrganiserRegister getOrganiserRegister() {
        return organiserRegister;
    }

    public void setOrganiserRegister(OrganiserRegister organiserRegister) {
        this.organiserRegister = organiserRegister;
    }
    
}
