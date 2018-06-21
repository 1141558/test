/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegister;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.Role;
import lapr.project.model.Stand;
import lapr.project.model.User;


/**
 *
 * @author Manuel Garnel
 */
public class AssignStandToApplicationController {
    
    Event event;
    Stand stand;
    Application application;
    ExhibitionCentre exhibitionCentre;
    EventRegister eventRegister;
    Organiser organiser;
    
      String accepted = "ACCEPTED";
    
    ApplicationRegister appRegister = new ApplicationRegister();
    
    public AssignStandToApplicationController(Event event, Stand stand) {
        this.event = event;
        this.stand = stand;
        
    }
    
    public AssignStandToApplicationController(Event event)
    {
        this.event = event;
    }

    public AssignStandToApplicationController() {
    
    }
    public void matchsApplicationOnEventListByOrganiserWithStandList() {
       
       User organiser = new User("manuel","fcsd@","ewr",12345678,Role.EMPLOYEE);
     
         eventRegister = exhibitionCentre.getEventRegister();
       List<Event> eventList = eventRegister.getEventListByOrganiser(organiser);
         filteringList(eventList, organiser);
 
        }
      
        
        
     
    
    
    private List<Application> filteringList(List<Event> event, User organiser) {
       List<Application> applicationsAccepted = new ArrayList<>();
        for (Event eventItem : event) {
            List<Stand> standsListByEvent = eventItem.getStandRegister().getStandList();
           applicationsAccepted = eventItem.getEventApplicationByAcception();
           
        }
        return applicationsAccepted;
    }
    
}
