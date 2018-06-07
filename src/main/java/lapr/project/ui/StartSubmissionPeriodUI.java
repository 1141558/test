/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;
import lapr.project.controller.DummyData;
import lapr.project.controller.StartSubmissionPeriodController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author André Silva
 */
public class StartSubmissionPeriodUI {
    
    StartSubmissionPeriodController controller;
    int n = 1;
    
    public StartSubmissionPeriodUI(ExhibitionCentre exhibitionCentre){
        DummyData data = new DummyData(exhibitionCentre);
        String event_selected_string=""; 
        int event_selected=0;
        boolean right=false;
        this.controller = new StartSubmissionPeriodController(exhibitionCentre);
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("           START EVENT'S APPLICATION SUBMISSION PERIOD           ");
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        while(!right){
        System.out.println("--------------------------");
        System.out.println("          EVENTS          ");
        System.out.println("--------------------------");
        System.out.println("EVENTS OF "+exhibitionCentre.getUserOnline().getName());
        
        
        for (Event event : controller.findEventByOrganiserAndState(exhibitionCentre.getUserOnline())) {
            System.out.println(n + " - "+event.toString2());
            n++;
        }
                
        System.out.println("--------------------------");
        event_selected_string=Utils.readLineFromConsole("PICK EVENNT: ");

        try{
            event_selected= Integer.parseInt(event_selected_string);
            if(event_selected>n || event_selected<1){
             //printError("NUMBER OUT OF BOUNDARIES. PLEASE TRY AGAIN.");

            }
        }catch(NumberFormatException e){{
            
        }
        }
    }
    
    
}
}
