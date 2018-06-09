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
       
        int pos =0;
        
        List<User> usersExhibitionCentreCopy = new ArrayList<>();
        usersExhibitionCentre = exhibitionCentre.getUserRegister().getUserList();
        usersExhibitionCentreCopy = Utils.getCopia(exhibitionCentre.getUserRegister().getUserList());
       
       List<Organiser> organiserByEvent = eventSelected.getOrganisersRegister().getOrganiserList();
        System.out.println("organiser by event" + organiserByEvent);
        
    //   List<Organiser> organiserFromFilteringUserListAndOrganiserList = new ArrayList<>();
            
       for(Organiser organiser: organiserByEvent){
           for(User user: usersExhibitionCentre){
         
               if(user.getName().equals(organiser.getOrganiser().getName())){
                   
                   usersExhibitionCentreCopy.remove(pos);
                   pos++;
           }
       }
     
    }
        System.out.println("usersfiltrados 1"+usersExhibitionCentreCopy );
      return usersExhibitionCentreCopy;
}
}
