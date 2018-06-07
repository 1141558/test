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
import lapr.project.model.StaffRegister;
import lapr.project.model.User;

/**
 *
 * @author Garnel
 */
public class AssignStaffMemberController {
    
    private ExhibitionCentre exhibitionCentre = new ExhibitionCentre();
    private EventRegister eventRegister = new EventRegister();
    private OrganiserRegister organiserRegister;
    private StaffRegister staffRegister;
    private Organiser organiser;
    private User user;
    
    DummyData dummy = new DummyData();
    
    List<Event> organiserValidatedList = new ArrayList<>();
    
    public AssignStaffMemberController(ExhibitionCentre centre) {
        this.exhibitionCentre = centre;
    }
    
    public List<Event> assignStaffMemberToEvent(User m_user) {
        User organiserValidated = m_user;
 
        boolean checked = false;
        List<Organiser> organisersList = new ArrayList<>();
        List<Event> organiserValidatedList = (new ArrayList<>());
        eventRegister = dummy.getEventRegsiter();
        System.out.println("Passou1");
        System.out.println(eventRegister);
        List<Event> eventList = eventRegister.getEventList();
        for (Event item1 : eventList) {
            organisersList = item1.getOrganiserRegister().getOrganiserList();
            for (Organiser item : organisersList) {
                if (item.getOrganiser() == organiserValidated) {
                    checked = true;
                    
                }
            }
            if (checked) {
                organiserValidatedList.add(item1);
                System.out.println("Lista1");
                System.out.println(organiserValidatedList);
            }
            checked = false;
        }
        System.out.println(organiserValidatedList);
        return organiserValidatedList;
        
    }
    
}
