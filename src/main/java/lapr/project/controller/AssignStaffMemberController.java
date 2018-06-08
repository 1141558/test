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
    private User user;
    private Event event;

    DummyData dummy;

   // List<Event> organiserValidatedList = new ArrayList<>();

    public AssignStaffMemberController(ExhibitionCentre centre) {
        this.exhibitionCentre = centre;
        this.dummy = new DummyData(centre);
    }

    public List<Event> getEventsListByOrganiser() {

        User organiserValidated = exhibitionCentre.getUserOnline();
        List<Organiser> organisersList = new ArrayList<>();
//        List<Event> organiserValidatedList = new ArrayList<>();
//eventRegister = dummy.getEventRegister();
        eventRegister = exhibitionCentre.getEventRegister();

        List<Event> eventList = eventRegister.getEventListByOrganiser(organiserValidated);

        return eventList;
    }

    public void selectEvent(Event eventSelected) {
        this.event = eventSelected;
    }
}
