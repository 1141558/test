/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.List;
import lapr.project.controller.MeanRatingController;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;

/**
 *
 * @author JM
 */
public class MeanRatingUI {
    
    private MeanRatingController controller;
    
    public MeanRatingUI (ExhibitionCentre exhibitionCentre){
        this.controller = new MeanRatingController(exhibitionCentre);
        String selection = "";

        //Request selection of employee
        UtilsUI.printLine("");
        UtilsUI.printLine((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        UtilsUI.printLine("        Mean Rating Calculation        ");
        UtilsUI.printLine((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");

        //Apresentar employees
        UtilsUI.printLine("STAFF MEMBERS:");
        List<User> employees = controller.getStaffList();
        for (User u : employees) {
            UtilsUI.printLine("username: "+u.getUsername()+" -- Name: "+u.getName());
        }

        //Seleccionar employee
        UtilsUI.printLine("SELECT STAFF MEMBER USERNAME ('Q' TO QUIT)");
        selection = UtilsUI.readLineFromConsole("USERNAME: ");

        while (!controller.staffExists(selection) && (!"Q".equalsIgnoreCase(selection))) {
            UtilsUI.printError("STAFF MEMBER NOT FOUND!\nPLEASE TRY AGAIN");
            UtilsUI.printLine("STAFF MEMBER:");
            for (User u : employees) {
            UtilsUI.printLine("username: "+u.getUsername()+" -- Name: "+u.getName());
            }

            //Seleccionar employee
            UtilsUI.printLine("SELECT STAFF MEMBER USERNAME ('Q' TO QUIT)");
            selection = UtilsUI.readLineFromConsole("USERNAME: ");
        }
        
        
        if (!"Q".equalsIgnoreCase(selection)) {

            //Employee seleccionado e encontrado
            //Calcular
            double mean = controller.calcMeanRating(selection);
            UtilsUI.printLine("STAFF MEMBER: " + controller.findUser(selection).getName() + String.format("  -->  MEAN RATING: %.2f",mean));
        }
        
        
        new MainMenu(exhibitionCentre); 
        
    }
    
    
}
