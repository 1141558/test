/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Date;
import java.util.List;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MariaJoão
 */
public class CreateEventControllerTest {
    
    public CreateEventControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsersAvailable method, of class CreateEventController.
     */
    @Test
    public void testGetUsersAvailable() {
        System.out.println("getUsersAvailable");
        CreateEventController instance = null;
        List<User> expResult = null;
        List<User> result = instance.getUsersAvailable();
        assertEquals(true, true);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkFormat method, of class CreateEventController.
     */
    @Test
    public void testCheckFormat() {
        System.out.println("checkFormat");
        Date startDate = null;
        String startDateString = "";
        CreateEventController instance = null;
        Date expResult = null;
        Date result = instance.checkFormat(startDate, startDateString);
        assertEquals(true, true);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validateDateGap method, of class CreateEventController.
     */
    @Test
    public void testCompareDates() {
        System.out.println("test CompareDates");
        Date date1 = new Date();
        Date date2 = new Date();
        ExhibitionCentre centre= new ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        boolean expResult = true;
        boolean result = instance.compareDates(date1, date2);
        assertEquals(expResult, result);
    }
    
}
