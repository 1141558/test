/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.UserRegistrationController;
import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.Utils;
import static lapr.project.controller.UserRegistrationController.*;

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
            controller.registerLog(username);
        } else {
            Utils.printError("User registration failed!");
        }

        new InitialMenuUI(exhibitionCentre);

    }

}
