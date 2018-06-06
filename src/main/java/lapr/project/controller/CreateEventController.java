/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class CreateEventController {

    private ExhibitionCentre exhibitionCentre;
    private Event event;
    private OrganiserRegister or;
    
    public CreateEventController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre=exhibitionCentre;
        this.or= new OrganiserRegister();
    }
        
    public List<User> getUsersAvailable(){
        return this.exhibitionCentre.getUserRegister().getUserList();
    }
    
    public Date checkFormat(Date startDate, String startDateString) {
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

            try {
                startDate = format.parse(startDateString);
                return startDate;
                
            } catch (ParseException ex) {
                
                return null;
                
            }    
    }

    public boolean compareDates(Date date1, Date date2) {

        int hours = 0, minutes=0, seconds=0;
        Calendar calendar = Calendar.getInstance();
        calendar.set( Calendar.HOUR_OF_DAY, hours );
        calendar.set( Calendar.MINUTE, minutes );
        calendar.set( Calendar.SECOND, seconds );

        date1= calendar.getTime();
        if(date1.after(date2)){
            return false;
        }
        return true;   
    }

    public Organiser createOrganiser(List<User> usersAvailable, int userPos) {
        Organiser o= new Organiser();
        User u= usersAvailable.get(userPos-1);
        o.setOrganiser(u);
        return o;
    }

    public boolean addOrganiser(Organiser o) {
        return this.or.addOrganiser(o);
    }

    public void setData(String title, String description, Date startDate, Date endDate, String place) {
        Event e= new Event();
        e.setDescription(description);
        e.setTitle(title);
        e.setEndDate(endDate);
        e.setStartDate(startDate);
        e.setOrganisersList(this.or);
        e.setPlace(place);

        this.event=e;
    }

    public void registerEvent() {
        this.exhibitionCentre.getEventRegister().registerEvent(this.event);
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @return the or
     */
    public OrganiserRegister getOr() {
        return or;
    }

    /**
     * @param or the or to set
     */
    public void setOr(OrganiserRegister or) {
        this.or = or;
    }


    
}
