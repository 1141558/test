/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MariaJoão
 */
public class Event implements Comparable<Event>, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static final int CORDAYS_APPLICATION_OMISSION = 0;
    
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String place;
    private OrganiserRegister organiserRegister;
    private StaffRegister staffRegister;
    private EventState eventState;
    private EventManager eventManager;
    private StandRegister standRegister;
    private ApplicationRegister applicationRegister;
    
    private int daysApplication = CORDAYS_APPLICATION_OMISSION;
    
    public Event(String title, String description, Date startDate, Date endDate, String place, OrganiserRegister organiserRegister) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.organiserRegister = organiserRegister;
        this.eventState = EventState.CREATED;
    }
    
    public Event(OrganiserRegister organiserRegister) {
        this.organiserRegister = new OrganiserRegister();
      
    }
    
    public Event() {
        this.organiserRegister = new OrganiserRegister();
        this.staffRegister=new StaffRegister();
    }
    
    public boolean changeToReadyForApplication() {
        if ((!staffRegister.isEmpty()) && (!organiserRegister.isEmpty()) && daysApplication != 0 && eventState == EventState.CREATED) {
            this.eventState = EventState.READY_FOR_APPLICATION;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isCreated() {
        return this.eventState == EventState.CLOSE;
    }
    
    public boolean isReadyForApplication() {
        return this.eventState == EventState.READY_FOR_APPLICATION;
    }
    
    public boolean isOpenApplication() {
        return this.eventState == EventState.OPEN_APPLICATION;
    }
    
    public boolean isReadyForOpening() {
        return this.eventState == EventState.READY_FOR_OPENING;
    }
    
    public boolean isInEvaluations() {
        return this.eventState == EventState.IN_EVALUATIONS;
    }
    
    public boolean isOpen() {
        return this.eventState == EventState.OPEN;
    }
    
    public boolean isClose() {
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
    public OrganiserRegister getOrganisersRegister() {
        return organiserRegister;
    }
    
    /**
     * @param organisersList the organisersList to set
     */
    public void setOrganisersRegister(OrganiserRegister organisersList) {
        this.organiserRegister = organisersList;
    }
    
    public OrganiserRegister getOrganiserRegister() {
        return this.getOrganisersRegister();
    }
    
    public void addOrganiserRegister(OrganiserRegister organiserRegister) {
        this.organiserRegister = organiserRegister;
        
    }
    
    public void setEventState(EventState eventState) {
        this.eventState = eventState;
    }
    
    /**
     * @return the eventManager
     */
    public EventManager getEventManager() {
        return eventManager;
    }
    
    /**
     * @param eventManager the eventManager to set
     */
    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }
    
    /**
     * @return the staffRegister
     */
    public StaffRegister getStaffRegister() {
        return staffRegister;
    }
    
    public void setStaffRegister(StaffRegister staffRegister) {
        this.staffRegister = staffRegister;
    }
    
    public EventState getEventState() {
        return eventState;
    }
    
    public int getDaysApplication() {
        return daysApplication;
    }
    
    public void setDaysApplication(int daysApplication) {
        this.daysApplication = daysApplication;
    }
    
    @Override
    public String toString() {
        return "Event{" + "title = " + title + ", description = " + description + ", startDate=" + startDate + ", endDate= " + endDate + ", place= " + place + ", organiserRegister=" + organiserRegister + ", staffRegister= " + staffRegister + "\n eventState=" + eventState + "\n daysApplication=" + daysApplication + "}\n";
        
    }
    
    public String toString2() {
        return String.format("Titulo: %s", this.title);
    }
    
    @Override
    public int compareTo(Event o) {
        return this.startDate.compareTo(o.startDate);
    }
    
    public boolean equals(Event e) {
        if (e == null) {
            return false;
        }
        if (this.getClass() != e.getClass()) {
            return false;
        }
        
        if (!Objects.equals(this.title, e.title)) {
            return false;
        }
        if (!Objects.equals(this.description, e.description)) {
            return false;
        }
        if (!Objects.equals(this.place, e.place)) {
            return false;
        }
        if (!Objects.equals(this.endDate, e.endDate)) {
            return false;
        }
        if (!Objects.equals(this.startDate, e.startDate)) {
            return false;
        }
        return Objects.equals(this.daysApplication, this.daysApplication);
    }
    
    /**
     * @return the standRegister
     */
    public StandRegister getStandRegister() {
        return standRegister;
    }
    
    /**
     * @param standRegister the standRegister to set
     */
    public void setStandRegister(StandRegister standRegister) {
        this.standRegister = standRegister;
    }
    
    /**
     * @return the applicationRegister
     */
    public ApplicationRegister getApplicationRegister() {
        return applicationRegister;
    }
    
    /**
     * @param applicationRegister the applicationRegister to set
     */
    public void setApplicationRegister(ApplicationRegister applicationRegister) {
        this.applicationRegister = applicationRegister;
    }
    
    public StaffRegister createStaffMemberRegister() {
        return new StaffRegister();
    }

    public void saveStaffRegister(StaffRegister staffRegister) {
        this.staffRegister.getStaffList().addAll(staffRegister.getStaffList());
    }
    
}
