/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.text.ParseException;
import java.util.ArrayList;
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
   
    DummyData data;
    
    ExhibitionCentre centre = new ExhibitionCentre();
    
    ExhibitionCentre exhibitionCentre;
    
    User user1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
    User user2 = new User("jose", "mail2@hotmail.com", "jo", 123 , Role.ATENDEE);
    User user3 = new User("sandra", "sandra@hotmail.com", "antunex", 123 , Role.ATENDEE);
    User user4 = new User("staffElement1_manuel", "mjdg111@hotmail.com", "garnel23", 123 , Role.ATENDEE);
    User user5 = new User("staffElment2_jose", "Jose@hotmail.com", "Jose1234", 123, Role.ATENDEE);
    User user6 = new User("O2", "mail2@hotmail.com", "orga2", 123, Role.ATENDEE);    
    User user7 = new User("Andre", "mailu3", "andr", 133 , Role.ATENDEE);
    User user8 = new User("Luisa", "Luisa@hotmail.com", "mar", 123, Role.EMPLOYEE);   
    User user9 = new User("Joaquim", "mailgdfgdgfdgu3", "jq", 133, Role.ATENDEE);
    User user10 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123, Role.ATENDEE);
    
    Organiser org1;
    Organiser org2;
    Organiser org3;
    
    Date data1, data2, data3, data4;
    
    OrganiserRegister organiserRegister4 = new OrganiserRegister();
    
    List<Organiser> organiserList4 = new ArrayList<>();
  
    StaffRegister staffRegister4 = new StaffRegister();
    
    List<StaffMember> staffMemberListEvent4 = new ArrayList<>();
    
    Application app = new Application();
    Application app2 = new Application();
    
    List<Application> appList = new ArrayList<>();
    
    ApplicationRegister appReg = new ApplicationRegister();
    
    Event event4;
    
    EventRegister eventRegister = new EventRegister();
    
    public EventRegister getEventRegister() {
        return eventRegister;
    }
    
    public void setEventRegsiter(EventRegister eventRegsiter) {
        this.eventRegister = eventRegsiter;
    }
    
    //*****************************************************************************************
    //************************Criar registo de utilizadores***********************************

    /**
     *
     */
    public UserRegister createUsers() {
        UserRegister userRegister = new UserRegister();
        
        List<User> usersCentre = new ArrayList<>();
        
        usersCentre.add(user1);
        usersCentre.add(user2);
        usersCentre.add(user3);
        usersCentre.add(user4);
        usersCentre.add(user5);
        usersCentre.add(user6);
    
        usersCentre.add(user7);
        usersCentre.add(user8);
        usersCentre.add(user9);       
        usersCentre.add(user10);
        
        userRegister.setUserList(usersCentre);
        
       
        return userRegister;

    }
    
    public EventTest() throws ParseException{
        data = new DummyData(centre);
        
        /*
        Event 4

        */

        org1 = new Organiser();
        org1.setOrganiser(user1);
        org2 = new Organiser();
        org2.setOrganiser(user2);


        organiserList4.add(org2);
        organiserList4.add(org1);

        organiserRegister4.setOrganiserList(organiserList4);

        StaffMember staff41 = new StaffMember();
        StaffMember staff42 = new StaffMember();

        staff41.setUser(user4);
        staff42.setUser(user5);
        staffMemberListEvent4.add(staff41);
        staffMemberListEvent4.add(staff42);

        staffRegister4.add(staffMemberListEvent4);

        this.event4 = new Event(organiserRegister4);

        this.event4.setTitle("EVENTO 4");
        event4.setEventState(EventState.CREATED);
        event4.addOrganiserRegister(organiserRegister4);
        event4.setStaffRegister(staffRegister4);
        event4.setDaysApplication(4);
        event4.setStartDate(data1);
        event4.setEndDate(data2);
        this.app.setDescription("APP 1");
        this.app2.setDescription("APP 2");
        this.app.setState(ApplicationState.ACCEPTED);
        this.app2.setState(ApplicationState.IN_EVALUALTION);
        
        event4.setApplicationRegister(appReg);
        
        eventRegister.addEvent(event4);        
        
        appList.add(app);
        appList.add(app2);
        
        appReg.setApplicationList(appList);
        
        UserRegister userRegister = new UserRegister();
        userRegister = createUsers();
        
       this.exhibitionCentre = new ExhibitionCentre(eventRegister, userRegister);
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
        Event instance = new Event("Evento teste", "Teste para evento 2", data.getDate1(), data.getDate2(), "", data.getOrganiserRegister());
        boolean expResult = false;
        boolean result = instance.equals(event);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Event.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals3");
        Event event = null;
        Event instance = new Event("Evento teste", "Teste para evento", data.getDate1(), data.getDate2(), "", data.getOrganiserRegister());
        boolean expResult = false;
        boolean result = instance.equals(event);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Event.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals4");
        Event event = new Event("Evento teste", "Teste para evento", data.getDate1(), data.getDate2(), "", data.getOrganiserRegister());
        Event instance = new Event("Evento teste", "Teste para evento", data.getDate2(), data.getDate2(), "", data.getOrganiserRegister());
        boolean expResult = false;
        boolean result = instance.equals(event);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Event.
     */
    @Test
    public void testEquals5() {
        System.out.println("equals5");
        Event event = new Event("Evento teste", "Teste para evento", data.getDate1(), data.getDate2(), "", data.getOrganiserRegister());
        Event instance = new Event("Evento teste2", "Teste para evento", data.getDate1(), data.getDate2(), "", data.getOrganiserRegister());
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

    /**
     * Test of getEndDate method, of class Event.
     */
    @Test
    public void testSetAndGetEndDate() {
        System.out.println("getEndDate");
        Event instance = new Event();
        Date expResult = new Date();
        Calendar calendar = Calendar.getInstance();
        expResult = calendar.getTime();
        instance.setEndDate(expResult);
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlace method, of class Event.
     */
    @Test
    public void testSetAndGetPlace() {
        System.out.println("getPlace");
        Event instance = new Event();
        String expResult = "Place One";
        instance.setPlace(expResult);
        String result = instance.getPlace();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrganisersRegister method, of class Event.
     */
    @Test
    public void testSetAndGetOrganisersRegister() {
        System.out.println("set get and OrganisersRegister");
        Event instance = new Event();
        OrganiserRegister expResult = organiserRegister4;
        instance.setOrganisersRegister(organiserRegister4);
        OrganiserRegister result = instance.getOrganisersRegister();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrganisersRegister method, of class Event.
     */
    @Test
    public void testSetOrganisersRegister() {
        System.out.println("setOrganisersRegister");
        OrganiserRegister organisersList = organiserRegister4;
        
        Event instance = new Event();
        instance.setOrganisersRegister(organisersList);
    }

    /**
     * Test of addOrganiserRegister method, of class Event.
     */
    @Test
    public void testAddOrganiserRegister() {
        System.out.println("addOrganiserRegister");
        OrganiserRegister organiserRegister = null;
        Event instance = new Event();
        instance.addOrganiserRegister(organiserRegister);
    }

    /**
     * Test of getEventManager method, of class Event.
     */
    @Test
    public void testGetEventManager() {
        System.out.println("getEventManager");
        Event instance = new Event();
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel2", 123, Role.ATENDEE);        
        EventManager expResult = new EventManager(user);
        instance.setEventManager(expResult);
        EventManager result = instance.getEventManager();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStaffRegister method, of class Event.
     */
    @Test
    public void testSetAndGetStaffRegister() {
        System.out.println("set and get StaffRegister");
        Event instance = new Event();
        StaffRegister expResult = staffRegister4;
        instance.setStaffRegister(staffRegister4);
        StaffRegister result = instance.getStaffRegister();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEventState method, of class Event.
     */
    @Test
    public void testSetAndGetEventState() {
        System.out.println("set and get EventState");
        Event instance = new Event();
        EventState expResult = EventState.CLOSE;
        instance.setEventState(EventState.CLOSE);
        EventState result = instance.getEventState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDaysApplication method, of class Event.
     */
    @Test
    public void testSetAndGetDaysApplication() {
        System.out.println("set and get DaysApplication");
        Event instance = new Event();
        instance.setDaysApplication(5);
        int expResult = 5;
        int result = instance.getDaysApplication();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Event.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Event instance = new Event();
        instance = data.getEventRegister().getEvent(0);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString2 method, of class Event.
     */
    @Test
    public void testToString2() {
        System.out.println("toString2");
        Event instance = new Event();
        instance = data.getEventRegister().getEvent(0);
        String expResult = instance.toString2();
        String result = instance.toString2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStandRegister method, of class Event.
     */
    @Test
    public void testGetStandRegister() {
        System.out.println("getStandRegister");
        Event instance = new Event();
        StandRegister expResult = null;
        StandRegister result = instance.getStandRegister();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStandRegister method, of class Event.
     */
    @Test
    public void testSetStandRegister() {
        System.out.println("setStandRegister");
        StandRegister standRegister = null;
        Event instance = new Event();
        instance.setStandRegister(standRegister);
    }

    /**
     * Test of getApplicationRegister method, of class Event.
     */
    @Test
    public void testSetAndGetApplicationRegister() {
        System.out.println("set get ApplicationRegister");
        Event instance = new Event();
        ApplicationRegister expResult = appReg;
        instance.setApplicationRegister(appReg);
        ApplicationRegister result = instance.getApplicationRegister();
        assertEquals(expResult, result);
    }

    /**
     * Test of createStaffMemberRegister method, of class Event.
     */
    @Test
    public void testCreateStaffMemberRegister() {
        System.out.println("createStaffMemberRegister");
        Event instance = new Event();
        StaffRegister expResult = new StaffRegister();
        StaffRegister result = instance.createStaffMemberRegister();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveStaffRegister method, of class Event.
     */
    @Test
    public void testSaveStaffRegister() {
        System.out.println("saveStaffRegister");
        Event instance = new Event();
        StaffRegister expResult = staffRegister4;
        instance.saveStaffRegister(staffRegister4);
        StaffRegister result = instance.getStaffRegister();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateEndApplications method, of class Event.
     */
    @Test
    public void testSetAndGetDateEndApplications() {
        System.out.println("set and get DateEndApplications");
        Event instance = new Event();
        Date expResult = null;
        Date dateEndApplications = null;
        instance.setDateEndApplications(dateEndApplications);
        Date result = instance.getDateEndApplications();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEventApplicationByState method, of class Event.
     */
    @Test
    public void testGetEventApplicationByState() {
        System.out.println("getEventApplicationByState");
        ApplicationState appState = ApplicationState.IN_EVALUALTION;
        Event instance = new Event();
        instance.setApplicationRegister(appReg);
        List<Application> expResult = new ArrayList<>();
        expResult.add(event4.getApplicationRegister().getApplicationList().get(1));
        List<Application> result = instance.getEventApplicationByState(appState);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEventApplicationByAcception method, of class Event.
     */
    @Test
    public void testGetEventApplicationByAcception() {
        System.out.println("getEventApplicationByAcception");
        Event instance = new Event();
        instance.setApplicationRegister(appReg);
        List<Application> expResult = new ArrayList<>();
        expResult.add(event4.getApplicationRegister().getApplicationList().get(0));
        List<Application> result = instance.getEventApplicationByAcception();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRooms method, of class Event.
     */
    @Test
    public void testSetAndGetRooms() {
        System.out.println("set and get Rooms");
        Event instance = new Event();        
        int expResult = 10;
        instance.setRooms(expResult);
        int result = instance.getRooms();
        assertEquals(expResult, result);;
    }
    
}
