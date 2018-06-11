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
import lapr.project.utils.Utils;

/**
 *
 * @author Garnel
 */
public class AssignStaffMemberController {
    
    private ExhibitionCentre exhibitionCentre;
    private EventRegister eventRegister;
    private OrganiserRegister organiserRegister;
    private StaffRegister staffRegister;
    private Organiser organiser;
    private User user;
    private Event event;
    
    DummyData dummy;
    List<User> usersExhibitionCentre = new ArrayList<>();
    
    public AssignStaffMemberController(ExhibitionCentre centre) {
        this.exhibitionCentre = centre;
        this.dummy = new DummyData(centre);
        
    }
    
    AssignStaffMemberController(ExhibitionCentre exhibitionCentre, User userOnline) {
        this.exhibitionCentre = exhibitionCentre;
        this.user = userOnline;
    }
    
    public List<Event> getEventsListByOrganiser() {
        
        User organiserValidated = exhibitionCentre.getUserOnline();
        List<Organiser> organisersList = new ArrayList<>();
        
        eventRegister = exhibitionCentre.getEventRegister();
        
        List<Event> eventList = eventRegister.getEventListByOrganiser(organiserValidated);
        
        return eventList;
        
    }
    
    public void selectEvent(Event eventSelected) {
        this.event = eventSelected;
    }
    
    public List<User> showUsersExhibitionCentre() {
        
        usersExhibitionCentre = exhibitionCentre.getUserRegister().getUserList();
        
        return usersExhibitionCentre;
        
    }
    
    public List<User> filterUserRegisterByNoOrganiserEventSelected(Event eventSelected, User userOnline) {
        
        List<User> usersExhibitionCentreCopyWithoutOrganisers = new ArrayList<>();
        usersExhibitionCentre = exhibitionCentre.getUserRegister().getUserList();
        usersExhibitionCentreCopyWithoutOrganisers = Utils.getCopia(exhibitionCentre.getUserRegister().getUserList());
        List<Organiser> organiserByEvent = eventSelected.getOrganisersRegister().getOrganiserList();
        List<User> usersToRemove = new ArrayList<>();
        
        for (Organiser organiser : organiserByEvent) {
            
            for (User user : usersExhibitionCentreCopyWithoutOrganisers) {
                if (user.equals(organiser.getOrganiser())) {
                    usersToRemove.add(user);
                    
                }
                
            }
            
        }
        
        usersExhibitionCentreCopyWithoutOrganisers.removeAll(usersToRemove);
        
        return usersExhibitionCentreCopyWithoutOrganisers;
    }
    
    public List<User> getAvailableUsers(Event eventSelected, User userOnline) {
        
        List<User> filterUserRegisterByNoOrganiserEventSelectedCopy = Utils.getCopia(filterUserRegisterByNoOrganiserEventSelected(eventSelected, userOnline));
        List<User> filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff = new ArrayList<>();
        
        List<StaffMember> eventStaffList = eventSelected.getStaffRegister().getStaffList();
        
        for (StaffMember staffMember : eventStaffList) {
            
            for (User user : filterUserRegisterByNoOrganiserEventSelectedCopy) {
                
                if (user.equals(staffMember.getStaff())) {
                    
                    filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff.add(user);
                    
                }
                
            }
        }
        
        filterUserRegisterByNoOrganiserEventSelectedCopy.removeAll(filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff);
        
        return filterUserRegisterByNoOrganiserEventSelectedCopy;
    }
    
    public StaffMember assignUser(List<User> availableUserToAssignToEvent, Event eventSelected, int userPos) {
        StaffMember staffMember = new StaffMember();
        StaffMember staffMemberToCopy = new StaffMember();
        User user = availableUserToAssignToEvent.get(userPos - 1);
        
        List<StaffMember> staffMemberList = eventSelected.getStaffRegister().getStaffList();
        List<StaffMember> staffMemberListCopy = copy(eventSelected.getStaffRegister().getStaffList());
        
        for (StaffMember staffMember1 : staffMemberList) {
            if (staffMember1.getStaff().getName() != user.getName()) {
                
                staffMemberToCopy.setStaff(user);
                staffMemberListCopy.add(staffMemberToCopy);
            } else {
                System.out.println("Erro: Utilizador já foi atribuido à lista de staff");
            }
        }
        
        return staffMember;
    }
    
    public boolean addStaffMemberToEvent(StaffMember o, Event eventSelected) {
        return eventSelected.getStaffRegister().getStaffList().add(o);
    }
    
    private List<StaffMember> copy(List<StaffMember> staffList) {
        StaffMember staffMemberCopy = new StaffMember();
        List<StaffMember> staffMembers = new ArrayList<>();
        for (StaffMember staffMember : staffList) {
            staffMemberCopy = staffMember;
            staffMembers.add(staffMemberCopy);
        }
        return staffMembers;
    }
    
}
