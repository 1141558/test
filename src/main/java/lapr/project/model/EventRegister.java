/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Collections;
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
    public boolean registerEvent(Event e){
        return eventList.contains(e)
               ? false
               :eventList.add(e);
    }
    /**
     * @return the eventList
     */
    public List<Event> getEventList() {
        return eventList;
    }
    /*
    * Este metodo verifica se o utilizador recebido por parametro é organizador de algum evento
    */
    public boolean userIsOrganiser(User u){
        for (Event event : this.eventList) {
            for (Organiser o : event.getOrganiserRegister().getOrganiserList()) {
                if(o.getOrganiser().getUsername().equals(u.getUsername())){
                    return true;
                }
            }
        }
     return false;   
    }
    public boolean userIsStaffMember(User u){
        for (Event event : this.eventList) {
            for (StaffMember sm : event.getStaffRegister().getListStaff()) {
                if(u.getUsername().equals(sm.getStaffUser().getUsername())){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean userIsEventManager(User u){
        for (Event event : this.eventList) {
            if(event.getEventManager().getEventManager().getUsername().equals(u.getUsername())){
                return true;
            }
        }
        return false;
    }
    /**
     * @param eventList the eventList to set
     */
    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public void setEvent(Event event1) {
         eventList.add(event1);
    }

    @Override
    public String toString() {
        return "EventRegister{" + "eventList=" + eventList + '}';
    }

}
