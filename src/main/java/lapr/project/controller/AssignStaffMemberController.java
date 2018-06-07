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
    private EventRegister eventRegister =  new EventRegister();
    private OrganiserRegister organiserRegister;
    private StaffRegister staffRegister;
    private Organiser organiser;
    
    DummyData dummy = new DummyData();
    
List<Event> organiserValidatedList = new ArrayList<>();

    public List<Event> assignStaffMemberToEvent(Organiser m_organiser) {
        Organiser organiserValidated = m_organiser;
       
        boolean checked = false;
        List<Organiser> organisersList = new ArrayList<>();
        //List<Event> organiserValidatedList = new ArrayList<Event>();
List<Event> organiserValidatedList = (new ArrayList<>());

       eventRegister = exhibitionCentre.getEventRegister();
       // eventRegister = dummy.getEventRegsiter();
        System.out.println(eventRegister);
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
                 System.out.println(item1);
              System.out.println(organiserValidatedList);  
            }
checked = false;
        }
         System.out.println(organiserValidatedList);
        return organiserValidatedList;
    
     
    }

    

    
    
}


