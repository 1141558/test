/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

 
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegister;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.Stand;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author Manuel Garnel
 */
public class AssignStandToApplicationController {
    
   Event event;
   Stand stand;
   Application application;
    ExhibitionCentre exhibitionCentre;
    Organiser organiser;

    ApplicationRegister appRegister = new ApplicationRegister();

    public AssignStandToApplicationController(Event event, Stand stand) {
        this.event = event;
        this.stand = stand;
      
    }

 
    
    
    public List<Application> getApplicationsByEventAndByOrganiser(){
        User organiser = exhibitionCentre.getUserOnline();
       EventRegister eventRegister = exhibitionCentre. getEventRegister();
      List<Event> eventList = eventRegister.getEventListByOrganiser(organiser);
      
      return filteringList(eventList, organiser);
    }

    private List<Application> filteringList(List<Event> event, User organiser) {
         for (Event event1 : event) {
           // if(event1.getOrganiserRegister().getOrganiserList())
          
        }
          return null;
    }
  
 
   
    
    
}
