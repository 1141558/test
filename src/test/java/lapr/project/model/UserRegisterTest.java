/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class UserRegisterTest {

    /**
     * Test of getUserList method, of class UserRegister.
     */
    @Test
    public void testGetUserList() {
        System.out.println("getUserList");
        UserRegister instance = new UserRegister();
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        instance.addUser(user1);
        List<User> expResult = new ArrayList<>();
        expResult.add(user1);
        List<User> result = instance.getUserList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserList method, of class UserRegister.
     */
    @Test
    public void testSetUserList() {
        System.out.println("setUserList");
        List<User> userList = new ArrayList<>();
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        userList.add(user1);
        UserRegister instance = new UserRegister();
        instance.setUserList(userList);
        assertEquals(userList, instance.getUserList());
    }

    /**
     * Test of addUser method, of class UserRegister.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        UserRegister instance = new UserRegister();
        instance.addUser(user1);
        assertEquals(user1, instance.getUserList().get(0));
    }

    /**
     * Test of userExists method, of class UserRegister.
     */
    @Test
    public void testUserExists() {
        System.out.println("userExists");
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User user2 = new User("Nomes Nomes", "emails@server.com", "user2", 0.4321);
        UserRegister instance = new UserRegister();
        instance.addUser(user1);
        boolean expResult = true;
        boolean result = instance.userExists(user1);
        assertEquals(expResult, result);
        assertEquals(false, instance.userExists(user2));
    }
    
    
       @Test
    public void testgetAvailablesUsersWithoutOrganisersTest() {
        System.out.println("userExists");
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User user2 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        UserRegister instance = new UserRegister();
        OrganiserRegister orgReg= new OrganiserRegister();
        Organiser org = new Organiser(user2);
        orgReg.addOrganiser(org);
        instance.addUser(user1);
       UserRegister userReg= new UserRegister();
       userReg.getAvailableUsersWithoutOrganisers(orgReg.getOrganiserList());
        
    }
}
