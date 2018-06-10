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
        System.out.println("Controller" + exhibitionCentre + "antes dummy data");
        this.dummy = new DummyData(centre);
        System.out.println("Controller" + dummy.toString() + "depois dummy data");
    }

    AssignStaffMemberController(ExhibitionCentre exhibitionCentre, User userOnline) {
      this.exhibitionCentre = exhibitionCentre;
      this.user =userOnline;
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
        showUsersExhibitionCentre();
        int pos = 0;
        
        List<User> usersExhibitionCentreCopyWithoutOrganisers = new ArrayList<>();
        usersExhibitionCentre = exhibitionCentre.getUserRegister().getUserList();
        usersExhibitionCentreCopyWithoutOrganisers = Utils.getCopia(exhibitionCentre.getUserRegister().getUserList());
        
        List<Organiser> organiserByEvent = eventSelected.getOrganisersRegister().getOrganiserList();
        //System.out.println("organiser by event" + organiserByEvent);
        
        //   List<Organiser> organiserFromFilteringUserListAndOrganiserList = new ArrayList<>();
        for (Organiser organiser : organiserByEvent) {
            for (User user : usersExhibitionCentre) {
                
                if (user.getName().equals(organiser.getOrganiser().getName())) {
                    
                    usersExhibitionCentreCopyWithoutOrganisers.remove(pos);
                    pos++;
                }
            }
            
        }
        System.out.println("usersfiltrados 1" + usersExhibitionCentreCopyWithoutOrganisers);
        return usersExhibitionCentreCopyWithoutOrganisers;
    }
    
    public List<User> showAvailableUsers(Event eventSelected, User userOnline) {
        
        int pos2 = 0;
        List<User> filterUserRegisterByNoOrganiserEventSelectedCopy = Utils.getCopia(filterUserRegisterByNoOrganiserEventSelected(eventSelected, userOnline));
        List<User> filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff = Utils.getCopia(filterUserRegisterByNoOrganiserEventSelected(eventSelected, userOnline));
        //  System.out.println("lista antes do filtro do staff do vento" + filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff);
        List<StaffMember> eventStaffList = eventSelected.getStaffRegister().getStaffList();
        
        System.out.println("event staff list" + eventStaffList);
        
        System.out.println("staff com um filtro" + filterUserRegisterByNoOrganiserEventSelectedCopy);
        
        //System.out.println("staff com um filtro" + filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff);
        // System.out.println("filterUserRegisterByNoOrganiserEventSelectedCopy" + filterUserRegisterByNoOrganiserEventSelectedCopy);
        for (StaffMember staffMember : eventStaffList) {
            for (User user : filterUserRegisterByNoOrganiserEventSelectedCopy) {
                // System.out.println("filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaffRegister" + eventStaffList);
                
                if (user.getName().equals(staffMember.getStaff().getName())) {
                    System.out.println("element user: " + user + "\n");
                    System.out.println("element user2: " + staffMember + "\n");
                    filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff.remove(pos2);//não entendo.......
                    pos2++;
                }
            }
        }
        System.out.println("staff com um filtro" + filterUserRegisterByNoOrganiserEventSelectedCopy);
        System.out.println("staff com dois filtros" + filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff);
        return filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff;
    }
    
}
