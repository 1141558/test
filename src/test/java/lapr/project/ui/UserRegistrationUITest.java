/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class UserRegistrationUITest {

    /**
     * Test of isName method, of class UserRegistrationUI.
     */
    @Test
    public void testIsName() {
        System.out.println("isName");
        String name = "Nome Nome";
        String notName = "123 José";
        UserRegistrationUI instance = new UserRegistrationUI();
        boolean expResult = true;
        boolean result = instance.isName(name);
        boolean result2 = instance.isName(notName);
        assertEquals(expResult, result);
        assertNotEquals(expResult, result2);
    }

    /**
     * Test of isEmail method, of class UserRegistrationUI.
     */
    @Test
    public void testIsEmail() {
        System.out.println("isEmail");
        String email = "emailtest@gmail.com";
        String notEmail = "emailtest@gmail.com@hotmail.com";
        UserRegistrationUI instance = new UserRegistrationUI();
        boolean expResult = true;
        boolean result = instance.isEmail(email);
        boolean result2 = instance.isEmail(notEmail);
        assertEquals(expResult, result);
        assertNotEquals(expResult, result2);
    }

    /**
     * Test of isUsername method, of class UserRegistrationUI.
     */
    @Test
    public void testIsUsername() {
        System.out.println("isUsername");
        String username = "user123";
        String notUsername = "";
        UserRegistrationUI instance = new UserRegistrationUI();
        boolean expResult = true;
        boolean result = instance.isUsername(username);
        boolean result2 = instance.isUsername(notUsername);
        assertEquals(expResult, result);
        assertNotEquals(expResult, result2);
    }

    /**
     * Test of isPassword method, of class UserRegistrationUI.
     */
    @Test
    public void testIsPassword() {
        System.out.println("isPassword");
        String passString = "12345678";
        String notPassString = "12345abc";
        UserRegistrationUI instance = new UserRegistrationUI();
        boolean expResult = true;
        boolean result = instance.isPassword(passString);
        boolean result2 = instance.isPassword(notPassString);
        assertEquals(expResult, result);
        assertNotEquals(expResult, result2);
    }
}
