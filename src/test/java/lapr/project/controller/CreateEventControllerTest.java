/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MariaJoão
 */
public class CreateEventControllerTest {

    
  
    /**
     * Test of getUsersAvailable method, of class CreateEventController.
     */
    @Test
    public void testGetUsersAvailable() {
        System.out.println("getUsersAvailable");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        User u1= new User();
        u1.setUsername("maria");        
        User u2= new User();
        u2.setUsername("tiago");
        centre.getUserRegister().addUser(u1);
        centre.getUserRegister().addUser(u2);
        List<User> expResult = new ArrayList<>();
        expResult.add(u1);
        expResult.add(u2);
        List<User> result = instance.getUsersAvailable();
        assertEquals(result, expResult);
    }

    /**
     * Test of checkFormat method, of class CreateEventController.
     */
    @Test
    public void testCheckFormat() {
        System.out.println("checkFormat");
        Date startDate = new Date();        
        String startDateString = "2018-07-07";
        ExhibitionCentre centre= new ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        Date expResult= new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        calendar.set( Calendar.MILLISECOND, 0 );

        calendar.set( Calendar.DAY_OF_MONTH, 7 );
        calendar.set( Calendar.YEAR, 2018 );
        //6 beacuse it starts at zero
        calendar.set( Calendar.MONTH, 6 );
        expResult=calendar.getTime();
        
        Date result = instance.checkFormat(startDate, startDateString);
        assertEquals(result, expResult);
    }

    /**
     * Test of validateDateGap method, of class CreateEventController.
     */
    @Test
    public void testCompareDates() {
        System.out.println("test CompareDates");
        Date date1 = new Date();
        Date date2 = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        date1= calendar.getTime();
        calendar.set( Calendar.HOUR_OF_DAY, 2 );
        date2= calendar.getTime();

        
        ExhibitionCentre centre= new ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        boolean expResult = true;
        boolean result = instance.compareDates(date1, date2);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of createOrganiser method, of class CreateEventController.
     */
    @Test
    public void testCreateOrganiser() {
        System.out.println("createOrganiser");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        
        int userPos=3;
        
        User u1= new User();
        u1.setUsername("user1");
        User u2= new User();
        u2.setUsername("user2");
        User u3= new User();
        u3.setUsername("user3");
        
        Organiser expResult= new Organiser();
        expResult.setOrganiser(u3);
        
        List<User> usersAvailable = new ArrayList<>();
        usersAvailable.add(u1);
        usersAvailable.add(u2);
        usersAvailable.add(u3);
        
        Organiser result = instance.createOrganiser(usersAvailable, userPos);
        assertEquals(expResult, result);
    }

    /**
     * Test of addOrganiser method, of class CreateEventController.
     */
    @Test
    public void testAddOrganiser() {
        System.out.println("addOrganiser");
            
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        User u1= new User();
        u1.setUsername("user1");
        Organiser o = new Organiser(); 
        o.setOrganiser(u1);
        boolean expResult = true;
        boolean result = instance.addOrganiser(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of setData method, of class CreateEventController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        Event expResult= new Event();
        String title = "title";
        String description = "desc";
        String place = "place";
        expResult.setDescription(description);
        expResult.setTitle(title);
        expResult.setPlace(place);
        expResult.setOrganisersList(new OrganiserRegister());
        instance.setData(title, description, null, null, place);
        Event result= instance.getEvent();
        boolean result2 = result.equals(expResult);
        boolean expResult2 = true;      
        assertEquals(result2, expResult2);

    }

    /**
     * Test of registerEvent method, of class CreateEventController.
     */
    @Test
    public void testRegisterEvent() {
        System.out.println("registerEvent");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        
        Event e1= new Event();
        String title = "title";
        String description = "desc";
        String place = "place";
        e1.setDescription(description);
        e1.setTitle(title);
        e1.setPlace(place);
        instance.setEvent(e1);
        
        instance.registerEvent();
        
        boolean result= centre.getEventRegister().exists(e1);
        boolean expResult= true;

        assertEquals(expResult, result);

    }

    /**
     * Test of getEvent method, of class CreateEventController.
     */
    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        
        Event expResult = new Event();
        expResult.setTitle("event1");
        instance.setEvent(expResult);
        
        Event result = instance.getEvent();
        
        assertEquals(expResult, result);

    }

    /**
     * Test of setEvent method, of class CreateEventController.
     */
    @Test
    public void testSetEvent() {
        System.out.println("setEvent");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        
        Event expResult = new Event();
        expResult.setTitle("event1");
        instance.setEvent(expResult);
        
        Event result = instance.getEvent();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getOr method, of class CreateEventController.
     */
    @Test
    public void testGetOr() {
        System.out.println("getOr");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        OrganiserRegister expResult= new OrganiserRegister();
        Organiser o= new Organiser();
        User u1= new User();
        u1.setName("name");
        o.setOrganiser(u1);
        expResult.addOrganiser(o);        
        instance.setOr(expResult);
        OrganiserRegister result = instance.getOr();
        assertEquals(expResult, result);

    }

    /**
     * Test of setOr method, of class CreateEventController.
     */
    @Test
    public void testSetOr() {
        System.out.println("setOr");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        OrganiserRegister expResult= new OrganiserRegister();
        Organiser o= new Organiser();
        User u1= new User();
        u1.setName("name");
        o.setOrganiser(u1);
        expResult.addOrganiser(o);  
        instance.setOr(expResult);
        OrganiserRegister result = instance.getOr();
        assertEquals(expResult, result);
    }
    
}
