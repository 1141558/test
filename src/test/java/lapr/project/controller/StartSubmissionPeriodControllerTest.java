/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class StartSubmissionPeriodControllerTest {
    private ExhibitionCentre centre = new ExhibitionCentre();
    
    DummyData data;
    
    List<Event> result;
    List<Event> expResult;
    StartSubmissionPeriodController controller;
    
    public StartSubmissionPeriodControllerTest() {
        data = new DummyData(centre);
        expResult = new ArrayList<>();
        result = new ArrayList<>();
        this.controller = new StartSubmissionPeriodController(centre);
    }

    /**
     * Test of findEventByOrganiserAndState method, of class StartSubmissionPeriodController.
     */
//    @Test
//    public void testFindEventByOrganiserAndState() {
//        System.out.println("findEventByOrganiserAndState");
//        User user = data.user3;
//        expResult.add(data.event2);
//        result = controller.findEventByOrganiserAndState(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
    
    /**
     * Test of findEventByOrganiserAndState method, of class StartSubmissionPeriodController.
     */
    @Test
    public void testFindEventByOrganiserAndState2() {
        System.out.println("findEventByOrganiserAndState2");
        User user = data.user5;
        List<Event> expResult2 = new ArrayList<>();
        result = controller.findEventByOrganiserAndState(user);
        assertEquals(expResult2, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of changeStateEventToSubmission method, of class StartSubmissionPeriodController.
     */
    @Test
    public void testChangeStateEventToSubmission() {
        System.out.println("changeStateEventToSubmission");
        User user = data.user3;
        result = controller.findEventByOrganiserAndState(user);
        boolean expResult = true;
        int indice = 0;
        boolean result2 = controller.changeStateEventToSubmission(indice);
        assertEquals(expResult, result2);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of changeStateEventToSubmission method, of class StartSubmissionPeriodController.
     */
    @Test
    public void testChangeStateEventCreated() {
        System.out.println("changeStateEventToReady");
       
    }
}

   

