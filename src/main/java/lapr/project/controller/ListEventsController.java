/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author MariaJoão
 */
public class ListEventsController {

    ExhibitionCentre centre;
    private Event event;
    private ApplicationState state;
    public ListEventsController(ExhibitionCentre centre) {
        this.centre=centre;
        this.event=new Event();
    }

    public List<Event> getEventsFromUser() {
        return this.centre.getEventRegister().getEventListByOrganiser(centre.getUserOnline());

    }

    public void eventPicked(int i) {
        this.event= getEventsFromUser().get(i);

    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param state the state to set
     */
    public void setState(ApplicationState state) {
        this.state = state;
    }
    
}
