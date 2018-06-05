/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;


/**
 *
 * @author MariaJoão
 */
public class EventRegister {
    private ArrayList<Event> eventList;

    public EventRegister(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    public EventRegister() {
        this.eventList= new ArrayList<Event>();
    }

    /**
     * @return the eventList
     */
    public ArrayList<Event> getEventList() {
        return eventList;
    }

    /**
     * @param eventList the eventList to set
     */
    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

}
