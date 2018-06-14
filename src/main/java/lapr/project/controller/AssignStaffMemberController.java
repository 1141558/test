/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import lapr.project.utils.Utils;

/**
 *
 * @author Garnel
 */
public class AssignStaffMemberController {
    
    private ExhibitionCentre exhibitionCentre;
    private EventRegister eventRegister;
 
    private StaffRegister staffRegister;
    private UserRegister usersRegister;
    private Event event;
    
    DummyData dummy;
   
    
    public AssignStaffMemberController(ExhibitionCentre centre) {
        this.exhibitionCentre = centre;
        this.dummy = new DummyData(centre);
    }
    
    
    public List<Event> getEventsListByOrganiser() {
        
        User organiserValidated = exhibitionCentre.getUserOnline();
        eventRegister = exhibitionCentre.getEventRegister();
        List<Event> eventList = eventRegister.getEventListByOrganiser(organiserValidated);
        
        return eventList;
        
    }
    
    public void selectEvent(Event eventSelected) {
        this.event = eventSelected;
        this.staffRegister = this.event.createStaffMemberRegister();
    }

    public List<User> filterUserRegisterByNoOrganiserEventSelected() {
        
        List<User> usersExhibitionCentreCopyWithoutOrganisers = new ArrayList<>();
        usersRegister = exhibitionCentre.getUserRegister();
        usersExhibitionCentreCopyWithoutOrganisers = usersRegister.getAvailableUsersWithoutOrganisers(event.getOrganisersRegister().getOrganiserList());
        return usersExhibitionCentreCopyWithoutOrganisers;
    }
    
    public List<User> getAvailableUsers() {
        
        List<User> filterUserRegisterByNoOrganiserEventSelectedCopy = Utils.getCopia(filterUserRegisterByNoOrganiserEventSelected());
        
        List<User> filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff = new ArrayList<>();
        
        List<User> organiserWithoutOrganisersAndEventStaffList = usersRegister.getAvailableUsersWithoutStaffMember(event.getStaffRegister().getStaffList(), filterUserRegisterByNoOrganiserEventSelectedCopy);
        
        return organiserWithoutOrganisersAndEventStaffList;
    }
    
    public StaffMember assignUser(List<User> availableUserToAssignToEvent, int userPos) {
        
        StaffMember staffMember = new StaffMember();
        User user = availableUserToAssignToEvent.get(userPos - 1);
        staffMember.setStaff(user);
        return staffMember;
    }
    
    public boolean addStaffMemberToEvent(StaffMember staffMember) {
        
        return staffRegister.addStaffMember(staffMember);
        
    }

    
    public List<StaffMember> getStaffMemberList() {
        return staffRegister.getStaffList();
    }
    
    public void saveStaffMemberList() {
        event.saveStaffRegister(staffRegister);
    }
    

}
