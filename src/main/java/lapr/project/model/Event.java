/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author MariaJoão
 */



public class Event {
    
    private static final int CORDAYS_APPLICATION_OMISSION = 0;

    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String place;
    private OrganiserRegister organiserRegister;
    private StaffRegister staffRegister;
    private EventState eventState;
    private int daysApplication = CORDAYS_APPLICATION_OMISSION;
    
    public Event(String Title, String description, Date startDate, Date endDate, String place, OrganiserRegister organisersList) {
        this.title = Title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.organiserRegister= organisersList;
        this.eventState = EventState.CREATED;        
    }

    public Event() {
       this.organiserRegister = new OrganiserRegister(); 
    }
    
    public boolean changeToReadyForApplication(){
        if((!staffRegister.isEmpty()) && (!organiserRegister.isEmpty()) && daysApplication != 0 && eventState == EventState.CREATED){
            this.eventState = EventState.READY_FOR_APPLICATION;
            return true;
        }else
            return false;
    }
       

    public boolean isCreated(){
        return this.eventState == EventState.CLOSE;
    }  

    public boolean isReadyForApplication(){
       return this.eventState == EventState.READY_FOR_APPLICATION;
    }   

    public boolean isOpenApplication(){
         return this.eventState == EventState.OPEN_APPLICATION;
    }
    public boolean isReadyForOpening(){
        return this.eventState == EventState.READY_FOR_OPENING;
    }    

    public boolean isOpen(){
        return this.eventState == EventState.OPEN;
    }

    
    public boolean isClose(){
        return this.eventState == EventState.CLOSE;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.title = Title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the organisersList
     */
    public OrganiserRegister getOrganisersList() {
        return organiserRegister;
    }

    /**
     * @param organisersList the organisersList to set
     */
    public void setOrganisersList(OrganiserRegister organisersList) {
        this.organiserRegister = organisersList;
    }

    public OrganiserRegister getOrganiserRegister() {
       return this.getOrganisersList();
    }

    public void addOrganiserRegister(OrganiserRegister organiserRegister) {
        this.organiserRegister = organiserRegister;
        
    }
 
 
    
}
