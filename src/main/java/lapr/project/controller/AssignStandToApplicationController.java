/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

 
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Stand;
import lapr.project.utils.Utils;

/**
 *
 * @author Altran
 */
public class AssignStandToApplicationController {
    
   Event event;
   Stand stand;
   Application application;
    ExhibitionCentre exhibitionCentre;

    public AssignStandToApplicationController(Event event, Stand stand, Application application) {
        this.event = event;
        this.stand = stand;
        this.application = application;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
    
   
 
   
    
    
}
