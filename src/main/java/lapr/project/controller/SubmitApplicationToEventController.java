/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class SubmitApplicationToEventController {

    Application application;  
    ExhibitionCentre centre;
    Event event;
    List<Event> events= new  ArrayList<>();
    public SubmitApplicationToEventController(ExhibitionCentre centre) {
        this.application= new Application();
        this.centre=centre;
    }

    public void setData(String description, int nInvites, List<String> keywords, double area) {
        List<Keyword> list= new ArrayList<>();
        this.application.setDescription(description);
        this.application.setNumberInvites(nInvites);
        for (String keyword : keywords) {
            Keyword k= new Keyword();
            k.setValue(keyword);
        }
        this.application.setKeywordList(list);
        this.application.setState(ApplicationState.CREATED);
        this.application.setAccepted(false);
        
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

    public void registerApplication() {
        this.event.getApplicationRegister().addApplication(this.application);
    }

    public void setEvent(int n) {
        this.event= getEventsReadyForApplications().get(n-1);
    }

    public void registerLog() {
        Utils.writeLog(this.centre.getUserOnline().getUsername()+" submited application '"+this.application.getDescription()+"' to event '"+this.event.getTitle()+"';");
    }
    
}
