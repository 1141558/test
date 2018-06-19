/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lapr.project.controller.DummyData;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class EventTest {
    
    private ExhibitionCentre centre = new ExhibitionCentre();
    DummyData data;
    
    public EventTest() throws ParseException {
        data = new DummyData(centre);
    }
    
    /**
     * Test of changeToReadyForApplication method, of class Event.
     */
    @Test
    public void testChangeToReadyForApplication() {
        System.out.println("changeToReadyForApplication");
        Event event = data.getEventRegister().getEvent(0);
        event.setEventState(EventState.CREATED);
        event.changeToReadyForApplication();
        EventState expResult = EventState.READY_FOR_APPLICATION;
        EventState result = event.getEventState();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of isCreated method, of class Event.
     */
    @Test
    public void testIsCreated() {
        System.out.println("isCreated");
        Event event = data.getEventRegister().getEvent(0);
        event.setEventState(EventState.CREATED);
        boolean expResult = true;
        boolean result = event.isCreated();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isCreated method, of class Event.
     */
    @Test
    public void testIsCreated2() {
        System.out.println("isCreated2");
        Event event = data.getEventRegister().getEvent(0);
        boolean expResult = false;
        boolean result = event.isCreated();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isReadyForApplication method, of class Event.
     */
    @Test
    public void testIsReadyForApplication() {
        System.out.println("isReadyForApplication");
        Event event = data.getEventRegister().getEvent(0);
        event.setEventState(EventState.READY_FOR_APPLICATION);
        boolean expResult = true;
        boolean result = event.isReadyForApplication();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isReadyForApplication method, of class Event.
     */
    @Test
    public void testIsReadyForApplication2() {
        System.out.println("isReadyForApplication2");
        Event event = data.getEventRegister().getEvent(0);
        event.setEventState(EventState.CREATED);
        boolean expResult = false;
        boolean result = event.isReadyForApplication();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isOpenApplication method, of class Event.
     */
    @Test
    public void testIsOpenApplication() {
        System.out.println("isOpenApplication");
        Event event = data.getEventRegister().getEvent(0);
        event.setEventState(EventState.OPEN_APPLICATION);
        boolean expResult = true;
        boolean result = event.isOpenApplication();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isOpenApplication method, of class Event.
     */
    @Test
    public void testIsOpenApplication2() {
        System.out.println("isOpenApplication2");
        Event event = data.getEventRegister().getEvent(0);
        boolean expResult = false;
        boolean result = event.isOpenApplication();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isInEvaluations method, of class Event.
     */
    @Test
    public void testIsInEvaluations() {
        System.out.println("isInEvaluations");
        Event event = data.getEventRegister().getEvent(0);
        event.setEventState(EventState.IN_EVALUATIONS);
        boolean expResult = true;
        boolean result = event.isInEvaluations();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isInEvaluations method, of class Event.
     */
    @Test
    public void testIsInEvaluations2() {
        System.out.println("isInEvaluations2");
        Event event = data.getEventRegister().getEvent(0);
        boolean expResult = false;
        boolean result = event.isInEvaluations();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isReadyForOpening method, of class Event.
     */
    @Test
    public void testIsReadyForOpening() {
        System.out.println("isReadyForOpening");
        Event event = data.getEventRegister().getEvent(0);
        event.setEventState(EventState.READY_FOR_OPENING);
        boolean expResult = true;
        boolean result = event.isReadyForOpening();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isReadyForOpening method, of class Event.
     */
    @Test
    public void testIsReadyForOpening2() {
        System.out.println("isReadyForOpening2");
        Event event = data.getEventRegister().getEvent(0);
        boolean expResult = false;
        boolean result = event.isReadyForOpening();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isOpen method, of class Event.
     */
    @Test
    public void testIsOpen() {
        System.out.println("isOpen");
        Event event = data.getEventRegister().getEvent(0);
        event.setEventState(EventState.OPEN);
        boolean expResult = true;
        boolean result = event.isOpen();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isOpen method, of class Event.
     */
    @Test
    public void testIsOpen2() {
        System.out.println("isOpen2");
        Event event = data.getEventRegister().getEvent(0);
        boolean expResult = false;
        boolean result = event.isOpen();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isClose method, of class Event.
     */
    @Test
    public void testIsClose() {
        System.out.println("isClose");
        Event event = data.getEventRegister().getEvent(0);
        event.setEventState(EventState.CLOSE);
        boolean expResult = true;
        boolean result = event.isClose();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isClose method, of class Event.
     */
    @Test
    public void testIsClose2() {
        System.out.println("isClose2");
        Event event = data.getEventRegister().getEvent(0);
        boolean expResult = false;
        boolean result = event.isClose();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Event.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Event event = data.getEventRegister().getEvent(1);
        Event instance = data.getEventRegister().getEvent(0);
        int expResult = -1;
        int result;
        result = instance.compareTo(event);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Event.
     */
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo2");
        Event event = data.getEventRegister().getEvent(0);
        Event instance = data.getEventRegister().getEvent(1);
        int expResult = 1;
        int result;
        result = instance.compareTo(event);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Event.
     */
    @Test
    public void testCompareTo3() {
        System.out.println("compareTo3");
        Event event = data.getEventRegister().getEvent(1);
        Event instance = data.getEventRegister().getEvent(1);
        int expResult = 0;
        int result;
        result = instance.compareTo(event);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Event.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Event event = data.getEventRegister().getEvent(0);
        Event instance = data.getEventRegister().getEvent(0);
        boolean expResult = true;
        boolean result = instance.equals(event);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Event.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        Event event = new Event("Evento teste", "Teste para evento", data.getDate1(), data.getDate2(), "", data.getOrganiserRegister());
        Event instance = data.getEventRegister().getEvent(1);
        boolean expResult = false;
        boolean result = instance.equals(event);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetAndGetDescription() {
        System.out.println("Set Get Decription");
        String description = "Description";
        Event instance = new Event();
        instance.setDescription(description);
        String expResult = "Description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Event.
     */
    @Test
    public void testGetAndSetTitle() {
        System.out.println("set and getTitle");
        String Title = "Titulo";
        Event instance = new Event();
        instance.setTitle(Title);
        String expResult = "Titulo";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class Event.
     */
    @Test
    public void testSetAndGetStartDate() {
        System.out.println("set and getStartDate");
        Event instance = new Event();
        Date expResult = new Date();
        Calendar calendar = Calendar.getInstance();
        expResult = calendar.getTime();
        instance.setStartDate(expResult);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of getEndDate method, of class Event.
//     */
//    @Test
//    public void testGetEndDate() {
//        System.out.println("getEndDate");
//        Event instance = new Event();
//        Date expResult = null;
//        Date result = instance.getEndDate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEndDate method, of class Event.
//     */
//    @Test
//    public void testSetEndDate() {
//        System.out.println("setEndDate");
//        Date endDate = null;
//        Event instance = new Event();
//        instance.setEndDate(endDate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPlace method, of class Event.
//     */
//    @Test
//    public void testGetPlace() {
//        System.out.println("getPlace");
//        Event instance = new Event();
//        String expResult = "";
//        String result = instance.getPlace();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPlace method, of class Event.
//     */
//    @Test
//    public void testSetPlace() {
//        System.out.println("setPlace");
//        String place = "";
//        Event instance = new Event();
//        instance.setPlace(place);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getOrganisersRegister method, of class Event.
//     */
//    @Test
//    public void testGetOrganisersRegister() {
//        System.out.println("getOrganisersRegister");
//        Event instance = new Event();
//        OrganiserRegister expResult = null;
//        OrganiserRegister result = instance.getOrganisersRegister();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setOrganisersRegister method, of class Event.
//     */
//    @Test
//    public void testSetOrganisersRegister() {
//        System.out.println("setOrganisersRegister");
//        OrganiserRegister organisersList = null;
//        Event instance = new Event();
//        instance.setOrganisersRegister(organisersList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getOrganiserRegister method, of class Event.
//     */
//    @Test
//    public void testGetOrganiserRegister() {
//        System.out.println("getOrganiserRegister");
//        Event instance = new Event();
//        OrganiserRegister expResult = null;
//        OrganiserRegister result = instance.getOrganiserRegister();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addOrganiserRegister method, of class Event.
//     */
//    @Test
//    public void testAddOrganiserRegister() {
//        System.out.println("addOrganiserRegister");
//        OrganiserRegister organiserRegister = null;
//        Event instance = new Event();
//        instance.addOrganiserRegister(organiserRegister);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEventState method, of class Event.
//     */
//    @Test
//    public void testSetEventState() {
//        System.out.println("setEventState");
//        EventState eventState = null;
//        Event instance = new Event();
//        instance.setEventState(eventState);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEventManager method, of class Event.
//     */
//    @Test
//    public void testGetEventManager() {
//        System.out.println("getEventManager");
//        Event instance = new Event();
//        EventManager expResult = null;
//        EventManager result = instance.getEventManager();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEventManager method, of class Event.
//     */
//    @Test
//    public void testSetEventManager() {
//        System.out.println("setEventManager");
//        EventManager eventManager = null;
//        Event instance = new Event();
//        instance.setEventManager(eventManager);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getStaffRegister method, of class Event.
//     */
//    @Test
//    public void testGetStaffRegister() {
//        System.out.println("getStaffRegister");
//        Event instance = new Event();
//        StaffRegister expResult = null;
//        StaffRegister result = instance.getStaffRegister();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStaffRegister method, of class Event.
//     */
//    @Test
//    public void testSetStaffRegister() {
//        System.out.println("setStaffRegister");
//        StaffRegister staffRegister = null;
//        Event instance = new Event();
//        instance.setStaffRegister(staffRegister);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEventState method, of class Event.
//     */
//    @Test
//    public void testGetEventState() {
//        System.out.println("getEventState");
//        Event instance = new Event();
//        EventState expResult = null;
//        EventState result = instance.getEventState();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDaysApplication method, of class Event.
//     */
//    @Test
//    public void testGetDaysApplication() {
//        System.out.println("getDaysApplication");
//        Event instance = new Event();
//        int expResult = 0;
//        int result = instance.getDaysApplication();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDaysApplication method, of class Event.
//     */
//    @Test
//    public void testSetDaysApplication() {
//        System.out.println("setDaysApplication");
//        int daysApplication = 0;
//        Event instance = new Event();
//        instance.setDaysApplication(daysApplication);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Event.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Event instance = new Event();
//        instance = data.getEventRegister().getEvent(0);
//        String expResult = instance.toString();
//        String result = instance.toString();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of toString2 method, of class Event.
//     */
//    @Test
//    public void testToString2() {
//        System.out.println("toString2");
//        Event instance = new Event();
//        instance = data.getEventRegister().getEvent(0);
//        String expResult = instance.toString();
//        String result = instance.toString();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getStandRegister method, of class Event.
//     */
//    @Test
//    public void testGetStandRegister() {
//        System.out.println("getStandRegister");
//        Event instance = new Event();
//        StandRegister expResult = null;
//        StandRegister result = instance.getStandRegister();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStandRegister method, of class Event.
//     */
//    @Test
//    public void testSetStandRegister() {
//        System.out.println("setStandRegister");
//        StandRegister standRegister = null;
//        Event instance = new Event();
//        instance.setStandRegister(standRegister);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getApplicationRegister method, of class Event.
//     */
//    @Test
//    public void testGetApplicationRegister() {
//        System.out.println("getApplicationRegister");
//        Event instance = new Event();
//        ApplicationRegister expResult = null;
//        ApplicationRegister result = instance.getApplicationRegister();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setApplicationRegister method, of class Event.
//     */
//    @Test
//    public void testSetApplicationRegister() {
//        System.out.println("setApplicationRegister");
//        ApplicationRegister applicationRegister = null;
//        Event instance = new Event();
//        instance.setApplicationRegister(applicationRegister);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createStaffMemberRegister method, of class Event.
//     */
//    @Test
//    public void testCreateStaffMemberRegister() {
//        System.out.println("createStaffMemberRegister");
//        Event instance = new Event();
//        StaffRegister expResult = null;
//        StaffRegister result = instance.createStaffMemberRegister();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of saveStaffRegister method, of class Event.
//     */
//    @Test
//    public void testSaveStaffRegister() {
//        System.out.println("saveStaffRegister");
//        StaffRegister staffRegister = null;
//        Event instance = new Event();
//        instance.saveStaffRegister(staffRegister);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDateEndApplications method, of class Event.
//     */
//    @Test
//    public void testGetDateEndApplications() {
//        System.out.println("getDateEndApplications");
//        Event instance = new Event();
//        Date expResult = null;
//        Date result = instance.getDateEndApplications();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDateEndApplications method, of class Event.
//     */
//    @Test
//    public void testSetDateEndApplications() {
//        System.out.println("setDateEndApplications");
//        Date dateEndApplications = null;
//        Event instance = new Event();
//        instance.setDateEndApplications(dateEndApplications);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEventApplicationByState method, of class Event.
//     */
//    @Test
//    public void testGetEventApplicationByState() {
//        System.out.println("getEventApplicationByState");
//        ApplicationState accepted = null;
//        Event instance = new Event();
//        List<Application> expResult = null;
//        List<Application> result = instance.getEventApplicationByState(accepted);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEventApplicationByAcception method, of class Event.
//     */
//    @Test
//    public void testGetEventApplicationByAcception() {
//        System.out.println("getEventApplicationByAcception");
//        Event instance = new Event();
//        List<Application> expResult = null;
//        List<Application> result = instance.getEventApplicationByAcception();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRooms method, of class Event.
//     */
//    @Test
//    public void testGetRooms() {
//        System.out.println("getRooms");
//        Event instance = new Event();
//        int expResult = 0;
//        int result = instance.getRooms();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setRooms method, of class Event.
//     */
//    @Test
//    public void testSetRooms() {
//        System.out.println("setRooms");
//        int rooms = 0;
//        Event instance = new Event();
//        instance.setRooms(rooms);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
