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
import lapr.project.model.User;

/**
 *
 * @author André Silva
 */
public class StartSubmissionPeriodController {
    
    private ExhibitionCentre exhibitionCentre;
    List<Event> listEvent;

    public StartSubmissionPeriodController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre = exhibitionCentre;
        this.listEvent = new ArrayList<>();
    }
    
    public List<Event> findEventByOrganiserAndState(User user){
        
        for(Event e : this.exhibitionCentre.getEventRegister().getEventList()){
            for (Organiser o : e.getOrganiserRegister().getOrganiserList()) {
                if(o.getOrganiser().getUsername().equals(user.getUsername()) && e.isReadyForApplication()){
                    listEvent.add(e);
                }
            }           
        }        
        return listEvent;
    }
    
    public boolean changeStateEventToSubmission(int indice){
        Event event = listEvent.get(indice);
        event.setEventState(EventState.OPEN_APPLICATION);
           
        return event.isOpenApplication();
    }
    
}
