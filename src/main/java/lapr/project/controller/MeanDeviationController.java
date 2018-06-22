/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.utils.StaffRating;

/**
 *
 * @author JM
 */
public class MeanDeviationController {
    
    private ExhibitionCentre exhibitionCentre;
    private StaffRating rating;
    
    public MeanDeviationController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre = exhibitionCentre;
        this.rating = new StaffRating(exhibitionCentre);
    }
    
    public List<User> getStaffList() {
        return exhibitionCentre.getAllStaffMembers();
    }
    
    public double calcMeanRating(String username) {
        User user = findUser(username);
        
        return user != null ? rating.meanRating(user) : 0;
    }
    
    public double calcMeanDev(String username, String eventTitle) {
        User user = findUser(username);
        Event event = findEvent(eventTitle);
        
        return rating.meanDeviation(user, event);
    }
    
    public Event findEvent(String title) {
        for (Event e : exhibitionCentre.getEventRegister().getEventList()) {
            if (e.getTitle().equals(title)) {
                return e;
            }
        }
        return null;
    }
    
    public User findUser(String username) {
        for (User u : exhibitionCentre.getUserRegister().getUserList()) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    
    
    public boolean staffExists(String username) {
        if (getStaffList().stream().anyMatch((u) -> (u.getUsername().equals(username)))) {
            return true;
        }
        return false;
    }
    
    public boolean eventExists(String title) {
        if (getEvents().stream().anyMatch((u) -> (u.getTitle().equals(title)))) {
            return true;
        }
        return false;
    }
    
    public List<Event> getEvents(){
        return exhibitionCentre.getEventRegister().getEventList();
    }
    
}
