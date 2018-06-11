/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class UserTest {

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "Nome Nome";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Nome Nome";
        User instance = new User();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "email@server.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "email@server.com";
        User instance = new User();
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "user1";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "user1";
        User instance = new User();
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        double expResult = 0.1234;
        double result = instance.getPassword();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        double password = 0.1234;
        User instance = new User();
        instance.setPassword(password);
        assertEquals(password, instance.getPassword(), 0);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "User:{name=Nome Nome, email=email@server.com, username=user1, password=0.1234}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
