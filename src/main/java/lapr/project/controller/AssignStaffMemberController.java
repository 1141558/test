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

    private ExhibitionCentre exhibitionCentre;
    private EventRegister eventRegister;
    private OrganiserRegister organiserRegister;
    private StaffRegister staffRegister;
    private Organiser organiser;
    
    DummyData dummy = new DummyData();
    

    public List<Event> assignStaffMemberToEvent(Organiser m_organiser) {
        Organiser organiserValidated = m_organiser;
        boolean checked = false;
        List<Organiser> organisersList = new ArrayList<>();
        List<Event> organiserValidatedList = new ArrayList<Event>();
//List<Event> organiserValidatedList = (List<Event>) dummy.eventRegsiter;

        eventRegister = exhibitionCentre.getEventRegister();
        eventRegister = dummy.getEventRegsiter();
        
        List<Event> eventList = eventRegister.getEventList();
        for (Event item1 : eventList) {
            organisersList = item1.getOrganiserRegister().getOrganiserList();
            for (Organiser item : organisersList) {
                if (item.getOrganiser() == organiserValidated.getOrganiser()) {
                    checked = true;

                }
            }
            if (checked) {
                organiserValidatedList.add(item1);
            }

        }
        return organiserValidatedList;
    }

    

    
    
}


