/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.controller.DummyData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class EventTest {
    
    private ExhibitionCentre centre = new ExhibitionCentre();
    DummyData data;
    
    public EventTest() {
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

//    /**
//     * Test of toString method, of class Event.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Event instance = new Event();
//        String expResult = "";
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
//        String expResult = "";
//        String result = instance.toString2();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of compareTo method, of class Event.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Event event = data.getEventRegister().getEvent(0);
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
        Event event = data.getEventRegister().getEvent(0);
        Event instance = data.getEventRegister().getEvent(1);
        boolean expResult = false;
        boolean result = instance.equals(event);
        assertEquals(expResult, result);
    }  
    
}
