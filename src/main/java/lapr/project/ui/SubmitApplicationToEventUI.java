/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.SubmitApplicationToEventController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class SubmitApplicationToEventUI {
   
       private SubmitApplicationToEventController controller;
       
       public SubmitApplicationToEventUI(ExhibitionCentre centre){
           
        this.controller= new SubmitApplicationToEventController(centre);
        String description, keyTemp="", event="";
        int nInvites=-1, nKeywords=0, n=1, event_number=-1;
        double area=-1;
        List<String> keywords= new ArrayList<>(); 
        System.out.println("");        
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        System.out.println("           SUBMIT APPLICATION TO EVENT           ");
        System.out.println((char)27 + "[35m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ (char)27 + "[0m");  
        
        while(event_number==-1){
                System.out.println("--------------------------");
                System.out.println("          EVENTS          ");
                System.out.println("--------------------------");

                for (Event e : controller.getEventsReadyForApplications()) {
                        System.out.println(n+" - "+e.getTitle());
                        n++;
                    }
                System.out.println("--------------------------");

                try{
                        event_number = Integer.parseInt(Utils.readLineFromConsole("PICK EVENT: "));
                        if(event_number <1 || event_number>n){
                            Utils.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            event_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        event_number=-1;                            

                    }           
        }
        
        description = Utils.readLineFromConsole("DESCRIPTION: ");
        while(nInvites<0){
            try{
                nInvites = Integer.parseInt(Utils.readLineFromConsole("NUMBER OF INVITES: "));
                if(nInvites<0){
                 Utils.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER OR EQUAL TO 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        while(nKeywords<5){
                keyTemp=Utils.readLineFromConsole("ISERT A KEYWORD (MINUMUM 2 MAXIMUM 5) (WRITE X WHEN YOU ARE DONE): ");
                if(!keyTemp.equalsIgnoreCase("x")){
                    keywords.add(keyTemp);
                    nKeywords++;                   
                }else{
                   if(nKeywords<2){
                       
                        Utils.printError("YOU NEED AT LEAST 2 KEYWORDS.");
                       
                   }else{
                       break;
                   } 
                }
        }        
        while(area<=0){
            try{
                area = Double.parseDouble(Utils.readLineFromConsole("WANTED BOOTH AREA (m2): "));
                if(area<=0){
                 Utils.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER THAN 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                Utils.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        
        controller.setData(description,nInvites,keywords,area);
       }
}
