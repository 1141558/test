/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
 */
public class StartSubmissionPeriodControllerTest {
    private ExhibitionCentre centre;
    
    DummyData data;
    
    public StartSubmissionPeriodControllerTest() {
        data = new DummyData(centre);
    }

    /**
     * Test of findEventByOrganiserAndState method, of class StartSubmissionPeriodController.
     */
    @Test
    public void testFindEventByOrganiserAndState() {
        System.out.println("findEventByOrganiserAndState");
        User user = data.u1;
        StartSubmissionPeriodController instance = null;
        List<Event> expResult = null;
        List<Event> result = instance.findEventByOrganiserAndState(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of changeStateEventToSubmission method, of class StartSubmissionPeriodController.
     */
    @Test
    public void testChangeStateEventToSubmission() {
        System.out.println("changeStateEventToSubmission");
        int indice = 0;
        StartSubmissionPeriodController instance = null;
        boolean expResult = false;
        boolean result = instance.changeStateEventToSubmission(indice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
