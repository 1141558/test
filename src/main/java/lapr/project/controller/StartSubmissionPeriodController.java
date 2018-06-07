/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;

/**
 *
 * @author André Silva
 */
public class StartSubmissionPeriodController {
    
    private ExhibitionCentre exhibitionCentre;

    public StartSubmissionPeriodController() {
    }
    
    public List<Event> findEventByOrganiserAndState(Organiser organiser){
        List<Event> listEvent =  new ArrayList<>();
        
        for(Event e : this.exhibitionCentre.getEventRegister().getEventList()){
           if((e.getOrganisersList().getOrganiser().equals(organiser)) && e.isReadyForApplication())
               listEvent.add(e);
        }        
        return listEvent;
    }
    
    public boolean changeStateEventToSubmission(Event event){
       if(event.isReadyForApplication())
           event.setEventState(EventState.OPEN_APPLICATION);
           
       return event.isOpenApplication();
    }
    
}
