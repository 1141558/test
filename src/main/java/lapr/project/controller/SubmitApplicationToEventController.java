/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author MariaJoão
 */
public class SubmitApplicationToEventController {

    Application application;  
    ExhibitionCentre centre;
    public SubmitApplicationToEventController(ExhibitionCentre centre) {
        this.application= new Application();
        this.centre=centre;
    }

    public void setData(String description, int nInvites, List<String> keywords, double area) {
    }

    public List<Event> getEventsReadyForApplications() {
        List<Event> list= new ArrayList<>(); 
        for (Event e : centre.getEventRegister().getEventList()) {
            if(e.getEventState().equals(EventState.OPEN_APPLICATION)){
                list.add(e);
            }
        }
        return list;
    }
    
}
