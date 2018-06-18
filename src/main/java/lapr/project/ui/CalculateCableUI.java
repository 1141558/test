/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.CalculateCableController;
import lapr.project.controller.UserRegistrationController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.Utils;
import static lapr.project.controller.CalculateCableController.*;
import lapr.project.model.CalculateElectricalCable;
import lapr.project.model.StandConnection;

/**
 *
 * @author JM
 */
public class CalculateCableUI {
    
    
    
    private CalculateCableController controller;

    
    public CalculateCableUI(ExhibitionCentre exhibitionCentre){
        this.controller = new CalculateCableController(exhibitionCentre);
        String selection="";
        
        //Request selection of event
        System.out.println("");
        System.out.println((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");
        System.out.println("        Electrical Cable Calculation        ");
        System.out.println((char) 27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + (char) 27 + "[0m");

        //Apresentar eventos
        System.out.println("EVENTS:");
        List<Event> events=controller.getEventList();
        for(Event ev:events){
            System.out.println(ev.getTitle());
        }
        
        //Selecctionar evento
        selection = Utils.readLineFromConsole("EVENT TITLE: ");
        
      //        while (!exhibitionCentre.getEventRegister().getEventList().iterator().toString().contains(selection)){
        while (!controller.eventExists(selection)) {
            Utils.printError("EVENT NOT FOUND!\nPLEASE TRY AGAIN");
            System.out.println("EVENTS:");
            for (Event ev : events) {
                System.out.println(ev.getTitle());
            }

            //Seleccionar evento
            selection = Utils.readLineFromConsole("EVENT TITLE: ");
        }
        
        
        //Evento seleccionado e encontrado
        //Calcular
        ArrayList<StandConnection> tree = new ArrayList<>(controller.calcPath(selection));
        double length = controller.calcLength(selection);
        
        for(StandConnection connect : tree){
            System.out.println(connect.toString());
        }
        System.out.println("Total: " + length + " meters");
        
        
        
        new InitialMenuUI(exhibitionCentre);
        
    }
    
    
}
