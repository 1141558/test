/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CalculateElectricalCable;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.StandConnection;

/**
 *
 * @author JM
 */
public class CalculateCableController {
    
    private ExhibitionCentre exhibitionCentre;
    
    public CalculateCableController(ExhibitionCentre exhibitionCentre){
        this.exhibitionCentre=exhibitionCentre;
        
    }
    
    public List getEventList(){
        return exhibitionCentre.getEventRegister().getEventList();
    }
    
    public boolean eventExists(String eventTitle){
        for(Event ev:exhibitionCentre.getEventRegister().getEventList()){
            if(eventTitle.equalsIgnoreCase(ev.getTitle())){
                return true;
            }
        }
        return false;
    }
    
    
    public List calcPath(String eventTitle){
        Event event=findEvent(eventTitle);
        ArrayList <StandConnection> connections = new ArrayList<>(CalculateElectricalCable.cablePath(event.getStandRegister().getStandList()));
        return connections;
    }
    
    public double calcLength(String eventTitle){
        Event event=findEvent(eventTitle);
        ArrayList <StandConnection> connections = new ArrayList<>(CalculateElectricalCable.cablePath(event.getStandRegister().getStandList()));
        return CalculateElectricalCable.cableLength(connections);
    }
    
    
    
    public Event findEvent(String eventTitle){
        List<Event> eventList=exhibitionCentre.getEventRegister().getEventList();
        Event event=new Event();
        for(Event ev:eventList){
            if(eventTitle.equals(ev.getTitle())){
                event=ev;
                return event;
            }
        }
        return event;
    }
    
    
}
