/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MariaJoão
 */
public class EventRegister {
    private List<Event> eventList;

    public EventRegister(List<Event> eventList) {
        this.eventList = eventList;
    }

    public EventRegister() {
        this.eventList= new ArrayList<>();
    }

    /**
     * @return the eventList
     */
    public List<Event> getEventList() {
        return eventList;
    }

    /**
     * @param eventList the eventList to set
     */
    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

}
