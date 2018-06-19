/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.ExhibitionCentre;
import lapr.project.model.PasswordEncryption;
import lapr.project.model.User;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class UserRegistrationControllerTest {

    /**
     * Test of setData method, of class UserRegistrationController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        User user = new User("nome completo", "email@server.com", "user", PasswordEncryption.encryptPassword("12345678"));
        String name = "nome completo";
        String email = "email@server.com";
        String username = "user";
        String password = "12345678";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        instance.setData(name, email, username, password);
        assertEquals(user.getName(), instance.getUser().getName());
        assertEquals(user.getEmail(), instance.getUser().getEmail());
        assertEquals(user.getUsername(), instance.getUser().getUsername());
        assertEquals(user.getPassword(), instance.getUser().getPassword(), 0.0);

    }

    /**
     * Test of addUser method, of class UserRegistrationController.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String name = "nome completo";
        String email = "email@server.com";
        String username = "user";
        String password = "12345678";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        instance.setData(name, email, username, password);
        instance.addUser();
        assertTrue(centre.getUserRegister().getUserList().contains(instance.getUser()));

    }

    /**
     * Test of isName method, of class UserRegistrationUI.
     */
    @Test
    public void testIsName() {
        System.out.println("isName");
        String name = "Nome Nome";
        String notName = "123 José";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
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
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
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
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
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
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = true;
        boolean result = instance.isPassword(passString);
        boolean result2 = instance.isPassword(notPassString);
        assertEquals(expResult, result);
        assertNotEquals(expResult, result2);
    }

    /**
     * Test of getUser method, of class UserRegistrationController.
     */
    @org.junit.Test
    public void testGetUser() {
        System.out.println("getUser");
        User user = new User("nome completo", "email@server.com", "user", PasswordEncryption.encryptPassword("12345678"));
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        instance.setData("nome completo", "email@server.com", "user", "12345678");
        User expResult = user;
        User result = instance.getUser();
        assertEquals(expResult, result);
    }

}
