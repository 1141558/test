/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.ListEventsController;
import lapr.project.model.Application;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class ListEventsUI {
   
    ListEventsController controller; 
    public ListEventsUI(ExhibitionCentre centre, String state){
        this.controller= new ListEventsController(centre);
        boolean answer=false;
        switch(state){
            case "SUBMITTED":
                controller.setState(ApplicationState.CREATED);
                break;
            case "REVIEW-PENDING":
                controller.setState(ApplicationState.IN_EVALUALTION);
                break;
        }
        String event;       
        int event_index = 0;
        System.out.println("");        
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("      LIST EVENT'S "+state.toUpperCase()+" APPLICATIONS       ");
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        
        while(!answer){

            int n=1;
            System.out.println("--------------------------");
            System.out.println("       YOUR EVENTS        ");
            System.out.println("--------------------------");

            for (Event e : controller.getEventsFromUser()) {
                System.out.println(n+" - "+e.getTitle());
                n++;
            }
            System.out.println("--------------------------");

            event=Utils.readLineFromConsole("PICK EVENT: ");
            try{
                event_index= Integer.parseInt(event);
                if(event_index>0 && event_index<=controller.getEventsFromUser().size()){
                    answer=true;
                }else{
                    Utils.printError("NUMBER OUT OF BOUNDARIES. PLEASE TRY AGAIN.");
                }
            }catch(NumberFormatException e){
                    Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                    answer=false;    
            }   

        }
        controller.eventPicked(event_index-1);
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("     "+state.toUpperCase()+" APPLICATIONS OF "+controller.getEvent().getTitle()+"      ");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (Application a : controller.getEvent().getEventApplicationByState(ApplicationState.CREATED)) {
            System.out.println(" - "+a.getDescription());
        }

    }
    
}
