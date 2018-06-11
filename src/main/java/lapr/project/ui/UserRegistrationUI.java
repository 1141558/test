/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.UserRegistrationController;
import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.Utils;

/**
 *
 * @author JM
 */
public class UserRegistrationUI {

    private UserRegistrationController controller;

    /**
     * Empty constructor for test purposes
     */
    public UserRegistrationUI() {
        ExhibitionCentre testCentre = new ExhibitionCentre();
    }

    /**
     * Constructor
     * @param exhibitionCentre Exhibition centre
     */
    public UserRegistrationUI(ExhibitionCentre exhibitionCentre) {
        this.controller = new UserRegistrationController(exhibitionCentre);

        String name = "";
        String email = "";
        String username = "";
        String passwordString = new String();

        //Request user data
        System.out.println("");
        System.out.println((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        System.out.println("        USER REGISTRATION        ");
        System.out.println((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");

        name = Utils.readLineFromConsole("NAME: ");
        email = Utils.readLineFromConsole("EMAIL: ");
        username = Utils.readLineFromConsole("USERNAME: ");
        passwordString = Utils.readLineFromConsole("PASSWORD: ");

        while (!isName(name)) {
            Utils.printError("The name inserted is not valid!\nPlease try again.");
            name = Utils.readLineFromConsole("NAME: ");
        }

        while (!isEmail(email)) {
            Utils.printError("The email inserted is not valid!\nPlease try again.");
            email = Utils.readLineFromConsole("EMAIL: ");
        }

        while (!isUsername(username)) {
            Utils.printError("The username inserted is not valid!\nPlease try again.");
            username = Utils.readLineFromConsole("USERNAME: ");
        }

        while (!isPassword(passwordString)) {
            Utils.printError("The password inserted is not valid!\nPlease try again.");
            passwordString = Utils.readLineFromConsole("PASSWORD: ");
        }

        controller.setData(name, email, username, passwordString);

        if (controller.addUser()) {
            //confirma sucesso
            Utils.printConfirmation("User registered!");
        } else {
            Utils.printError("User registration failed!");
        }

        new LoginUI(exhibitionCentre);

    }

    /**
     * Method to verify if the String name is valid (only letters and spaces)
     *
     * @param name String to verify
     * @return boolean value defining the string as valid or not
     */
    public boolean isName(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to verify if the String email is valid (one "@", valid email and
     * server)
     *
     * @param email String with the email adress to verify
     * @return boolean value defining the string as valid or not
     */
    public boolean isEmail(String email) {
        if (!email.contains("@")) {
            return false;
        }

        String[] emailSplit = email.split("@");
        if (emailSplit.length != 2) {
            return false;
        }

        if (!emailSplit[1].contains(".")) {
            return false;
        }

        if (emailSplit[0].equals("")) {
            return false;
        }

        return true;
    }

    /**
     * Method to verify if the String username is valid (not empty)
     *
     * @param username string to verify
     * @return boolean value defining the string as valid or not
     */
    public boolean isUsername(String username) {

        if (username.equals("")) {
            return false;
        }

        return true;
    }

    /**
     * Method to verify if the String password is valid (only digits and >=8)
     *
     * @param passString string with the inserted password
     * @return boolean value defining the password as valid or not
     */
    public boolean isPassword(String passString) {
        int n = 0;
        char[] chars = passString.toCharArray();
        for (char c : chars) {
            n++;
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        if (n != 8) {
            return false;
        }
        return true;
    }
}
