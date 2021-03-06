/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegister;
import lapr.project.model.ApplicationState;
import lapr.project.model.Decision;
import lapr.project.model.Event;
import lapr.project.model.EventManager;
import lapr.project.model.EventRegister;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Review;
import lapr.project.model.Role;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.Stand;
import lapr.project.model.StandRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import lapr.project.model.Workshop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class UpdateOrWithdrawApplicationControllerTest {
    
    //Application_________________________________
    ApplicationRegister appRegister = new ApplicationRegister();
    ApplicationRegister appRegister2 = new ApplicationRegister();
        
    Application app1 = new Application("description");
    Application app2 = new Application("description2");

    Keyword keyword1 = new Keyword("keyword1");
    Keyword keyword2 = new Keyword("keyword2");
    Keyword keyword3 = new Keyword("keyword3");
    Keyword keyword4 = new Keyword("keyword4");

    List<Keyword> listKey = new ArrayList<>();

    List<Boolean> wantToAttend = new ArrayList<>();

    List<String> necessaryEquip = new ArrayList<>();

    Workshop w1 = new Workshop("description w1", 3, necessaryEquip);        
    Workshop w2 = new Workshop("description w2", 2, necessaryEquip);

    List<Workshop> listWo = new ArrayList<>();

    User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
    StaffMember staff = new StaffMember(user);
    Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
    Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
    Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
    List<Review> listRev = new ArrayList<>();

    List<Application> listApp = new ArrayList<>();
    List<Application> listApp2 = new ArrayList<>();
    
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
    StaffRegister staffRegister = new StaffRegister();
    
    List<StaffMember> staffMemberListEvent4 = new ArrayList<>(); 
    List<StaffMember> staffMemberListEvent = new ArrayList<>(); 
    
    StandRegister standRegister = new StandRegister();
    StandRegister standRegister2 = new StandRegister();
    Stand s1 = new Stand("STAND1", 2.50);
    Stand s2 = new Stand("STAND2", 2.10);
        
    EventManager em;
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
    
    public UpdateOrWithdrawApplicationControllerTest() throws ParseException{
        
        try {
            data1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse("2018-06-12");
        } catch (ParseException ex) {
            Logger.getLogger(DummyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            data2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse("2018-06-17");
        } catch (ParseException ex) {
            Logger.getLogger(DummyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            data3 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse("2018-06-19");
        } catch (ParseException ex) {
            Logger.getLogger(DummyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            data4 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse("2018-06-22");
        } catch (ParseException ex) {
            Logger.getLogger(DummyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        Event 4
        */
        
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        app1.setKeywordList(listKey);
        app2.setKeywordList(listKey);
        
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        
        app1.setNumberInvites(2);
        app1.setPhoneNumber(916547688);
        app1.setBoothArea(5);
        app1.setState(ApplicationState.ACCEPTED);
        app1.setNameOfCompany("nameOfCompany");
        app1.setDescription("description");
        app1.setUserThatSubmited(user1);
        app1.setListReview(listRev);
        
        app2.setNumberInvites(4);
        app2.setPhoneNumber(916547688);
        app2.setBoothArea(7);
        app2.setState(ApplicationState.CREATED);
        app2.setNameOfCompany("nameOfCompany 2");
        app2.setDescription("description 2");
        app2.setUserThatSubmited(user);
        app2.setListReview(listRev);
        
        w1.setWantToAttend(wantToAttend);
        w2.setWantToAttend(wantToAttend); 
        
        listWo.add(w2);
        listWo.add(w1);
        app1.setWorkshopList(listWo);
        app2.setWorkshopList(listWo);
        
        listApp.add(app1);
        listApp.add(app2);        
        listApp2.add(app1);
        
        appRegister.setApplicationList(listApp);
        appRegister2.setApplicationList(listApp2);

        org1 = new Organiser();
        org1.setOrganiser(user1);
        org2 = new Organiser();
        org2.setOrganiser(user2);


        organiserList4.add(org2);
        organiserList4.add(org1);

        organiserRegister4.setOrganiserList(organiserList4);

        StaffMember staff41 = new StaffMember();
        StaffMember staff42 = new StaffMember();
        StaffMember staff43 = new StaffMember(user3);

        staff41.setUser(user4);
        staff42.setUser(user5);
        staffMemberListEvent4.add(staff41);
        staffMemberListEvent4.add(staff42);
        staffMemberListEvent.add(staff43);

        staffRegister4.add(staffMemberListEvent4);
        staffRegister.add(staffMemberListEvent);
        
        em = new EventManager(user10);
        
        standRegister.addStand(s1);
        standRegister2.addStand(s2);

        this.event4 = new Event("EVENTO 4", "description event4", data1, data2, "place", organiserRegister4);

        this.event4.setTitle("EVENTO 4");
        event4.setEventState(EventState.CREATED);
        event4.addOrganiserRegister(organiserRegister4);
        event4.setStaffRegister(staffRegister4);
        event4.setDaysApplication(4);
        event4.setStartDate(data1);
        event4.setEndDate(data2);        
        event4.setApplicationRegister(appRegister);
        event4.setDateEndApplications(data4);
        event4.setDaysApplication(4);
        event4.setStandRegister(standRegister);
        event4.setDateEndApplications(data2);
        event4.setEventManager(em);
        
        eventRegister.addEvent(event4);       
        
        UserRegister userRegister = new UserRegister();
        userRegister = createUsers();
        
        this.exhibitionCentre = new ExhibitionCentre(eventRegister, userRegister);
        this.exhibitionCentre.setUserOnline(user1);
    }

    /**
     * Test of getUserApplications method, of class UpdateOrWithdrawApplicationController.
     */
    @Test
    public void testGetUserApplications() {
        System.out.println("getUserApplications");
        UpdateOrWithdrawApplicationController instance = new UpdateOrWithdrawApplicationController(exhibitionCentre);
        List<Application> expResult = new ArrayList<>();
        expResult.add(app1);
        List<Application> result = instance.getUserApplications();
        assertEquals(expResult, result);
    }

    /**
     * Test of getA method, of class UpdateOrWithdrawApplicationController.
     */
    @Test
    public void testsetAndGetA() {
        System.out.println("set/getA");
        UpdateOrWithdrawApplicationController instance = new UpdateOrWithdrawApplicationController(exhibitionCentre);
        instance.setA(0);
        Application result = instance.getA();
        assertEquals(app1, result);
    }

    /**
     * Test of validatePhoneNumber method, of class UpdateOrWithdrawApplicationController.
     */
    @Test
    public void testValidatePhoneNumberTrue() {
        System.out.println("validatePhoneNumberTrue");
        int phoneNumber = 9276543;
        UpdateOrWithdrawApplicationController instance = new UpdateOrWithdrawApplicationController(exhibitionCentre);
        boolean expResult = false;
        boolean result = instance.validatePhoneNumber(phoneNumber);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validatePhoneNumber method, of class UpdateOrWithdrawApplicationController.
     */
    @Test
    public void testValidatePhoneNumberFalse() {
        System.out.println("validatePhoneNumberFalse");
        int phoneNumber = 912765435;
        UpdateOrWithdrawApplicationController instance = new UpdateOrWithdrawApplicationController(exhibitionCentre);
        boolean expResult = true;
        boolean result = instance.validatePhoneNumber(phoneNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of setData method, of class UpdateOrWithdrawApplicationController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        String description = "";
        int nInvites = 6;
        double area =  6.5;
        String companyName = "New Name";
        int phoneNumber = 254545435;
        int vatNumber = 500667565;
        UpdateOrWithdrawApplicationController instance = new UpdateOrWithdrawApplicationController(exhibitionCentre);
        instance.setData(description, nInvites, listKey, area, companyName, phoneNumber, vatNumber, listWo);
    }
    
}
