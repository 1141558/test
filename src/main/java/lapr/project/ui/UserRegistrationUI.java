/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.UserRegistrationController;
import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.Utils;
//import static lapr.project.controller.UserRegistrationController.*;

/**
 *
 * @author JM
 */
public class UserRegistrationUI {

    private UserRegistrationController controller;

    /**
     * Constructor
     * @param exhibitionCentre Exhibition centre
     */
    public UserRegistrationUI(ExhibitionCentre exhibitionCentre) {
        this.controller = new UserRegistrationController(exhibitionCentre);

        String name;
        String email;
        String username;
        String passwordString;

        //Request user data
        UtilsUI.printLine("");
        UtilsUI.printLine((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        UtilsUI.printLine("        USER REGISTRATION        ");
        UtilsUI.printLine((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");

        name = Utils.readLineFromConsole("NAME: ");
        email = Utils.readLineFromConsole("EMAIL: ");
        username = Utils.readLineFromConsole("USERNAME: ");
        passwordString = Utils.readLineFromConsole("PASSWORD: ");

        while (!controller.isName(name)) {
            UtilsUI.printError("The name inserted is not valid!\nPlease try again.");
            name = Utils.readLineFromConsole("NAME: ");
        }

        while (!controller.isEmail(email)) {
            UtilsUI.printError("The email inserted is not valid!\nPlease try again.");
            email = Utils.readLineFromConsole("EMAIL: ");
        }

        while (!controller.isUsername(username)) {
            UtilsUI.printError("The username inserted is not valid!\nPlease try again.");
            username = Utils.readLineFromConsole("USERNAME: ");
        }

        while (!controller.isPassword(passwordString)) {
            UtilsUI.printError("The password inserted is not valid!\nPlease try again.");
            passwordString = Utils.readLineFromConsole("PASSWORD: ");
        }

        controller.setData(name, email, username, passwordString);

        if (controller.addUser()) {
            //confirma sucesso
            UtilsUI.printConfirmation("User registered!");
            controller.registerLog(username);
        } else {
            UtilsUI.printError("User registration failed!");
        }

        new InitialMenuUI(exhibitionCentre);

    }

}
